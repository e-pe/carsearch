package search;

import java.util.ArrayList;

public interface ISearchPerformer {
    ArrayList<SearchResult> performSearch(SearchQuery query);
}
