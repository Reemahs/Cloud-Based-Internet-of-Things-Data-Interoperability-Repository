package iot.interop.safeshutdown;

/**
 * Stopable
 * This interface is used to ensure correct closure of servers.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public interface Stopable {
	public void stopService();
}
