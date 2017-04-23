main_file=/home/reemahs/EclipseProjects/Final_Year_Project/NESTCameraSimulator/json
file_name=NEST_Camera_One.json
hub_url=http://localhost:8081
java -cp nestcamerasimulator.jar:lib/jackson-annotations-2.8.7.jar:lib/jackson-core-2.8.7.jar:lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/iotcommon.jar:../../IoTCommon/deploy/lib/jackson-annotations-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-core-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/lib/log4j-api-2.3.jar:../../IoTCommon/deploy/lib/log4j-core-2.3.jar iot.interop.nestcamsim.sim.NestCamSimulator $main_file $file_name $hub_url
