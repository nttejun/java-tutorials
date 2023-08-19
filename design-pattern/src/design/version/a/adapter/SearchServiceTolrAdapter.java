package design.version.a.adapter;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceTolrAdapter implements SearchService {
    private TolrClient tolrClient = new TolrClient();

    public SearchResult search(String keyword) {
        TolrQuery tolrQuery = new TolrQuery(keyword);
        QueryResponse response = tolrClient.query(tolrQuery);
        SearchResult result = convertToResponse(response);
        return result;
    }

    private SearchResult convertToResponse(QueryResponse response) {
        List<TolrClient> tolrDocs = (List<TolrClient>) response.getDocumentList().getDocument();
        List<SearchDocument> docs = new ArrayList<SearchDocument>();
        for (ToirDocument tolrDoc : tolrDocs) {
            docs.add(new SearchDocument(tolrDoc.getId()));
        }
        return new SearchResult(docs);
    }
}
