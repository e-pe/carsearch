package test;


import org.junit.Test;
import util.DataEntry;
import util.DataEntryAttribute;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataEntryTest {
    @Test
    public void DataEntry_should_indicate_that_the_value_exists(){
        //Arrange
        DataEntry entry = new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName("TestName")
                            .setValue("TestValue");
                });

        //Act
        Boolean contains = entry.containsValue("TestValue");

        //Assert
        assertTrue(contains);
    }

    @Test
    public void DataEntry_should_indicate_that_the_value_does_not_exist(){
        //Arrange
        DataEntry entry = new DataEntry()
                .createAttribute((DataEntryAttribute attribute) -> {
                    attribute.setName("TestName")
                            .setValue("TestValue");
                });

        //Act
        Boolean contains = entry.containsValue("TestValue2");

        //Assert
        assertFalse(contains);
    }
}
