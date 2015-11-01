package controllers.v1;

import car.CarRepository;
import contract.ISearchApplicationService;
import data.CarDataProvider;
import data.DummyCarDataFetcher;
import datacontract.CarSearchRequest;
import datacontract.ISearchRequest;
import datacontract.ISearchResponse;
import search.SearchService;
import contract.SearchApplicationService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("v1/search")
@Produces("application/json")
public class SearchController {

    @GET
    @Path("/cars")
    public Response searchCars(
            @QueryParam("query") String query,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset) {

        ISearchRequest searchRequest = new CarSearchRequest()
                .setQuery(query)
                .setLimit(limit)
                .setOffset(offset);

        ISearchApplicationService searchService = new SearchApplicationService(
                new SearchService(
                        new CarRepository(
                                new CarDataProvider(
                                        new DummyCarDataFetcher()))));

        ISearchResponse searchResponse = searchService.performSearch(searchRequest);

        return Response.ok("{}").build();
    }
}
