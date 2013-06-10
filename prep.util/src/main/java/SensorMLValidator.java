import net.opengis.sensorML.x101.SensorMLDocument;


public class SensorMLValidator {
	public static SensorMLDocument parseSensorML(String s){
		try{
			/*
			 * Parses a given String as SensorMLDocument
			 */
			SensorMLDocument doc = SensorMLDocument.Factory.parse(s);
			return doc;
		}catch(Exception e){
			return null;
		}
	}
	
}
