package datacontract;

public class SearchRequest implements ISearchRequest {
    private String searchType;
    private String query;
    private Integer limit;
    private Integer offset;

    public String getQuery() {
        return this.query;
    }

    public SearchRequest setQuery(String query){
        this.query = query;

        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public SearchRequest setLimit(Integer limit){
        this.limit = limit;

        return this;
    }

    public Integer getOffset(){
        return this.offset;
    }

    public SearchRequest setOffset(Integer offset){
        this.offset = offset;

        return this;
    }

    public String getSearchType() {
        return this.searchType;
    }

    public SearchRequest setSearchType(String searchType){
        this.searchType = searchType;

        return this;
    }
}
