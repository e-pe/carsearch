package contract;

import contract.ISearchApplicationService;
import datacontract.ISearchRequest;
import datacontract.ISearchResponse;
import datacontract.SearchResponse;
import dto.SearchResultsDto;
import search.ISearchService;
import search.SearchQuery;
import search.SearchResult;
import translator.SearchResultTranslator;

import java.util.ArrayList;

public class SearchApplicationService implements ISearchApplicationService {
    private ISearchService searchService;

    public SearchApplicationService(ISearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public ISearchResponse performSearch(ISearchRequest request) {
        SearchQuery searchQuery = new SearchQuery(
                request.getQuery(),
                request.getLimit(),
                request.getOffset());

        ArrayList<SearchResult> searchResults = this.searchService
                .search(searchQuery, request.getSearchType());

        SearchResultsDto dto = new SearchResultTranslator()
                .translate(searchResults);

        SearchResponse response = new SearchResponse()
                .setSearchResults(dto);

        return response;
    }
}
