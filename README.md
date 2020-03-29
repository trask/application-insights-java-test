# learn-azure

spring boot + azure application insights

## Structure

* Project root-public-service is the entry point in the microservice chain. Supported urls are
  * /sleepy-hello (a locally returning service)
  * /remote-cibil (makes a call of the bar-service using webflux)
* Project bar-service is an internal microservice. Supported urls are
  * /cibil (a locally returning service)
  
## How to run
Ensure that you have the 
[3.0.0 private preview agent](https://github.com/trask/docs-work-in-progress/wiki/Application-Insights-Java-3.0-Private-Preview)
downloaded and saved at the top level directory of this project. 

All services are based on spring boot 2.x. Hence the way to run these services by running the following
command
```
root-public-service $ APPLICATIONINSIGHTS_CONNECTION_STRING=InstrumentationKey=[your ikey from the resource] mvn spring-boot:run
bar-service $ APPLICATIONINSIGHTS_CONNECTION_STRING=InstrumentationKey=[your ikey from the resource] mvn spring-boot:run
```   
