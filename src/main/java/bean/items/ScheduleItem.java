package bean.items;

public class ScheduleItem {
    private int         id;
    private int         idStationSrc;
    private int         idStationDest;
    private String      startHour;
    private int         idTrain;

    public ScheduleItem(){}

    public ScheduleItem(int id, int idStationSrc, int idStationDest, String startHour, int idTrain) {
        this.id = id;
        this.idStationSrc = idStationSrc;
        this.idStationDest = idStationDest;
        this.startHour = startHour;
        this.idTrain = idTrain;
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

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }
    
    @Override
    public String toString() {
        return "\n\tScheduleItem{" +
                "id=" + id +
                ", idStationSrc=" + idStationSrc +
                ", idStationDest=" + idStationDest +
                ", startHour=" + startHour +
                ", idTrain=" + idTrain +
                '}';
    }
}
