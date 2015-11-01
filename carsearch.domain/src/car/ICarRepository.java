package car;

import util.IRepository;

import java.util.ArrayList;

public interface ICarRepository extends IRepository<Car> {
    ArrayList<Car> findByText(ICarRepositoryTextFilter textFilter, ICarRepositoryPage page);
}
