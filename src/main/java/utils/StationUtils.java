package utils;

import bean.Stations;
import bean.items.StationItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class StationUtils {

    private static Logger log = LogManager.getLogger(StationUtils.class);

    private Stations stations;
    private static StationUtils su;
    public static StationUtils getInstance(){
        if(su==null){
            su = new StationUtils();
            su.load();
        }
        return su;
    }

    private StationUtils(){
    }

    private void load(){
        try {
            File f = new File(Stations.class.getSimpleName() + ".json");
            if(!f.exists()){
                initialize();
            }
            stations = new ObjectMapper().readValue(f, Stations.class);
            if(log.isDebugEnabled()){
                log.debug("Loading "+Stations.class.getSimpleName()+":\n\t"+stations.toString());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void initialize(){
        try{
            if(log.isDebugEnabled()){
                log.debug("Initialize "+Stations.class.getSimpleName()+"...");
            }
            stations = new Stations();
            for(int i=0;i<=10;i++){
                StationItem si = new StationItem(i, "Station N° "+i, "Address "+i, 7000+(50*i));
                stations.addStation(si);
            }
            save();
            if(log.isDebugEnabled()){
                log.debug("Initialize "+Stations.class.getSimpleName()+" finished");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){
        try {
            if(log.isDebugEnabled()){
                log.debug("Save "+Stations.class.getSimpleName()+"...");
            }
            new ObjectMapper().writeValue(new File(stations.getClass().getSimpleName() + ".json"), stations);
            if(log.isDebugEnabled()){
                log.debug("Save "+Stations.class.getSimpleName()+" finished");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Stations getStations() {
        return stations;
    }
}
