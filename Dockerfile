FROM amazoncorretto:8-alpine-jdk

MAINTAINER belenportfolio

copy target/demo-0.0.1-SNAPSHOT.jar portafolio-belen.jar

entrypoint ["java","-jar","/portafolio-belen.jar"]