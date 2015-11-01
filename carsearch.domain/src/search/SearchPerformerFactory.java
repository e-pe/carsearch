package search;

import car.Car;
import car.CarSearchPerformer;

import java.util.function.Supplier;

public class SearchPerformerFactory {
    private Supplier<ISearchPerformer> onGetCarSearchPerformer;

    public SearchPerformerFactory setOnGetCarSearchPerformer(
            Supplier<ISearchPerformer> onGetCarSearchPerformer){

        this.onGetCarSearchPerformer = onGetCarSearchPerformer;

        return this;
    }

    public ISearchPerformer createSearchPerformer(String searchType){
        if (searchType.equals(Car.TYPE)){
            if (onGetCarSearchPerformer != null)
                return onGetCarSearchPerformer.get();
        }

        return null;
    }
}
