package car;

import data.CarDataResource;
import util.DataEntry;
import util.DataEntryAttribute;
import util.IRepositoryMapper;

public class CarRepositoryMapper implements IRepositoryMapper<Car> {

    @Override
    public Car map(DataEntry entry) {
        Car car = new Car();

        for (DataEntryAttribute attribute : entry.getAttributes()){
            if (attribute.is(CarDataResource.COLOR))
                car.setColor(attribute.getValue());

            if (attribute.is(CarDataResource.MAKE))
                car.setMake(attribute.getValue());

            if (attribute.is(CarDataResource.MODEL))
                car.setModel(attribute.getValue());

            if (attribute.is(CarDataResource.BODY_TYPE))
                car.setBodyType(attribute.getValue());

            if (attribute.is(CarDataResource.FEATURES))
                car.setFeatures(attribute.getValue());

            if (attribute.is(CarDataResource.PRICE))
                car.setPrice(new CarPrice(attribute.getValue()));

            if (attribute.is(CarDataResource.IMAGE))
                car.setImage(new CarImage(attribute.getValue()));
        }

        return car;
    }
}
