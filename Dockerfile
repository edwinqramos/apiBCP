FROM openjdk:11
LABEL maintainer="edwinqramos@gmail.com"
WORKDIR /workspace

COPY ./target/api*.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/workspace/app.jar"]
EXPOSE 8080