REGISTER: POST  http://localhost:8084/eureka/v2/apps/song-microservice

ALTER STATUS TO UP: PUT http://localhost:8084/eureka/v2/apps/song-microservice/localhost/status?value=UP