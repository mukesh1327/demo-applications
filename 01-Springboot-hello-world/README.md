# Java Spring hello world - Noventiq value point

__A demo hello world java spring boot application__

___Running on port :___ 8080

___Endpoints :___   
    /

___Environment variables :___   
APP_TITLE=string


## How to run in local

> mvn spring-boot:run 

## Run as container

> podman build -t springboot-hello:v1.0 -f ./docker/Dockerfile .

> podman run -d -p 8080:8080 --name springboot-hello springboot-hello:v1.0

## Deploy in k8s-ocp

> oc apply -f ./k8s-manifests -n demo-namespace