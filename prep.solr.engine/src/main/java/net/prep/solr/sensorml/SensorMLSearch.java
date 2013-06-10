package net.prep.solr.sensorml;

import java.util.List;

public interface SensorMLSearch {
	
	public List<Object> getForQuery(String query)throws Exception;

}
