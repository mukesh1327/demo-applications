package com.cloudxplorer13.healthcaredemo.route;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.cloudxplorer13.healthcaredemo.config.KafkaConfig;
import com.cloudxplorer13.healthcaredemo.domain.Alert;
import com.cloudxplorer13.healthcaredemo.domain.HealthData;
import com.cloudxplorer13.healthcaredemo.service.AlertService;
import com.cloudxplorer13.healthcaredemo.service.AnalyticsService;
import com.cloudxplorer13.healthcaredemo.service.HealthDataService;

@Component
@RequiredArgsConstructor
public class HealthDataRoute extends RouteBuilder {
    private final KafkaConfig kafkaConfig;
    private final AlertService alertService;
    private final HealthDataService healthDataService;
    private final AnalyticsService analyticsService;

    @Override
    public void configure() {

        // Consume health data from Kafka, store it in DB, and generate alerts
        from("kafka:" + KafkaConfig.HEALTH_DATA_TOPIC + "?brokers=" + kafkaConfig.getKafkaBroker() + "&groupId=healthcare-group")
            .routeId("HealthDataRoute")
            .unmarshal().json(HealthData.class)
            .log("Received health data: ${body}")
            .process(exchange -> {
                HealthData data = exchange.getIn().getBody(HealthData.class);

                // Store data in PostgreSQL
                healthDataService.addHealthData(data);

                // Check thresholds & generate alerts
                alertService.checkThresholds(data);

                // Send data to analytics
                analyticsService.processData(data);
            });

        // Produce alerts to Kafka
        from("direct:sendAlert")
            .routeId("SendAlertRoute")
            .marshal().json()
            .to("kafka:" + KafkaConfig.ALERTS_TOPIC + "?brokers=" + kafkaConfig.getKafkaBroker())
            .log("Sent alert: ${body}");

        // Consume alerts from Kafka for API response
        from("kafka:" + KafkaConfig.ALERTS_TOPIC + "?brokers=" + kafkaConfig.getKafkaBroker() + "&groupId=alert-consumer")
            .routeId("AlertConsumerRoute")
            .unmarshal().json(Alert.class)
            .log("Consumed Alert: ${body}")
            .process(exchange -> {
                Alert alert = exchange.getIn().getBody(Alert.class);
                alertService.addAlert(alert);
            });
    }
}
