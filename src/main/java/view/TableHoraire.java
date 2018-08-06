package view;

import javafx.beans.property.SimpleStringProperty;

public class TableHoraire {
    private SimpleStringProperty trainName;
    private SimpleStringProperty  stationStartName;
    private SimpleStringProperty  startHour;
    private SimpleStringProperty  stationEndName;
    private SimpleStringProperty  endHour;
    public TableHoraire(String trainName, String stationStartName,String startHour, String stationEndName, String endHour){
        this.trainName = new SimpleStringProperty(trainName);
        this.stationStartName = new SimpleStringProperty(stationStartName);
        this.startHour = new SimpleStringProperty(startHour);
        this.stationEndName = new SimpleStringProperty(stationEndName);
        this.endHour = new SimpleStringProperty(endHour);
    }

    public String getStartHour() {
        return startHour.get();
    }

    public String getTrainName() {
        return trainName.get();
    }

    public String getStationStartName() {
        return stationStartName.get();
    }

    public String getStationEndName() {
        return stationEndName.get();
    }

    public String getEndHour() {
        return endHour.get();
    }
}
