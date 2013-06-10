import static org.junit.Assert.fail;
import net.opengis.sensorML.x101.SensorMLDocument;

import org.junit.Test;

public class SensorMLValidatorTest {
	@Test
	public void setup() {
		try {
			SensorMLDocument s = SensorMLDocument.Factory.parse(ClassLoader
					.getSystemResourceAsStream("testsensor.xml"));
			
			SensorMLDocument doc = SensorMLValidator.parseSensorML(s.toString());
			
			if(doc == null)
				fail("Cannot parse SensorMLDocument");
			
		} catch (Exception e) {
			fail("Couldn't read the sensor data:" + e.toString());
		}

	}

}
