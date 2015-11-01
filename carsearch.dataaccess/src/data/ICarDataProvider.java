package data;

import util.DataEntry;

import java.util.ArrayList;

public interface ICarDataProvider {
    ArrayList<DataEntry> takeAll();
    ArrayList<DataEntry> takeByText(String[] keywords);
}
