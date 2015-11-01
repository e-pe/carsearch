package search;

import java.util.ArrayList;

public interface ISearchService {
    ArrayList<SearchResult> search(SearchQuery searchQuery, String searchType);
}
