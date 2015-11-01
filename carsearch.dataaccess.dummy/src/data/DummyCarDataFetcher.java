package data;

import util.DataEntry;
import util.DataEntryAttribute;

import java.util.ArrayList;

public class DummyCarDataFetcher implements ICarDataFetcher<ArrayList<DataEntry>> {

    @Override
    public ArrayList<DataEntry> fetch(){
        return this.createEntries();
    }

    private ArrayList<DataEntry> createEntries()
    {
        ArrayList<DataEntry> entries = new ArrayList<>();

        entries.add(new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.COLOR)
                            .setValue("Persimmon red");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MAKE)
                            .setValue("Ford");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MODEL)
                            .setValue("Mustang");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.BODY_TYPE)
                            .setValue("Body Type");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.FEATURES)
                            .setValue("Features");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.FEATURES)
                            .setValue("Features");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.PRICE)
                            .setValue("32.000€");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.IMAGE)
                            .setValue("");
                }));

        entries.add(new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.COLOR)
                            .setValue("Midnight blue");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MAKE)
                            .setValue("Buick");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MODEL)
                            .setValue("Lacrosse");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.BODY_TYPE)
                            .setValue("limousine");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.FEATURES)
                            .setValue("Xenon headlight");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.PRICE)
                            .setValue("32.000€");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.IMAGE)
                            .setValue("");
                }));

        entries.add(new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.COLOR)
                            .setValue("Ocean blue");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MAKE)
                            .setValue("BMW");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MODEL)
                            .setValue("X5");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.BODY_TYPE)
                            .setValue("limousine");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.FEATURES)
                            .setValue("LED headlight");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.PRICE)
                            .setValue("79.000€");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.IMAGE)
                            .setValue("");
                }));

        entries.add(new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.COLOR)
                            .setValue("British racing green");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MAKE)
                            .setValue("Audi");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MODEL)
                            .setValue("A4");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.BODY_TYPE)
                            .setValue("convertable");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.FEATURES)
                            .setValue("");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.PRICE)
                            .setValue("6.700€");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.IMAGE)
                            .setValue("");
                }));

        entries.add(new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.COLOR)
                            .setValue("Scarlet red");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MAKE)
                            .setValue("Audi");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.MODEL)
                            .setValue("A4");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.BODY_TYPE)
                            .setValue("limousine");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.FEATURES)
                            .setValue("");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.PRICE)
                            .setValue("4.500€");
                })

                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName(CarDataResource.IMAGE)
                            .setValue("");
                }));

        return entries;
    }
}

