package bean;

import bean.items.ScheduleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Schedules {

    private List<ScheduleItem> scheduleList;
    public Schedules() {
        this.scheduleList = new ArrayList<ScheduleItem>();
    }

    public List<ScheduleItem> getScheduleItems() {
        return scheduleList;
    }

    public List<ScheduleItem> getScheduleItemsByStationId(int stationId) {
        return scheduleList.stream().filter(s -> s.getIdStationSrc() == stationId).collect(Collectors.toList());
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
