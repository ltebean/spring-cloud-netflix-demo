The project includes:

### eureka-server
Eureka is a service registry, you can start a eureka server by running this project, and you can view the dashboard at http://localhost:8761

### account-service
This module acts as a micro service, in includes:
* account-api: defines the api of this service
* account-server: includes the implementation and you can run this service through `AccountServerApplication`, when it starts to run, it will register itself to eureka

Once you run `account-server`, it will register itself to eureka.

### account-web
It consumes the account-service
