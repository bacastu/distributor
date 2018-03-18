package bean.items;

import java.sql.Time;

public class ScheduleItem {
    private int     id;
    private int     idStationSrc;
    private int     idStationDest;
    private Time    startHour;
    private Time    endHour;
    private String  trainName;
    private int     trainTrack;

    public ScheduleItem(){}

    public ScheduleItem(int id, int idStationSrc, int idStationDest, Time startHour, Time endHour, String trainName, int trainTrack) {
        this.id = id;
        this.idStationSrc = idStationSrc;
        this.idStationDest = idStationDest;
        this.startHour = startHour;
        this.endHour = endHour;
        this.trainName = trainName;
        this.trainTrack = trainTrack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStationSrc() {
        return idStationSrc;
    }

    public void setIdStationSrc(int idStationSrc) {
        this.idStationSrc = idStationSrc;
    }

    public int getIdStationDest() {
        return idStationDest;
    }

    public void setIdStationDest(int idStationDest) {
        this.idStationDest = idStationDest;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() {
        return endHour;
    }

    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainTrack() {
        return trainTrack;
    }

    public void setTrainTrack(int trainTrack) {
        this.trainTrack = trainTrack;
    }

    @Override
    public String toString() {
        return "\n\tScheduleItem{" +
                "id=" + id +
                ", idStationSrc=" + idStationSrc +
                ", idStationDest=" + idStationDest +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", trainName='" + trainName + '\'' +
                ", trainTrack=" + trainTrack +
                '}';
    }
}
