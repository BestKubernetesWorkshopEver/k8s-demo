## Welcome to kubernetes workshop

To start the application run following commands:
* start mongodb

```sudo docker run -d -p 27017:27017 -v /data/db mongo ```

* build runnable uber jars

``mvn clean package``

* start frontend jar
 
``java -jar frontend-service/target/frontend-service-0.0.1-SNAPSHOT.jar``

* start backend jar

``java -jar backend-service/target/backend-service-0.0.1-SNAPSHOT.jar``


## Run on Minikube
`minikube start --vm-driver=hyperv --memory='4000mb' --cpus=4`  
`kubectl apply -f k8s`  
Access frontend at http://<minikube_ip>:30000

## Verification of each pod

### Mongo
`kubectl exec -it <mongo_pod_name> -- mongo --eval "db.adminCommand('ping')"`

### Backend
`kubectl exec -it <backend_pod_name> -- wget localhost:8080/actuator/health`

### Frontend
`kubectl exec -it <frontend_pod_name> -- wget localhost:8888/actuator/health`