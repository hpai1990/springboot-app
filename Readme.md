# Springboot Example

### Build Application

```
mvn clean install
```

### Run Application
- If default application properties needs to be used then (In our example, profile is set to dev):
  > java -jar target/springboot-app-0.0.1-SNAPSHOT.jar
  
- If say application-prod.properties needs to be used then
  > java -jar -Dspring.profiles.active=prod target/springboot-app-0.0.1-SNAPSHOT.jar
  
### Swagger UI
- http://localhost:8080/swagger-ui.html