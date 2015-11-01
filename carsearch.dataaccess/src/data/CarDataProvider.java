package data;

import util.DataEntry;

import java.util.ArrayList;

public class CarDataProvider implements ICarDataProvider{
    private ICarDataFetcher<ArrayList<DataEntry>> fetcher;
    private ArrayList<DataEntry> entries;

    public CarDataProvider(ICarDataFetcher<ArrayList<DataEntry>> fetcher){
        this.fetcher = fetcher;
    }

    @Override
    public ArrayList<DataEntry> takeAll() {
        if (this.entries == null)
            this.entries = this.fetcher.fetch();

        return this.entries;
    }

    @Override
    public ArrayList<DataEntry> takeByText(String[] keywords) {
        ArrayList<DataEntry> entries = this.takeAll();
        ArrayList<DataEntry> matchedEntries = new ArrayList<>();

        for (DataEntry entry : entries){

            for (int i = 0; i < keywords.length; i++) {
                String keyword = keywords[i];

                if (entry.containsValue(keyword)) {

                    if (!matchedEntries.contains(entry))
                        matchedEntries.add(entry);
                }
            }
        }

        return matchedEntries;
    }
}
