package utils;

import bean.Trains;
import bean.items.TrainItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class TrainUtils {

    private static Logger log = LogManager.getLogger(TrainUtils.class);

    private Trains trains;
    private static TrainUtils tu;
    public static TrainUtils getInstance(){
        if(tu==null){
            tu = new TrainUtils();
            tu.load();
        }
        return tu;
    }

    private TrainUtils(){
    }

    private void load(){
        try {
            File f = new File(Trains.class.getSimpleName() + ".json");
            if(!f.exists()){
                initialize();
            }
            trains = new ObjectMapper().readValue(f, Trains.class);
            if(log.isDebugEnabled()){
                log.debug("Loading "+Trains.class.getSimpleName()+":\n\t"+trains.toString());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void initialize(){
        try{
            if(log.isDebugEnabled()){
                log.debug("Initialize "+Trains.class.getSimpleName()+"...");
            }
            trains = new Trains();
            for(int t=0;t<=10;t++){
                TrainItem ti = new TrainItem(t, "Train N° "+t);
                trains.addTrain(ti);
            }
            save();
            if(log.isDebugEnabled()){
                log.debug("Initialize "+Trains.class.getSimpleName()+" finished");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){
        try {
            if(log.isDebugEnabled()){
                log.debug("Save "+Trains.class.getSimpleName()+"...");
            }
            new ObjectMapper().writeValue(new File(trains.getClass().getSimpleName() + ".json"), trains);
            if(log.isDebugEnabled()){
                log.debug("Save "+Trains.class.getSimpleName()+" finished");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Trains getTrains() {
        return trains;
    }
}
