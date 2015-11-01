package search;

import java.util.HashMap;

public class SearchResult extends HashMap<String, String> {
    private String searchType;

    public SearchResult(String searchType) {
        this.searchType = searchType;
    }
}
