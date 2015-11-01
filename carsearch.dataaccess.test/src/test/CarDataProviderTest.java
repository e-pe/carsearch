package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import data.CarDataProvider;
import data.CarDataResource;
import data.DummyCarDataFetcher;
import org.junit.Test;
import util.DataEntry;
import util.DataEntryAttribute;

import java.util.ArrayList;

public class CarDataProviderTest {

    @Test
    public void CarDataProvider_should_take_data_entries_by_make_as_query() {
        //Arrange
        DummyCarDataFetcher dataFetcher = new DummyCarDataFetcher();
        CarDataProvider dataProvider = new CarDataProvider(dataFetcher);

        //Act
        ArrayList<DataEntry> entriesWithFord = dataProvider
                .takeByText(new String[]{"Ford"});

        ArrayList<DataEntry> entriesWithBuick = dataProvider
                .takeByText(new String[]{"Buick"});

        ArrayList<DataEntry> entriesWithAudi = dataProvider
                .takeByText(new String[]{"Audi"});

        //Assert
        assertEquals(1, entriesWithFord.size());
        assertEquals(1, entriesWithBuick.size());
        assertEquals(2, entriesWithAudi.size());

        DataAssert entriesWithFordAssert = new DataAssert(entriesWithFord)
                .assertByMake("Ford");

        DataAssert entriesWithBuickAssert = new DataAssert(entriesWithBuick)
                .assertByMake("Buick");

        DataAssert entriesWithAudiAssert = new DataAssert(entriesWithAudi)
                .assertByMake("Audi");
    }

    @Test
    public void CarDataProvider_should_take_data_entries_by_model_as_query() {
        //Arrange
        DummyCarDataFetcher dataFetcher = new DummyCarDataFetcher();
        CarDataProvider dataProvider = new CarDataProvider(dataFetcher);

        //Act
        ArrayList<DataEntry> entriesWithMustang = dataProvider
                .takeByText(new String[]{"Mustang"});

        ArrayList<DataEntry> entriesWithLacrosse = dataProvider
                .takeByText(new String[]{"Lacrosse"});

        ArrayList<DataEntry> entriesWithA4 = dataProvider
                .takeByText(new String[]{"A4"});

        //Assert
        assertEquals(1, entriesWithMustang.size());
        assertEquals(1, entriesWithLacrosse.size());
        assertEquals(2, entriesWithA4.size());

        DataAssert entriesWithMustangAssert = new DataAssert(entriesWithMustang)
                .assertByMakeAndModel("Ford", "Mustang");

        DataAssert entriesWithLacrosseAssert = new DataAssert(entriesWithLacrosse)
                .assertByMakeAndModel("Buick", "Lacrosse");

        DataAssert entriesWithA4Assert = new DataAssert(entriesWithA4)
                .assertByMakeAndModel("Audi", "A4");
    }

    @Test
    public void CarDataProvider_should_take_data_entries_by_make_and_model_as_query() {
        //Arrange
        DummyCarDataFetcher dataFetcher = new DummyCarDataFetcher();
        CarDataProvider dataProvider = new CarDataProvider(dataFetcher);

        //Act
        ArrayList<DataEntry> entriesWithMustang = dataProvider
                .takeByText(new String[]{"Ford", "Mustang"});

        ArrayList<DataEntry> entriesWithLacrosse = dataProvider
                .takeByText(new String[]{"Buick", "Lacrosse"});

        ArrayList<DataEntry> entriesWithA4 = dataProvider
                .takeByText(new String[]{"Audi", "A4"});

        //Assert
        assertEquals(1, entriesWithMustang.size());
        assertEquals(1, entriesWithLacrosse.size());
        assertEquals(2, entriesWithA4.size());

        DataAssert entriesWithMustangAssert = new DataAssert(entriesWithMustang)
                .assertByMakeAndModel("Ford", "Mustang");

        DataAssert entriesWithLacrosseAssert = new DataAssert(entriesWithLacrosse)
                .assertByMakeAndModel("Buick", "Lacrosse");

        DataAssert entriesWithA4Assert = new DataAssert(entriesWithA4)
                .assertByMakeAndModel("Audi", "A4");
    }

    @Test
    public void CarDataProvider_should_take_data_entries_by_color_as_query() {
        //Arrange
        DummyCarDataFetcher dataFetcher = new DummyCarDataFetcher();
        CarDataProvider dataProvider = new CarDataProvider(dataFetcher);

        //Act
        ArrayList<DataEntry> entriesWithRed = dataProvider
                .takeByText(new String[]{"red"});

        ArrayList<DataEntry> entriesWithBlue = dataProvider
                .takeByText(new String[]{"blue"});

        ArrayList<DataEntry> entriesWithGreen = dataProvider
                .takeByText(new String[]{"green"});

        //Assert
        assertEquals(2, entriesWithRed.size());
        assertEquals(2, entriesWithBlue.size());
        assertEquals(1, entriesWithGreen.size());

        DataAssert entriesWithRedAssert = new DataAssert(entriesWithRed)
                .assertByColor("red");

        DataAssert entriesWithBlueAssert = new DataAssert(entriesWithBlue)
                .assertByColor("blue");

        DataAssert entriesWithGreenAssert = new DataAssert(entriesWithGreen)
                .assertByColor("green");
    }

    private class DataAssert {
        private ArrayList<DataEntry> entries;

        public DataAssert(ArrayList<DataEntry> entries){
            this.entries = entries;
        }

        public DataAssert assertByMake(String make){
            for (DataEntry entry : entries){
                for (DataEntryAttribute attribute : entry.getAttributes()) {
                    if (attribute.getName().equals(CarDataResource.MAKE)){
                        assertEquals(make, attribute.getValue());
                    }
                }
            }

            return this;
        }

        public DataAssert assertByMakeAndModel(String make, String model) {
            for (DataEntry entry : entries){
                for (DataEntryAttribute attribute : entry.getAttributes()) {
                    if (attribute.getName().equals(CarDataResource.MAKE)){
                        assertEquals(make, attribute.getValue());
                    }

                    if (attribute.getName().equals(CarDataResource.MODEL)) {
                        assertEquals(model, attribute.getValue());
                    }
                }
            }

            return this;
        }

        public DataAssert assertByColor(String color) {
            for (DataEntry entry : entries){
                for (DataEntryAttribute attribute : entry.getAttributes()) {
                    if (attribute.getName().equals(CarDataResource.COLOR)){
                        assertTrue(attribute.getValue().contains(color));
                    }
                }
            }

            return this;
        }
    }
}
