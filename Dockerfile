# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=build/libs/samedaydelivery-1.jar

ADD ${JAR_FILE} samedaydelivery-1.jar

# Run the jar file

ENTRYPOINT ["java","-jar","/samedaydelivery-1.jar"]




