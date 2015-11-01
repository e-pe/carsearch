package datacontract;

import dto.SearchResultsDto;

public class SearchResponse implements ISearchResponse {
    private SearchResultsDto searchResults;

    public SearchResultsDto getSearchResults() {
        return this.searchResults;
    }

    public SearchResponse setSearchResults(SearchResultsDto searchResults) {
        this.searchResults = searchResults;

        return this;
    }
}
