[![Build Status](https://travis-ci.org/BassamAZ/FMS.svg?branch=master)](https://travis-ci.org/BassamAZ/FMS)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c6c3e8ecf59c4d529ae6f78c93d5fff5)](https://app.codacy.com/app/BassamAZ/FMS?utm_source=github.com&utm_medium=referral&utm_content=BassamAZ/FMS&utm_campaign=Badge_Grade_Dashboard)

[![codecov](https://codecov.io/gh/BassamAZ/FMS/branch/master/graph/badge.svg)](https://codecov.io/gh/BassamAZ/FMS)


[![Sonar](https://sonarcloud.io/api/project_badges/measure?project=BassamAZ_FMS&metric=reliability_rating
)](https://sonarcloud.io/dashboard?id=BassamAZ_FMS)

[![Sonar](https://sonarcloud.io/api/project_badges/measure?project=BassamAZ_FMS&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=BassamAZ_FMS)

# **Fleet Management System**

**An easy way to manage your fleet.**

FMS portal screenshot:
<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/application_screenshot.png" width="800">
</p>



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
<img src="https://github.com/BassamAZ/FMS/blob/master/img/architecture.png" width="600">
</p>

## **Functional services**

FMS will be decomposed into three core microservices. All of them are independently deployable applications, organized around certain business domains.

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/fleet_functional_services.png" width="600">
</p>

**Vehicle service**

Contains general vehicle methods which commonly used by other clients: retrieve vehicle details and register/update vehicle data.

| Method | Path                | Description                  | User authenticated | Available from UI |
|--------|---------------------|------------------------------|--------------------|-------------------|
| GET    | /vehicle/{id}      | Get specified vehicle data   |                    |                   |
| GET    | /vehicle/          | Get all vehicles data        |                    |                   |
| POST   | /vehicle/{vehicle} | Register/Update vehicle data |                    |                   |


**Customer service**

Contains general customer methods which commonly used by other clients: retrieve customer details and register/update customer data.

| Method | Path           | Description                 | User authenticated | Available from UI |
|--------|----------------|-----------------------------|--------------------|-------------------|
| GET    | /customer/{id} | Get specified customer data |                    |                   |
| GET    | /customer/     | Get all customers data      |                    |                   |
| POST   | /customer/     | Crate/Update customer data  |                    |                   |

**Status service**

Preform calculations on specific data values and capture updated time stamp for each vehicle. This data is used to track the vehicle status.

| Method | Path                | Description         | User authenticated | Available from UI |
|--------|---------------------|---------------------|--------------------|-------------------|
| GET    | /status/{vehicleId} | Get specific status |                    |                   |
| GET    | /status/            | Get all status data |                    |                   |

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
<img src="https://github.com/BassamAZ/FMS/blob/master/img/Fleet_Infrastructure.png" width="800">
</p>

## **Config service**

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

```
spring:
  application:
    name: vehicle-service
  cloud:
    config:
      uri: http://config:8888
      fail-fast: true
```

With Spring Cloud Config, you can change app configuration dynamically.

**Notes**

- There are some limitations for dynamic refresh though. @RefreshScope doesn't work with @Configuration classes and doesn't affect @Scheduled methods.
- fail-fast property means that Spring Boot application will fail startup immediately, if it cannot connect to the Config Service.


##  **API Gateway**

The API Gateway is the single entry point for all clients. It handles requests in one of two ways. Some requests are simply proxied/routed to the appropriate service. It handles other requests by fanning out to multiple services.

In theory, a client could make requests to each of the microservices directly. But obviously, there are challenges and limitations with this option, like necessity to know all endpoints addresses, perform http request for each peace of information separately, merge the result on a client side. Another problem is non web-friendly protocols which might be used on the backend.

Usually a much better approach is to use API Gateway. It is a single entry point into the system, used to handle requests by routing them to the appropriate backend service or by invoking multiple backend services and aggregating the results. Also, it can be used for authentication, insights, stress and canary testing, service migration, static response handling, active traffic management.

I used Zuul as an implementation of API Gateway. The below snipped is what needs to be configured in this service in order to handle the routes.

```
zuul:
  routes:
    vehicle:
      url: http://fms-vehicle/fms/vehicle
      path: /fms/vehicle/**
```

In the above snipped we can see that whenever a request came to API Gateway which starts with ``/fms/vehicle`` will be routed to the exact ``fms-vehicle`` service.

There is no hardcoded address, as you can see. Zuul uses Service discovery mechanism to locate ``fms-vehicle`` service instances.

## **Service discovery & registry**

Service instances have dynamically assigned network locations. Moreover, the set of service instances changes dynamically because of auto-scaling, failures, and upgrades. Consequently, your client code needs to use a more elaborate service discovery mechanism.

Another commonly known architecture pattern is Service discovery. It allows automatic detection of network locations for service instances, which could have dynamically assigned addresses because of auto-scaling, failures and upgrades.

The key part of Service discovery is **Registry**. I use Netflix Eureka in this project. Eureka is a good example of the client-side discovery pattern, when client is responsible for determining locations of available service instances (using Registry server) and load balancing requests across them.

The below screenshots depects a read Eureka view of FMS application.

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/eureka.png" width="1000">
</p>


<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/eureka_instances.png" width="1000">
</p>


With Spring Boot, you can easily build Eureka Registry with spring-cloud-starter-eureka-server dependency, `@EnableEurekaServer` annotation and simple configuration properties.

Client support enabled with `@EnableDiscoveryClient` annotation an bootstrap.yml with application name:

```
spring:
  application:
    name: fms-vehicle
```

Now, on application startup, it will register with Eureka Server and provide meta-data, such as host and port, health indicator URL, home page etc. Eureka receives heartbeat messages from each instance belonging to a service. If the heartbeat fails over a configurable timetable, the instance will be removed from the registry.

Also, Eureka provides a simple interface, where you can track running services and a number of available instances: http://localhost:8761


## **Load balancer, Circuit breaker and Http client**

Here we are going to talk about an important tools and a mechanism behind which will be used in my services to increase the relibaility and availavilty of those services.

**Ribbon**

Ribbon is a client side load balancer which gives you a lot of control over the behaviour of HTTP and TCP clients. Compared to a traditional load balancer, there is no need in additional hop for every over-the-wire invocation - you can contact desired service directly.

Out of the box, it natively integrates with Spring Cloud and Service Discovery. Eureka Client provides a dynamic list of available servers so Ribbon could balance between them.

**Hystrix**

Hystrix is the implementation of Circuit Breaker pattern, which gives a control over latency and failure from dependencies accessed over the network. The main idea is to stop cascading failures in a distributed environment with a large number of microservices. That helps to fail fast and recover as soon as possible - important aspects of fault-tolerant systems that self-heal.

Besides circuit breaker control, with Hystrix you can add a fallback method that will be called to obtain a default value in case the main command fails.

Moreover, Hystrix generates metrics on execution outcomes and latency for each command, that we can use to monitor system behavior.

**Feign**

Feign is a declarative Http client, which seamlessly integrates with Ribbon and Hystrix. Actually, with one spring-cloud-starter-feign dependency and `@EnableFeignClients` annotation you have a full set of Load balancer, Circuit breaker and Http client with sensible ready-to-go default configuration.

Here is an example from fms-simulator Service:

```
@FeignClient("fms-vehicle")
public interface VehicleClient {

    @GetMapping("/fms/vehicle")
    List<Vehicle> findAll();

    @PostMapping("/fms/vehicle/{id}")
    Optional<Vehicle> pulse(@PathVariable("id") String id);
}
```


Everything you need is just an interface
You can share `@RequestMapping` part between Spring MVC controller and Feign methods
Above example specifies just desired service id - ``fms-vehicle`` service, thanks to autodiscovery through Eureka (but obviously you can access any resource with a specific url)

## **Monitor dashboard**

In this project configuration, each microservice with Hystrix on board pushes metrics to Turbine via Spring Cloud Bus (with AMQP broker). The Monitoring project is just a small Spring boot application with Turbine and Hystrix Dashboard.

# **Infrastructure automation**

Deploying microservices, with their interdependence, is much more complex process than deploying monolithic application. It is important to have fully automated infrastructure. We can achieve following benefits with Continuous Delivery approach:

- The ability to release software anytime
- Any build could end up being a release
- Build artifacts once - deploy as needed

Here is a simple Continuous Delivery workflow, implemented in this project:

<p align="center">
<img src="https://github.com/BassamAZ/FMS/blob/master/img/Deployment_model.png" width="800">
</p>

In this configuration, Travis CI builds tagged images for each successful git push. So, there are always latest image for each microservice on Docker Hub and older images, tagged with git commit hash. It's easy to deploy any of them and quickly rollback, if needed.

**Important endpoints**

- http://localhost:80 - Gateway
- http://localhost:8761 - Eureka Dashboard
- http://localhost:8866/hystrix - Hystrix Dashboard 
- (Turbine stream link: http://turbine-stream-service:8020/turbine/turbine.stream)
- http://localhost:8050/swagger-ui.html - Swagger API docuemntation (Vehicle-API)
- 