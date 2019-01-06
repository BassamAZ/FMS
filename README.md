# **Fleet Management System**

**An easy way to manage your fleet.**

The purpose of Fleet Management in a business is to ensure the work vehicles of a business are operating smoothly, are constantly seeking ways to improve performance, are able to keep operation costs at a minimum, and maintain compliance with company regulations.

**Fleet management system (FMS)** : is the applications, tools, technologies and practices that help businesses maintain optimal use of their work vehicles from a central platform. 

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/fms.png" width="400">
</p>

## **Required Scope**

We have the below assumption and considerations of the required business:

- We have a number of connected vehicles that belongs to a number of customers.
- We have a need to be able to view the status of the connection among these vehicles on a monitoring display.
- The vehicles send the status of the connection one time per minute.
- The status can be compared with a ping (network trace); no request from the vehicle means no connection. 
- So, vehicle is either Connected or Disconnected.


## **Task**
- The task is to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
- Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
- This can either be solved by using static values or by creating a separate machinery that returns random fake status.

## **Requirements**
1. Web GUI (Single Page Application Framework/Platform).
	 - An overview of all vehicles should be visible on one page (full-screen display), together with their status.
	 - It should be able to filter, to only show vehicles for a specific customer.
	 - It should be able to filter, to only show vehicles that have a specific status.
2. Random simulation to vehicles status sending.

# **Architecture**
We will build the required FMS using Microservices Architecture using Spring Boot, Spring Cloud and Docker. With a pretty neat user interface, by the way.

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/architecture.png" width="400">
</p>

## **Functional services**

FMS will be decomposed into three core microservices. All of them are independently deployable applications, organized around certain business domains.

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/fleet_functional_services.png" width="400">
</p>

**Vehicle service**

Contains general vehicle methods which commonly used by other clients: retrieve vehicle details and register/update vehicle data.

| Method | Path                | Description                  | User authenticated | Available from UI |
|--------|---------------------|------------------------------|--------------------|-------------------|
| GET    | /vehicles/{vehicle} | Get specified vehicle data   |                    |                   |
| GET    | /vehicles/          | Get all vehicles data        |                    |                   |
| POST   | /vehicles/{vehicle} | Register/Update vehicle data |                    |                   |


**Customer service**

Contains general customer methods which commonly used by other clients: retrieve customer details and register/update customer data.


**Status service**

Preform calculations on specific data values and capture updated time stamp for each vehicle. This data is used to track the vehicle status.


Notes:

-	Most microservices have their own database, so there is no way to bypass API and access persistence data directly.
-	Some business transactions need to query data that is owned by multiple services. For example, the Status service must query the Vehcle to calculate the status and Customer to associate it to the vehicle.
-	Using a database per service has the following benefits:
    -	Helps ensure that the services are loosely coupled. Changes to one service’s database does not impact any other services.
    - Each service can use the type of database that is best suited to its needs. For example, a service that does text searches could use ElasticSearch. A service that manipulates a social graph could use Neo4j.
- In this project, I use MongoDB as a primary database for each service.
- Service-to-service communication is quite simplified: microservices talking using only synchronous REST API. Common practice in a real-world systems is to use combination of interaction styles. For example, perform synchronous GET request to retrieve data and use asynchronous approach via Message broker for create/update operations in order to decouple services and buffer messages. However, this brings us to the eventual consistency world.

## **Infrastructure services**

In microservice architecture are we have a set of methodologies and patterns which we need to follow in order to have a solid architecture and avoid most common problems. Spring Cloud has proven the way of building microservice infrastructure with an easy way. 

As I earlier that I’m going to use Spring Cloud to build this project. Let’s discover this area in terms of architecture, implementations and benefits.

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/Fleet_Infrastructure.png" width="400">
</p>

## Config service

**Spring Cloud Config** provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments. It is horizontally scalable centralized configuration service for distributed systems which uses a pluggable repository layer that currently supports local storage, Git, and Subversion.

**Features**

Spring Cloud Config Server features:

- HTTP, resource-based API for external configuration (name-value pairs, or equivalent YAML content)
- Encrypt and decrypt property values (symmetric or asymmetric)
- Embeddable easily in a Spring Boot application using @EnableConfigServer


Config Client features (for Spring applications):

- Bind to the Config Server and initialize Spring Environment with remote property sources
- Encrypt and decrypt property values (symmetric or asymmetric)


**Client-side usage**

Any client can point to this service in order to load any configuration needed hence you don’t need to lead any properties in your application.

Just provide bootstrap.yml with application name and Config service url:

spring:
  application:
    name: vehicle-service
  cloud:
    config:
      uri: http://config:8888
      fail-fast: true

With Spring Cloud Config, you can change app configuration dynamically.

**Notes**

- There are some limitations for dynamic refresh though. @RefreshScope doesn't work with @Configuration classes and doesn't affect @Scheduled methods.
- fail-fast property means that Spring Boot application will fail startup immediately, if it cannot connect to the Config Service.
