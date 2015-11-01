package dto;

import java.util.ArrayList;

public class SearchResultsDto {
    private ArrayList<SearchResultDto> results;

    public SearchResultsDto(ArrayList<SearchResultDto> results){
        this.results = results;
    }

    public ArrayList<SearchResultDto> asList(){
        return this.results;
    }
}
