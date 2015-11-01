package translator;

import dto.SearchResultDto;
import dto.SearchResultsDto;
import search.SearchResult;

import java.util.ArrayList;
import java.util.Map;

public class SearchResultTranslator {
    public SearchResultsDto translate(ArrayList<SearchResult> searchResults){
        ArrayList<SearchResultDto> translatedSearchResults = new ArrayList<>();

        for(SearchResult searchResult : searchResults){
            SearchResultDto translatedSearchResult = new SearchResultDto();

            for(Map.Entry<String, String> entry : searchResult.entrySet()){
                translatedSearchResult.put(entry.getKey(), entry.getValue());
            }

            translatedSearchResults.add(translatedSearchResult);
        }

        return new SearchResultsDto(translatedSearchResults);
    }
}
