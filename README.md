[![Build Status](https://travis-ci.org/egnaf/spring-boot-docker-example.svg)](https://travis-ci.org/egnaf/spring-boot-docker-example)
[![codecov](https://codecov.io/gh/egnaf/spring-boot-docker-example/branch/dev/graph/badge.svg)](https://codecov.io/gh/egnaf/spring-boot-docker-example)
# spring-boot-docker-example

## Stack
- Spring Boot 2.2.4
- Spring Data 2.2.4
- Postgres 42.2.16
- Docker 3.4
- Maven
- Tomcat 9

## Install
To build services and launch them in containers, you need to run the following command in the ``root`` folder of the project.
```bash
$ cd backend && mvn clean install && cp target/app.jar ../docker/ && cd ../docker && docker-compose down && docker-compose build && docker-compose up
```
## Logging
```bash
docker-compose logs backend | more  # backend related logs
docker-compose logs db | more       # postgresql related logs
docker-compose logs nginx | more    # nginx proxy related logs
```

## Access the containers from your browser
You need to first determine what is the address attributed to the container on your machine.
To do so, there's the following trick :

- Search ``localhost`` in your browser
- Open nginx logs by running ``docker-compose logs nginx | more`` in a terminal inside project root folder
- In logs, search ``'client: ...'``, the dots will give you an idea of the address

- Repeat the 2 first steps with the address you just found, built like this : ``http://<address_you_found>/api/users``
- Check the nginx logs once more
- But this time there will be the full address with the correct endpoint to users list,
in my case it was : ``http://172.30.0.3:5001/api/users``
- Now search this address in a browser with the port ``:8080``,
 like this : 
```bash 
http://172.30.0.3:8080/api/users
```
- Enjoy !

###Note
Applies when **frontend is ready** /!\

Do not forget to add the following location to ``.nginx/default.conf``.
```bash
location / {
  proxy_pass http://frontend:5002;
}
```

## License
Project is released under the [MIT](https://en.wikipedia.org/wiki/MIT_License).
