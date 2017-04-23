port=8080 
db_url=jdbc:mysql://localhost/transformation_maps? 
username=root 
password=P38light
java -cp repository.jar:lib/Jetty/servlet-api.jar:lib/Jetty/jetty-all.jar:lib/mysql-connector-java-5.1.41/mysql-connector-java-5.1.41-bin.jar:../../IoTCommon/deploy/iotcommon.jar:../../IoTCommon/deploy/lib/jackson-annotations-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-core-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/lib/log4j-api-2.3.jar:../../IoTCommon/deploy/lib/log4j-core-2.3.jar iot.interop.repository.app.RepositoryLauncher $port $db_url $username $password
