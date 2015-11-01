package search;

import car.CarSearchPerformer;
import car.ICarRepository;

import java.util.ArrayList;

public class SearchService implements ISearchService {
    private ICarRepository carRepository;

    public SearchService(ICarRepository carRepository){
        this.carRepository = carRepository;
    }

    public ArrayList<SearchResult> search(SearchQuery query, String searchType){
        SearchPerformerFactory searchPerformerFactory = new SearchPerformerFactory()
                .setOnGetCarSearchPerformer(() -> {
                    return new CarSearchPerformer(carRepository);
                });

        ISearchPerformer searchPerformer = searchPerformerFactory
                .createSearchPerformer(searchType);

        return searchPerformer.performSearch(query);
    }
}
