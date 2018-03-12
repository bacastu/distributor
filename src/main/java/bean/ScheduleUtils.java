package bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ScheduleUtils {

    public static void saveSchedule(ScheduleItems scheduleItems){
        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON
            mapper.writeValue(new File(scheduleItems.getClass().getSimpleName() + ".json"), scheduleItems);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static ScheduleItems loadSchedule(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            //JSON to Object
            return mapper.readValue(new File(ScheduleItems.class.getSimpleName() + ".json"), ScheduleItems.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
