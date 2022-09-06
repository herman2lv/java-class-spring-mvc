# Java Class - Training Course

## Spring MVC Demo

#### Author: Herman Rabinkin

This repository contains examples which can help to explain and understand basic Spring MVC configuration without Spring
Boot autoconfiguration help

Application intended to be deployed at the Tomcat 9 or any other servlet container that supports Servlet of version 4
and JSP of version 2.3.

### Spring Application Config

[_Spring Application Config_](/src/main/java/com/hrm/springmvcdemo/ApplicationConfig.java)
General Spring Application Java-based configuration file with enabled annotation-based config (```@ComponentScan```)

* Configuration class extends ```WebMvcConfigurationSupport``` to
  override```void addResourceHandlers(ResourceHandlerRegistry registry)``` method to register resource handlers and
  their locations.
* ```InternalResourceViewResolver``` registered as ```@Bean``` to enable JSP processing
* ```@Bean EntityManagerFactory``` and ```@Bean TransactionManager``` as well as class-level
  annotation ```@EnableTransactionManagement``` are used for work with JPA and JTA

### Web Application Initializer

[_Web Application Initializer_](/src/main/java/com/hrm/springmvcdemo/WebInitializer.java)
Application entry point. Used to load Spring Application Context and register servlet programmatically (instead
of ```web.xml```-based configuration)

### Web Application Configuration

[_Web Application Configuration_](/src/main/webapp/WEB-INF/web.xml)
Xml-based web application configuration file with additional configuration of web app. Location is in compliance with
Java EE specifications
