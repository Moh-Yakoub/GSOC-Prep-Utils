import java.awt.image.RescaleOp;
import java.io.IOException;
import java.net.MalformedURLException;

import net.opengis.sensorML.x101.SensorMLDocument;
import net.opengis.sensorML.x101.SensorMLDocument.SensorML;
import net.prep.solr.sensorml.impl.SensorMLIndexImpl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.handler.component.ResponseBuilder;
import org.apache.xmlbeans.XmlException;

public class simple {
	static String url = "http://localhost:8983/solr";

	public static void main(String args[]) throws Exception {
		SolrServer server = new HttpSolrServer(url);

		/*
		 * SolrQuery query = new SolrQuery(); query.setQuery("solr");
		 * QueryResponse reponse = server.query(query); SolrDocumentList list =
		 * reponse.getResults(); // for(int i=0;i<list.size();i++)
		 * System.out.println(list.get(i));
		 */

		SensorMLDocument s = SensorMLDocument.Factory.parse(ClassLoader.getSystemResourceAsStream("testsensor.xml"));
		SensorML sensor = s.getSensorML();
		SensorMLIndexImpl impl = new SensorMLIndexImpl();
		impl.index(sensor);
	}

}
