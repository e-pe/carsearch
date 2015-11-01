package car;

public class CarRepositoryPage implements ICarRepositoryPage {
    private Integer limit;
    private Integer offset;

    public Integer getLimit(){
        return this.limit;
    }

    public CarRepositoryPage setLimit(Integer limit){
        this.limit = limit;

        return this;
    }

    public  Integer getOffset(){
        return this.offset;
    }

    public CarRepositoryPage setOffset(Integer offset){
        this.offset = offset;

        return this;
    }
}
