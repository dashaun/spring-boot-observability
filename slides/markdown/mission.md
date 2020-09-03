## I was on a mission

I found Dropwizard

Notes:
- I needed metrics


## I was introduced to Spring Boot

The actuator was like a dream come true.

Notes:
- The health endpoint
- The metrics endpoint
- start.spring.io


## A simple RESTful service

 - https://start.spring.io
 
Notes:
- For the sake of time - This is pre built with some changes
- Lombok
- Spring Sleuth
- Spring Web
- Spring Boot Actuator
- Wavefront


## Follow along

https://github.com/dashaun/spring-boot-observability

Notes:
- This is the code
- I'm going to use the code to talk about part of my journey
- It's a reference


## The actuator alone

Health!


## Metrics

No need for production access.
- Internal route allowed /metrics
- External routes did not allow /metrics

Notes:
- We had our internal network 10.x.x.x
- Our external network didn't allow traffic to the /metrics endpoints
- Stopped at F5/Load balancer
- Just as easily Nginx/Apache Proxy/Ingress Controller


## Custom Metrics and Micrometer

- Add a Meter Registry to store metrics
- Automatically exposed

Notes:
- Vendor-neutral application metrics facade
- Think SLF4J, but for metrics
- Datadog, Dynatrace, Prometheus, Wavefront and many others


#### Next