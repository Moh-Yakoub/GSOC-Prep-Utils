package net.n52north.remoteAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import net.n52north.validator.SensorMLValidator;
import net.opengis.sensorML.x101.SensorMLDocument;
import net.opengis.sensorML.x101.SensorMLDocument.SensorML;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class remoteParser {
	
	 
	public SensorMLDocument parseRemoteAddresses(String addr) throws URISyntaxException{
		HttpGet get = new HttpGet(addr+Constants.ALLSENSORS);
		HttpClient client = new DefaultHttpClient();	
		try {
			HttpResponse response = client.execute(get);

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String s = "";
			String k = "";
			while((s=reader.readLine())!=null)
				k+=s;
			
			return SensorMLValidator.parseSensorML(k);
			
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
