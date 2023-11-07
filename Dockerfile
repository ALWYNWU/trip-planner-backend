FROM openjdk:17
COPY ./target/Trip_Planner-0.0.1-SNAPSHOT.jar Trip_Planner-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","Trip_Planner-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
