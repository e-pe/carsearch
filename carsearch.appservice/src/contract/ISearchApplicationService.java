package contract;

import datacontract.ISearchRequest;
import datacontract.ISearchResponse;

public interface ISearchApplicationService {
    ISearchResponse performSearch(ISearchRequest request);
}
