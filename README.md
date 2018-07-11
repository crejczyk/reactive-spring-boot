[![Build Status](https://travis-ci.org/crejczyk/reactive-spring-boot.svg?branch=master)](https://travis-ci.org/crejczyk/reactive-spring-boot)
![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)
![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.softmill.reactivespringboot%3Areactive-spring-boot&metric=alert_status)

## reactive-spring-boot


## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. MongoDB - 3.x.x

## Run MONGO using Docker for Windows
- `docker volume create --name=mongodata` 
- `docker run -d -p 27017:27017 -v mongodata:/data/db mongo`


```bash
mvn spring-boot:run
```

The server will start at <http://localhost:9000>.

## Exploring the Rest API

The application defines following REST APIs

```
1. GET /tweets - Get All Tweets

2. POST /tweets - Create a new Tweet

3. GET /tweets/{id} - Retrieve a Tweet by Id

3. PUT /tweets/{id} - Update a Tweet

4. DELETE /tweets/{id} - Delete a Tweet

4. GET /stream/tweets - Stream tweets to the browser
```
