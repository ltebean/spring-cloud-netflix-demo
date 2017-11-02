Docker commands:


make image:
```
cd /account-server
mvn package
docker build -t account-service:v1 .
```

run an image:
```
docker run -p 9000:9000 account-service:v1
```

run in background:
```
docker run -p 9000:9000 -d account-service:v1
```

inspect containers:
```
docker ps
```


stop container:
```
docker container stop <container id>
```

init docker swarm:
```
docker swarm init
```

inspect docker swarm nodes:
```
docker node ls
```

run docker stack in swarm:
```
docker stack deploy -c docker_compose.yml <stack name>
```

inspect service:

```
docker service ls
```

scale service:
```
docker service scale account-service=<instance count>
```

stop stack:
```
docker stack rm <stack name>
```

create machine:
```
docker-machine create vm1
```

list machines:
```
docker-machine ls
```

run command in a machine:
```
docker-machine ssh vm1 "command"
```

copy image to a machine 
```
docker save account-service:v1 | (eval $(docker-machine env vm1) && docker load)
```

