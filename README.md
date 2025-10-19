# **Web App Sandbox (WIP)**

## Simple Spring Boot sandbox web application. 

---
**Startup MySQL Container**
```declarative
cd docker/mysql
docker-compose up -d
```
*Note - change usernames and passwords in Dockerfile as desired* 

---
**Build & run app**
```declarative
./gradlew bootRun
```
*Note - update username and password in gradle properties*