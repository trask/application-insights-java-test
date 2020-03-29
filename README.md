# learn-azure

spring boot + azure application insights

## Structure

* Project root-public-service is the entry point in the microservice chain. Supported urls are
  * /sleepy-hello (a locally returning service)
  * /remote-cibil (makes a call of the bar-service using webflux)
* Project bar-service is an internal microservice. Supported urls are
  * /cibil (a locally returning service)
  
## How to run

Ensure that application insights is configured by adding your instrumentation key to the `ApplicationInsights.json` file in the root directory of each service.

All services are based on spring boot 2.x. Hence the way to run these services by running the following
command
```
root-public-service $ mvn spring-boot:run -Dspring-boot.run.agents=applicationinsights-agent-3.0.0-PREVIEW-SNAPSHOT.jar
bar-service $ mvn spring-boot:run -Dspring-boot.run.agents=applicationinsights-agent-3.0.0-PREVIEW-SNAPSHOT.jar
```   
