port=8081
repository_url=http://localhost:8080
application_url=http://localhost:8082
java -cp hubserver.jar:lib/servlet-api.jar:lib/jetty-all.jar:lib/jackson-annotations-2.8.7.jar:lib/jackson-core-2.8.7.jar:lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/iotcommon.jar:../../IoTCommon/deploy/lib/jackson-annotations-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-core-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/lib/log4j-api-2.3.jar:../../IoTCommon/deploy/lib/log4j-core-2.3.jar:../../IoTTransformations/deploy/iottransforms.jar iot.interop.hub.app.HubMain $port $repository_url $application_url
