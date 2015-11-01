package test;

import car.CarRepository;
import contract.ISearchApplicationService;
import data.CarDataProvider;
import data.DummyCarDataFetcher;
import datacontract.CarSearchRequest;
import datacontract.ISearchRequest;
import dto.SearchResultDto;
import org.junit.Before;
import org.junit.Test;
import search.SearchService;
import contract.SearchApplicationService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchApplicationServiceTest {
    private ISearchApplicationService searchApplicationService;

    @Before
    public void setUp() {
        this.searchApplicationService = new SearchApplicationService(
                new SearchService(
                        new CarRepository(
                                new CarDataProvider(
                                        new DummyCarDataFetcher()))));
    }

    @Test
    public void SearchApplicationService_should_perform_search_for_cars_by_make(){

        //Arrange
        ISearchRequest fordSearchRequest = new CarSearchRequest()
                .setQuery("Ford");

        ISearchRequest buickSearchRequest = new CarSearchRequest()
                .setQuery("Buick");

        ISearchRequest audiSearchRequest = new CarSearchRequest()
                .setQuery("Audi");

        //Act
        ArrayList<SearchResultDto> fordSearchResults = this.searchApplicationService
                .performSearch(fordSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> buickSearchResults = this.searchApplicationService
                .performSearch(buickSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> audiSearchResults = this.searchApplicationService
                .performSearch(audiSearchRequest)
                .getSearchResults()
                .asList();

        //Assert
        assertEquals(1, fordSearchResults.size());
        assertEquals(1, buickSearchResults.size());
        assertEquals(2, audiSearchResults.size());

        DataAssert fordSearchResultsAssert = new DataAssert(fordSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Ford"}
                });

        DataAssert buickSearchResultsAssert = new DataAssert(buickSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Buick"}
                });

        DataAssert audiSearchResultstAssert = new DataAssert(audiSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Audi"}
                });
    }

    @Test
    public void SearchApplicationService_should_perform_search_for_cars_by_model(){

        //Arrange
        ISearchRequest mustangSearchRequest = new CarSearchRequest()
                .setQuery("Mustang");

        ISearchRequest lacrosseSearchRequest = new CarSearchRequest()
                .setQuery("Lacrosse");

        ISearchRequest a4SearchRequest = new CarSearchRequest()
                .setQuery("A4");

        //Act
        ArrayList<SearchResultDto> mustangSearchResults = this.searchApplicationService
                .performSearch(mustangSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> lacrosseSearchResults = this.searchApplicationService
                .performSearch(lacrosseSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> a4SearchResults = this.searchApplicationService
                .performSearch(a4SearchRequest)
                .getSearchResults()
                .asList();

        //Assert
        assertEquals(1, mustangSearchResults.size());
        assertEquals(1, lacrosseSearchResults.size());
        assertEquals(2, a4SearchResults.size());

        DataAssert mustangSearchResultsAssert = new DataAssert(mustangSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Ford", "Mustang"}
                });

        DataAssert lacrosseSearchResultsAssert = new DataAssert(lacrosseSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Buick", "Lacrosse"}
                });

        DataAssert a4SearchResultsAssert = new DataAssert(a4SearchResults)
                .assertValues(new String[][]{
                        new String[]{"Audi", "A4"}
                });
    }

    @Test
    public void SearchApplicationService_should_perform_search_for_cars_by_make_and_model() {

        //Arrange
        ISearchRequest fordMustangSearchRequest = new CarSearchRequest()
                .setQuery("Ford Mustang");

        ISearchRequest buickLacrosseSearchRequest = new CarSearchRequest()
                .setQuery("Buick Lacrosse");

        ISearchRequest audiA4SearchRequest = new CarSearchRequest()
                .setQuery("Audi A4");

        //Act
        ArrayList<SearchResultDto> fordMustangSearchResults = this.searchApplicationService
                .performSearch(fordMustangSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> buickLacrosseSearchResults = this.searchApplicationService
                .performSearch(buickLacrosseSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> audiA4SearchResults = this.searchApplicationService
                .performSearch(audiA4SearchRequest)
                .getSearchResults()
                .asList();

        //Assert
        assertEquals(1, fordMustangSearchResults.size());
        assertEquals(1, buickLacrosseSearchResults.size());
        assertEquals(2, audiA4SearchResults.size());

        DataAssert fordMustangSearchResultsAssert = new DataAssert(fordMustangSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Ford", "Mustang"}
                });

        DataAssert buickLacrosseSearchResultsAssert = new DataAssert(buickLacrosseSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Buick", "Lacrosse"}
                });

        DataAssert audiA4SearchResultsAssert = new DataAssert(audiA4SearchResults)
                .assertValues(new String[][]{
                        new String[]{"Audi", "A4"}
                });
    }

    @Test
    public void SearchApplicationService_should_perform_search_for_cars_by_color(){
        //Arrange
        ISearchRequest redSearchRequest = new CarSearchRequest()
                .setQuery("red");

        ISearchRequest blueSearchRequest = new CarSearchRequest()
                .setQuery("blue");

        ISearchRequest greenSearchRequest = new CarSearchRequest()
                .setQuery("green");

        //Act
        ArrayList<SearchResultDto> redSearchResults = this.searchApplicationService
                .performSearch(redSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> blueSearchResults = this.searchApplicationService
                .performSearch(blueSearchRequest)
                .getSearchResults()
                .asList();

        ArrayList<SearchResultDto> greenSearchResults = this.searchApplicationService
                .performSearch(greenSearchRequest)
                .getSearchResults()
                .asList();

        //Assert
        assertEquals(2, redSearchResults.size());
        assertEquals(2, blueSearchResults.size());
        assertEquals(1, greenSearchResults.size());

        DataAssert redSearchResultsAssert = new DataAssert(redSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Ford", "Mustang"},
                        new String[]{"Scarlet red", "Audi", "A4"}
                });

        DataAssert blueSearchResultsAssert = new DataAssert(blueSearchResults)
                .assertValues(new String[][]{
                        new String[]{"Buick", "Lacrosse"},
                        new String[]{"BMW", "X5"}
                });

        DataAssert greenSearchResultsAssert = new DataAssert(greenSearchResults)
                .assertValues(new String[][]{
                        new String[]{"British racing green", "Audi", "A4"}
                });
    }

    private class DataAssert {
        private ArrayList<SearchResultDto> searchResults;

        public DataAssert(ArrayList<SearchResultDto> searchResults){
            this.searchResults = searchResults;
        }

        public DataAssert assertValues(String[][] tuples){
            for (SearchResultDto searchResultDto : searchResults){
                this.assertResult(searchResultDto, tuples);
            }

            return this;
        }

        private void assertResult(SearchResultDto dto, String[][] tuples){
            String[] foundTuple = null;
            ArrayList<Boolean> matches = new ArrayList<>();

            for (int i = 0; i < tuples.length; i++){
                String[] tuple = tuples[i];

                for (int j = 0; j < tuple.length; j++){
                    String value = tuple[j];

                    if (dto.containsValue(value)){
                        matches.add(true);

                        foundTuple = tuple;
                    }
                }

                if (foundTuple != null)
                    break;
            }

            assertTrue(foundTuple.length == matches.size());
        }
    }
}
