package util;

public class DataEntryAttribute {
    private String name;
    private String value;

    public String getName(){
        return this.name;
    }

    public DataEntryAttribute setName(String name){
        this.name = name;

        return this;
    }

    public String getValue(){
        return this.value;
    }

    public DataEntryAttribute setValue(String value){
        this.value = value;

        return this;
    }

    public Boolean is(String name) {
        return this.name.equals(name);
    }
}
