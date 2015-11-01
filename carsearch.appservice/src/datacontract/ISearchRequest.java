package datacontract;

public interface ISearchRequest {
    String getSearchType();
    String getQuery();
    Integer getLimit();
    Integer getOffset();
}
