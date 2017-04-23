main_file=/home/reemahs/EclipseProjects/Final_Year_Project/EcobeeSimulator/json
file_name=Ecobee_Thermostat_one.json
hub_url=http://localhost:8081
java -cp ecobeesimulator.jar:lib/jackson-annotations-2.8.7.jar:lib/jackson-core-2.8.7.jar:lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/iotcommon.jar:../../IoTCommon/deploy/lib/jackson-annotations-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-core-2.8.7.jar:../../IoTCommon/deploy/lib/jackson-databind-2.8.7.jar:../../IoTCommon/deploy/lib/log4j-api-2.3.jar:../../IoTCommon/deploy/lib/log4j-core-2.3.jar iot.interop.ecobeesim.sim.EcobeeThermostatSimulator $main_file $file_name $hub_url
