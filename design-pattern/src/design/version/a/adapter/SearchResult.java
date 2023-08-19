package design.version.a.adapter;

import java.util.List;

public class SearchResult {
    private final List<SearchDocument> docs;

    public SearchResult(List<SearchDocument> docs) {
        this.docs = docs;
    }
}
