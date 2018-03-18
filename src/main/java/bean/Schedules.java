package bean;

import bean.items.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class Schedules {

    private List<ScheduleItem> scheduleList;
    public Schedules() {
        this.scheduleList = new ArrayList<ScheduleItem>();
    }

    public List<ScheduleItem> getScheduleItems() {
        return scheduleList;
    }

    public void setScheduleItems(List<ScheduleItem> scheduleItems) {
        this.scheduleList = scheduleItems;
    }

    public void addSchedule(ScheduleItem schedule){
        this.scheduleList.add(schedule);
    }

    @Override
    public String toString() {
        return "Schedules{\n\t" +
                "\n\tscheduleList=" + scheduleList +
                '}';
    }
}
