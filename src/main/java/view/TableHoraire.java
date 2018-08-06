package view;

import javafx.beans.property.SimpleStringProperty;

public class TableHoraire {
    private SimpleStringProperty trainName;
    private SimpleStringProperty  startHour;
    public TableHoraire(String trainName, String startHour){
        this.trainName = new SimpleStringProperty(trainName);
        this.startHour = new SimpleStringProperty(startHour);
    }

    public String getStartHour() {
        return startHour.get();
    }

    public String getTrainName() {
        return trainName.get();
    }
}
