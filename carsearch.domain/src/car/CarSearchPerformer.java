package car;

import data.CarDataResource;
import search.ISearchPerformer;
import search.SearchQuery;
import search.SearchResult;

import java.util.ArrayList;

public class CarSearchPerformer implements ISearchPerformer {
    private ICarRepository carRepository;

    public CarSearchPerformer(ICarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public ArrayList<SearchResult> performSearch(SearchQuery searchQuery) {
        ArrayList<SearchResult> searchResults = new ArrayList<>();
        ArrayList<Car> cars = this.carRepository.findByText(
                new CarRepositoryTextFilter(searchQuery.getQuery()),
                new CarRepositoryPage()
                    .setLimit(searchQuery.getLimit())
                    .setOffset(searchQuery.getOffset()));

        for(Car car : cars){
            SearchResult searchResult = new SearchResult(Car.TYPE);

            searchResult.put(CarDataResource.COLOR, car.getColor());
            searchResult.put(CarDataResource.MAKE, car.getMake());
            searchResult.put(CarDataResource.MODEL, car.getModel());
            searchResult.put(CarDataResource.BODY_TYPE, car.getBodyType());
            searchResult.put(CarDataResource.FEATURES, car.getFeatures());
            searchResult.put(CarDataResource.PRICE, car.getPrice().toString());
            searchResult.put(CarDataResource.IMAGE, car.getImage().toString());

            searchResults.add(searchResult);
        }

        return searchResults;
    }
}
