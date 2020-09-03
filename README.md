# Spring Boot Observability
## Code and slides from SpringOne 2020 session

## Getting Started

1.  Clone the repository
    ```
    git@github.com:dashaun/spring-boot-observability.git
    ```
2.  CD into the repository
    ```
    cd spring-boot-observability
    ```
3.  Run the code
    ```
    ./mvnw spring-boot:start
    ```    
4.  Use docker to serve the content
    ```
    docker run --name spring-boot-observability -v $PWD/slides:/usr/share/nginx/html:ro -d -p 8089:80 nginx
    ``` 
4.  Open browser to http://localhost:8089/
