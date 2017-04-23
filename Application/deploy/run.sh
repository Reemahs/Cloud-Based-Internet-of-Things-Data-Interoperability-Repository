port=8082
java -cp application.jar:lib/servlet-api.jar:lib/jetty-all.jar:../../IoTCommon/deploy/iotcommon.jar:../../IoTCommon/deploy/lib/log4j-api-2.3.jar:../../IoTCommon/deploy/lib/log4j-core-2.3.jar iot.interop.application.app.ApplicationLauncher $port
