# PROJETO DO DESAFIO BACKEND JAVA

Para subir o projeto sem problemas, é necessário que as portas ```5672, 15672, 5432``` e ```8080``` estejam disponíveis.
Após as portas estarem disponíveis, é necessário rodar o scrip ```./configure ```, localizado na raiz do repository para que o projeto suba.

## Endpoint para enviar para fila a notificação:
#### POST http://localhost:8080/notification

body: 
 ``` 
    {
	    "notification_type" : "String",
	    "subscription": "String"
    }
```
## RabbitMQ:
#### http://localhost:15672/
```
    user: guest
password: guest
```

## Postgresql:
#### jdbc:postgresql://localhost:5432/postgres
```
    user: postgres
password: postgres
```