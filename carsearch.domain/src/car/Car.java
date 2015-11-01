package car;

public class Car {
    private String color;
    private String make;
    private String model;
    private String bodyType;
    private String features;
    private CarPrice price;
    private CarImage image;

    public static final String TYPE = "car";

    public String getColor(){
        return this.color;
    }

    public Car setColor(String color) {
        this.color = color;

        return this;
    }

    public String getMake(){
        return this.make;
    }

    public Car setMake(String make){
        this.make = make;

        return this;
    }

    public String getModel(){
        return this.model;
    }

    public Car setModel(String model){
        this.model = model;

        return this;
    }

    public String getBodyType(){
        return this.bodyType;
    }

    public Car setBodyType(String bodyType){
        this.bodyType = bodyType;

        return this;
    }

    public String getFeatures(){
        return this.features;
    }

    public Car setFeatures(String features){
        this.features = features;

        return this;
    }

    public CarPrice getPrice(){
        return this.price;
    }

    public Car setPrice(CarPrice price){
        this.price = price;

        return this;
    }

    public CarImage getImage(){
        return this.image;
    }

    public Car setImage(CarImage image){
        this.image = image;

        return this;
    }
}
