# Demos for Spring Cloud Finchley Releasetrain

This project includes demos for Spring Cloud Finchley Release

## Target of this project

Provide small demos for most of the spring cloud parts like
* Spring Cloud Function
* Spring Cloud Gateway  
* Spring Cloud Config
* Spring Cloud Stream
* Spring Cloud Sleuth
* Spring Cloud Consul
* Spring Cloud Contract
* Spring Cloud Vault
* ...

## Technical constraints
  
* All components should connect securely e.g. using HTTPS only
* All components should use HTTP/2 protocol instead of HTTP 1.1 (if possible)  
    
## Available demo applications

* customer-backend: A reactive spring boot 2 web application (netty, reactor, webflux, reactive mongodb)
* book-backend: A blocking spring boot 2 web application (tomcat, spring mvc, jpa, h2) 
* cloud-gateway-server: Spring cloud gateway application

## Known issues

* Currently spring cloud gateway does not support HTTP/2: https://github.com/spring-cloud/spring-cloud-gateway/issues/7
* Currently spring cloud gateway only runs on Netty, not on Tomcat etc.: https://github.com/spring-cloud/spring-cloud-gateway/issues/145
* Currently spring webflux on Netty does not support HTTP/2 (due to reactor-netty): https://github.com/reactor/reactor-netty/issues/104 


