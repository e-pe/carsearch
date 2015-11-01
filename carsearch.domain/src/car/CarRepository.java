package car;

import data.ICarDataProvider;
import util.DataEntry;

import java.util.ArrayList;

public class CarRepository implements ICarRepository {
    private ICarDataProvider dataProvider;

    public CarRepository(ICarDataProvider dataProvider){
        this.dataProvider = dataProvider;
    }

    @Override
    public ArrayList<Car> findByText(ICarRepositoryTextFilter textFilter, ICarRepositoryPage page) {
        ArrayList<DataEntry> entries = this.dataProvider.takeByText(textFilter.toKeywords());

        ArrayList<Car> cars = this.createCarsFrom(entries);

        return cars;
    }

    @Override
    public ArrayList<Car> findAll() {
        ArrayList<DataEntry> entries = this.dataProvider.takeAll();

        ArrayList<Car> cars = this.createCarsFrom(entries);

        return cars;
    }

    private ArrayList<Car> createCarsFrom(ArrayList<DataEntry> entries){
        CarRepositoryMapper mapper = new CarRepositoryMapper();

        ArrayList<Car> cars = new ArrayList<>();

        for (DataEntry entry : entries){
            Car car = mapper.map(entry);

            cars.add(car);
        }

        return cars;
    }
}
