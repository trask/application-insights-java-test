# learn-azure

spring boot + azure application insights

## Structure

* Project root-public-service is the entry point in the microservice chain. Supported urls are
  * /sleepy-hello (a locally returning service)
  * /cibil (makes a call of the bar-service using webflux)
* Project bar-service is an internal microservice. Supported urls are
  * /random-cibil (a locally returning service)
  
## How to run
All services are based on spring boot 2.x. Hence the way to run these services by running the following
command
```
root-public-service $ mvn spring-boot:run
bar-service $ mvn spring-boot:run
```   

Ensure that application insights is configured by placing an file named *application-dev.properties* inside
the *src/main/resources* directory of each service. The file should contain the following
```
# Specify the instrumentation key of your Application Insights resource
azure.application-insights.instrumentation-key=[your ikey from the resource]
```
