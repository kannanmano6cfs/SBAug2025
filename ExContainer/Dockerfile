#Get JDK dependencies to run the application
FROM openjdk:21-slim

#Set the working directory as intermediate
WORKDIR /app

#Copy the fat jar
COPY target/ExContainer-0.0.1-SNAPSHOT.jar app.jar

#Expose the port number
EXPOSE 8081

#Execute the jar 
ENTRYPOINT ["java","-jar","app.jar"]