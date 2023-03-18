FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY . / . /
ENTRYPOINT ["java","-jar","/app.jar"]