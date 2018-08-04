package utils;

import bean.Schedules;
import bean.items.ScheduleItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

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
            DateTime now = DateTime.now();
            now = now.withHourOfDay(6).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);//now 06:00
            for(int d=0;d<=10;d++){
                for(int i=0;i<=100;i++) {
                    DateTime hourStart = new DateTime(now);
                    for (int v = 0; v <= 10; v++) {
                        DateTime hourEnd = null;
                        ScheduleItem si = new ScheduleItem(i, i, 100 - i, dateToString(hourStart), "Train N° " + df.format(i), v);
                        schedules.addSchedule(si);
                        hourStart = hourStart.plusHours(1).plusMinutes(30);
                    }
                }
                now = now.plusDays(1);
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

    private String dateToString(DateTime date){
        try{
            if(date==null){
                return null;
            }
            return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date.toDate());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
