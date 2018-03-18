package bean;

import bean.items.StationItem;

import java.util.ArrayList;
import java.util.List;

public class Stations {

    private List<StationItem> stationList;
    public Stations(){
        this.stationList = new ArrayList<StationItem>();
    }

    public List<StationItem> getStationList() {
        return stationList;
    }

    public void setStationList(List<StationItem> stationList) {
        this.stationList = stationList;
    }

    public void addStation(StationItem station){
        stationList.add(station);
    }

    @Override
    public String toString() {
        return "Stations{\n\t" +
                "stationList=\n\t" + stationList +
                '}';
    }
}
