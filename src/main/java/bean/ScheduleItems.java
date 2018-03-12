package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScheduleItems{

    private List<Schedule> scheduleItems;
    public ScheduleItems() {
        this.scheduleItems = new ArrayList<Schedule>();
    }

    public void addItem(Schedule schedule){
        this.scheduleItems.add(schedule);
    }

    public void addItems(boolean bv, int iv, Map<String, String> mv){
        addItem(new Schedule(bv, iv, mv));
    }

    public List<Schedule> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(List<Schedule> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    @Override
    public String toString() {
        String toString=ScheduleItems.class.getSimpleName()+":";
        for(Schedule s: scheduleItems){
            toString += "\n\t"+s.toString();
        }
        return toString;
    }
}
