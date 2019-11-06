### Welcome to kubernetes workshop

To star the application run following commands:
* start mongodb

```sudo docker run -d -p 27017:27017 -v /data/db mongo ```

* build runnable uber jars

``mvn clean package``

* start frontend jar
 
``java -jar frontend-service/target/frontend-service-0.0.1-SNAPSHOT.jar``

* start backend jar

``backend-service/target/backend-service-0.0.1-SNAPSHOT.jar``

