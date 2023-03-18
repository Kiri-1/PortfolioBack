FROM amazoncorretto:8-alpine-jdk

MAINTAINER belenportfolio

COPY target/demo-0.0.1-SNAPSHOT.jar portafolio-belen.jar

ENTRYPOINT ["java","-jar","/portafolio-belen.jar"]