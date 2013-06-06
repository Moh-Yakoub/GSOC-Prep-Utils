import java.awt.image.RescaleOp;
import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.handler.component.ResponseBuilder;

public class simple {
	static String url = "http://localhost:8983/solr";

	public static void main(String args[]) throws MalformedURLException, SolrServerException {
		SolrServer server = new HttpSolrServer(url);
		
		SolrQuery query = new SolrQuery();
		query.setQuery("solr");
		QueryResponse reponse =  server.query(query);
		SolrDocumentList list  = reponse.getResults();
		//
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
	}

}
