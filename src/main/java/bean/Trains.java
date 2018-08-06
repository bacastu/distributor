package bean;

import bean.items.TrainItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trains {
    private List<TrainItem> trainList;
    public Trains() {
        this.trainList = new ArrayList<TrainItem>();
    }

    public List<TrainItem> getTrainList() {
        return trainList;
    }

    public TrainItem getTrainItemsByTrainId(int trainId) {
        return trainList.stream().filter(t -> t.getId() == trainId).collect(Collectors.toList()).get(0);
    }

    public TrainItem getTrainItemsByTrainName(String trainName) {
        return trainList.stream().filter(t -> t.getTrainName().equals(trainName)).collect(Collectors.toList()).get(0);
    }



    public void setTrainItems(List<TrainItem> trainItems) {
        this.trainList = trainList;
    }

    public void addTrain(TrainItem train){
        this.trainList.add(train);
    }

    @Override
    public String toString() {
        return "Trains{\n\t" +
                "\n\ttrainList=" + trainList +
                '}';
    }
}
