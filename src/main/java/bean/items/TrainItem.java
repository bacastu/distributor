package bean.items;

public class TrainItem {

    private int id;
    private String trainName;

    public TrainItem(){}

    public TrainItem(int id,String trainName){
        this.id = id;
        this.trainName = trainName;
    }

    public int getId() {
        return id;
    }

    public String getTrainName() {
        return trainName;
    }
}
