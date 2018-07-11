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
