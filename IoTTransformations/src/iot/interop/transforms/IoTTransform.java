package iot.interop.transforms;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * IoTTransform
 * This interface is used by each individual transform class for IoT interoperbility transformation.
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public interface IoTTransform {
	public JsonNode transformDevice (JsonNode deviceJson) throws Exception;
}
