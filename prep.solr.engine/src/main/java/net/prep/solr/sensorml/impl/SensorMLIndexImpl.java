package net.prep.solr.sensorml.impl;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import net.opengis.sensorML.x101.AbstractProcessType;
import net.opengis.sensorML.x101.KeywordsDocument.Keywords;
import net.opengis.sensorML.x101.KeywordsDocument.Keywords.KeywordList;
import net.opengis.sensorML.x101.SensorMLDocument.SensorML;
import net.prep.solr.sensorml.Constants;
import net.prep.solr.sensorml.SensorMLIndex;

public class SensorMLIndexImpl implements SensorMLIndex {
	private String url = "http://localhost:8983/solr";

	public void index(SensorML sensor) throws Exception {
		// TODO Auto-generated method stub
		SolrServer server = new HttpSolrServer(url);
		SolrInputDocument solrdoc = new SolrInputDocument();
		/*
		 * Simple fields added
		 */

		// Get the keywords list first
		AbstractProcessType process = sensor.getMemberArray()[0].getProcess();

		Keywords[] keywords = process.getKeywordsArray();
		KeywordList keywordList = (keywords[0].getKeywordList());
		String [] str_keywords = keywordList.getKeywordArray();
		solrdoc.addField("id",process.getId());
		System.out.println(process.getId());
		for(int i=0;i<str_keywords.length;i++)
			solrdoc.addField(Constants.KEYWORDS,str_keywords[i]);
		server.add(solrdoc);
		server.commit();
	}
}
