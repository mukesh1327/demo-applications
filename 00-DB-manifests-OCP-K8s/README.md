# Database K8s Manifests

1. [Postgresql](./01-postgresql/README.md)

```shell script
oc new-project postgresdb-demo
oc create -f ./01-postgresql/ -n postgresdb-demo
```
