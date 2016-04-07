The project includes:

### eureka-server
Eureka is a service registry, we can start a eureka server by running this project

### account-service
This module acts as a micro service, in includes:
* account-api: defines the api of this service
* account-server: includes the implementation and you can run this service through `AccountServerApplication`, when it starts to run, it will register itself to eureka

### client-app
It consumes the account-service
