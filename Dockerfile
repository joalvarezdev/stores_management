FROM joalvarezdev/springboot-alpine-17:latest

MAINTAINER joalvarez

COPY target/graphql-example.jar .

EXPOSE 8090

ENTRYPOINT ["java","-jar","graphql-example.jar"]
