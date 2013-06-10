package net.n52north.remoteAPI;

import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpGet;

public class remoteParser {
	
	
	public void parseRemoteAddresses(String addr) throws URISyntaxException{
		HttpGet get = new HttpGet(addr);
	}
}
