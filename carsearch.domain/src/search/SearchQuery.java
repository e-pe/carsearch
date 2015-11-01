package search;

public class SearchQuery {
    private String query;
    private Integer limit;
    private Integer offset;

    public SearchQuery(String query, Integer limit, Integer offset){
        this.query = query;
        this.limit = limit;
        this.offset = offset;
    }

    public String getQuery(){
        return this.query;
    }

    public Integer getLimit(){
        return this.limit;
    }

    public Integer getOffset(){
        return this.offset;
    }
}
