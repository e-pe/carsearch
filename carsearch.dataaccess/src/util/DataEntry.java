package util;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;

public class DataEntry {
    private ArrayList<DataEntryAttribute> attributes;

    public DataEntry(){
        this.attributes = new ArrayList<>();
    }

    public ArrayList<DataEntryAttribute> getAttributes(){
        return this.attributes;
    }

    public DataEntry createAttribute(Consumer<DataEntryAttribute> onCreate){
        DataEntryAttribute attribute = new DataEntryAttribute();

        if (onCreate != null)
            onCreate.accept(attribute);

        this.attributes.add(attribute);

        return this;
    }

    public DataEntryAttribute findAttribute(String attributeName){
        Optional<DataEntryAttribute> attributeOptional = this.attributes
                .stream()
                .filter((DataEntryAttribute attribute) -> {
                    return attribute.getName() == attributeName;
                })
                .findFirst();

        if (attributeOptional.isPresent())
            return attributeOptional.get();

        return null;
    }

    public Boolean containsValue(String matchValue){
        ArrayList<Boolean> matches = new ArrayList<>();

        for (DataEntryAttribute attribute : this.attributes) {
            String value = attribute.getValue();

            if (value != null && !value.equals("")) {
                matches.add(value.toLowerCase().contains(matchValue.toLowerCase()));
            }
        }

        return matches
                .stream()
                .filter((Boolean match) -> match == true)
                .count() > 0;
    }
}
