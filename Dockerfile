FROM openjdk:oraclelinux8
LABEL maintainer = "DangDucMinh"
COPY target/DemoDocker-0.0.1-SNAPSHOT.jar DemoDocker.jar
ENTRYPOINT ["java","-jar","DemoDocker.jar"]
EXPOSE 8080