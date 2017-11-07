# simple stream application
## issues
### first `No suitable service info creator found for service config-server...`
```
2017-10-18T15:28:25.94-0500 [APP/TASK/stream-app/0] OUT 2017-10-18 20:28:25.932 INFO 7 --- [      main] pertySourceApplicationContextInitializer : Adding 'cloud' PropertySource to ApplicationContext
2017-10-18T15:28:26.03-0500 [APP/TASK/stream-app/0] OUT 2017-10-18 20:28:26.030 WARN 7 --- [      main] o.c.r.o.s.cloud.AbstractCloudConnector  : No suitable service info creator found for service circuit-breaker-dashboard Did you forget to add a ServiceInfoCreator?
2017-10-18T15:28:26.03-0500 [APP/TASK/stream-app/0] OUT 2017-10-18 20:28:26.030 WARN 7 --- [      main] o.c.r.o.s.cloud.AbstractCloudConnector  : No suitable service info creator found for service service-registry Did you forget to add a ServiceInfoCreator?
2017-10-18T15:28:26.03-0500 [APP/TASK/stream-app/0] OUT 2017-10-18 20:28:26.030 WARN 7 --- [      main] o.c.r.o.s.cloud.AbstractCloudConnector  : No suitable service info creator found for service config-server Did you forget to add a ServiceInfoCreator?
```

### second 
`Unsatisfied dependency expressed through field ‘nonSecurePort’; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert value of type ‘java.lang.String’ to required type ‘int’; nested exception is java.lang.NumberFormatException: For input string: “”`

## how to reproduce
The project has a pre-built dependency on Spring Cloud Service Eureka and RabbitMQ. The `manifest.yml` specifies them as `service-registry` and `rabbitmq`.

Deploy this application to PCF with the provided manifest, then added the app to scdf (referencing a location in maven for the artifact)

Using SCDF CLI or via the UI

### register the application

`app register --name stream-app --type task --uri maven://com.example:stream-app:0.0.1-SNAPSHOT`

### Create the task

`task create stream-app --definition "stream-app"`

Execute the task and provided no additional arguments or properties. The above logs are may be produced in the deployed SCDF instance. 
