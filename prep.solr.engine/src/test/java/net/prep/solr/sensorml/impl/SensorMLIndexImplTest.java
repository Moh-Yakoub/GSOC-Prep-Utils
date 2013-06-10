package net.prep.solr.sensorml.impl;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;

import net.opengis.sensorML.x101.AbstractProcessType;
import net.opengis.sensorML.x101.KeywordsDocument.Keywords;
import net.opengis.sensorML.x101.SensorMLDocument;
import net.opengis.sensorML.x101.SensorMLDocument.SensorML;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

public class SensorMLIndexImplTest {
	/*
	 * A simple test to test if it index without errors
	 */
	@Test
	public void setup() {
		try {
			SensorMLDocument s = SensorMLDocument.Factory.parse(ClassLoader.getSystemResourceAsStream("testsensor.xml"));
			SensorML sensor = s.getSensorML();
			/*
			 * Just delete all the old indexed - for testing inly
			 */
			SensorMLIndexImpl impl = new SensorMLIndexImpl();
			impl.deleteAll();
			System.out.println("Deleted successfully");
			
			impl.index(sensor);
			
			System.out.println("Successfully indexed");
			
			
			
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			fail(e.toString());
		//	e.printStackTrace();
		} catch (IOException e) {
			fail(e.toString());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			fail(e.toString());
		}
	}
}
