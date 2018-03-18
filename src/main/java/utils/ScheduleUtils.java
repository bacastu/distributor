package utils;

import bean.Schedules;
import bean.items.ScheduleItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.Time;
import java.text.DecimalFormat;

public class ScheduleUtils {

    private static Logger log = LogManager.getLogger(ScheduleUtils.class);

    private Schedules schedules;
    private static ScheduleUtils su;
    public static ScheduleUtils getInstance(){
        if(su==null){
            su = new ScheduleUtils();
            su.load();
        }
        return su;
    }

    private ScheduleUtils(){
    }

    private void load(){
        try {
            File f = new File(Schedules.class.getSimpleName() + ".json");
            if(!f.exists()){
                initialize();
            }
            schedules = new ObjectMapper().readValue(f, Schedules.class);
            if(log.isDebugEnabled()){
                log.debug("Loading "+Schedules.class.getSimpleName()+":\n\t"+schedules.toString());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void initialize(){
        try{
            DecimalFormat df = new DecimalFormat("####");
            if(log.isDebugEnabled()){
                log.debug("Initialize "+Schedules.class.getSimpleName()+"...");
            }
            schedules = new Schedules();
            for(int i=0;i<=100;i++){
                for(int v=0;v<=10;v++){
                    Time t = null;
                    ScheduleItem si = new ScheduleItem(i, i, 100-i, t, t, "SC "+df.format(i), v);
                    schedules.addSchedule(si);
                }

            }
            save();
            if(log.isDebugEnabled()){
                log.debug("Initialize "+Schedules.class.getSimpleName()+" finished");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){
        try {
            if(log.isDebugEnabled()){
                log.debug("Save "+Schedules.class.getSimpleName()+"...");
            }
            new ObjectMapper().writeValue(new File(schedules.getClass().getSimpleName() + ".json"), schedules);
            if(log.isDebugEnabled()){
                log.debug("Save "+Schedules.class.getSimpleName()+" finished");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
