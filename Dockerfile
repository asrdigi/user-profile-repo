# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY /target/userprofile-service-0.0.1-SNAPSHOT.war /userprofile-service.war 
# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/userprofile-service.war"]