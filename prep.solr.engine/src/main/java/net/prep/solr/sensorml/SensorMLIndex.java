package net.prep.solr.sensorml;

import net.opengis.sensorML.x101.SensorMLDocument.SensorML;

public interface SensorMLIndex {
	public void index(SensorML doc)throws Exception;

}
