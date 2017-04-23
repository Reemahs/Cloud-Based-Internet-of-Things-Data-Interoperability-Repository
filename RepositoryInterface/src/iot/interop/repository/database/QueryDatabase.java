package iot.interop.repository.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import iot.interop.logger.SystemLog;
import iot.interop.repository.data.DeviceResponse;

/**
 * QueryDatabase
 * This class is responsible for establishing a connection to the MySQL database using the Java Database Connection API and 
 * querying it for the transformation class name given the IoT devices identifier.
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class QueryDatabase {
	private Connection databaseConnection = null;
	private SystemLog databaseLogger = new SystemLog(QueryDatabase.class);
	
	/**
	 * QueryDatabase constructor which establishes a connection to the MySQL database.
	 * @param url MySQL database URL
	 * @param userName MySQL username
	 * @param password MySQL password
	 */
	public QueryDatabase (String url, String userName, String password){
		databaseLogger.logDebug("Attempting Database Connection");
		try{
			// Open database connection
			Class.forName("com.mysql.jdbc.Driver");
			databaseConnection = DriverManager.getConnection(url, userName, password);
			databaseLogger.logDebug("Connection Success");
		} catch (Exception error) {
			databaseLogger.logDebug("Connection Failed");
			databaseLogger.logError(error.toString());
		}
	}
	
	/**
	 * Query the open database for the transformation class name for the given device identifier
	 * @param deviceID IoT device identifier as string
	 * @return The device response object
	 * @throws Exception Throws exception for any error encountered while querying the database
	 */
	public DeviceResponse getTransformationClass (String deviceID) throws Exception{
		PreparedStatement databasePrepStatement = null;
		ResultSet databaseResults = null;
		DeviceResponse deviceTransformation = null;
		
	
		databaseLogger.logDebug("Querying Database for: " + deviceID);
		// Query Message Construction
		databasePrepStatement = databaseConnection.prepareStatement("SELECT transformation_class, device_id, software_version FROM mapping JOIN dev_table ON mapping.device_ref = dev_table.id WHERE device_id = ?");
		databasePrepStatement.setString(1, deviceID);
		
		// Sending query to database
		databaseResults = databasePrepStatement.executeQuery();
		
		databaseLogger.logDebug("Coverting response to POJO");
		if(databaseResults.next()){
			deviceTransformation = new DeviceResponse (deviceID, databaseResults.getString(1));
		} else {
			deviceTransformation = new DeviceResponse (deviceID, null);
		}
		
		// Close database connection
		close(databasePrepStatement);
		close(databaseResults);
		
		return deviceTransformation;
	}
	
	/**
	 * This method is used when the connection to the database is closed
	 * @param closeable
	 * @throws Exception
	 */
	private void close (AutoCloseable closeable) throws Exception{
		databaseLogger.logDebug("Attempting Closure of: " + closeable.toString());
		if (closeable != null){
			closeable.close();
			databaseLogger.logDebug("Closure Successful");
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void closeDatabseConnection () throws Exception{
		databaseLogger.logDebug("Closing Database Connection");
		close(databaseConnection);
		databaseLogger.logDebug("Database Connection Closed");
	}
}
