# Cloud-Based Internet of Things Data Interoperability Repository #
### BEng Final Year Project, Dept. of Automatic Control and Systems Engineering, The University of Sheffield, UK ###
This project designed and developed an Internet of Things, hub based interoperability framework. This projects uploaded to this software repository include:
* The [central hub](HubServer) which facilitates communication between IoT devices, the repository and a single user application
* The [repository](RepositoryInterface) which provides the hub with the transformation class name, from the [MySQL database](MySQLDatabase), when given a particular device ID
* The [user application](Application) that displays the transformed IoT device messages within the hub
* Simulation of three IoT devices, [a NEST thermostat](NESTSimulator), [a NEST camera](NESTCameraSimulator) and [an Ecobee Thermostat](EcobeeSimulator). 

## Getting Started ##
These instructions will get you up to speed with downloading and setting up each of the projects to simulate the interoperability framework either on your local machine or across distributed computers over the Internet.

### Prerequisites ###
Firstly, you will need to download all of the projects within the repository either to your computer of your choosing. **Important: Ensure that the [MySQL DDL](MySQLDatabase) is downloaded as well to recreate the structure and populate it with the device transformation class names**

All the projects have been packaged into the deploy folders which include:
* JAR files
* Java dependencies
* a default shell script to run each project

As only shell scripts have been provided the projects can only be run in an Linux environments.

### Installation ###
The only non-java dependency for the complete framework is the [MySQL database](https://dev.mysql.com/doc/refman/5.7/en/linux-installation.html). This database contains the mappings between IoT devices and the transformation class name. A SQL DDL and DML dump has been [provided](MySQLDatabase) to ensure that the same database structure is maintained. 

## Operation Instructions ##
**Operation of the interoperability framework is currently only supported in Linux.**

Operation of the interoperability framework is achieved by executing the included run.sh files. It is important that the hub, repository and application are shell scripts are executed first to ensure that the main network of the framework is operational. Once the interoperability network is operational, the simulators shell scripts can be executed.

## Built With ##
All development has taken place within the Ubuntu using the Eclipse Neon IDE. The IoT device transformation database is contained within a MySQL database.

The list, below, indicates the third-party java dependencies required for development:
* [JETTY](http://www.eclipse.org/jetty/download.html) - Used in the hub, repository and application to create web servers to facilitate the interoperability framework
* [Jackson](https://github.com/FasterXML/jackson) - Used throughout the framework to serialise and de-serialise JSON messages
* [Log4j](http://logging.apache.org/log4j/log4j-2.3/download.html)  - System Logger
* [JDBC](https://dev.mysql.com/downloads/connector/j/5.1.html)  - Java Database Connectivity library used to connect to the MySQL database containing the MySQL database

## Authors ##
* [Shameer Omar](https://uk.linkedin.com/in/shameeromar)

## License ##
This project is licensed under the Lesser GPL - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments ##
* Dr Ian Lilley - Dept. of Automatic Control and Systems Engineering, The University of Sheffield
