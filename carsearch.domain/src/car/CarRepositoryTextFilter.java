package car;

public class CarRepositoryTextFilter implements ICarRepositoryTextFilter {
    private String text;

    public CarRepositoryTextFilter(String text){
        this.text = text;
    }

    @Override
    public String[] toKeywords() {
        return this.text.split("\\s+");
    }
}
