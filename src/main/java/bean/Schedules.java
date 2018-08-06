package bean;

import bean.items.ScheduleItem;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public List<ScheduleItem> getScheduleItemsByStationId(int stationId, DateTime date) {
        return scheduleList.stream().filter(s -> s.getIdStationSrc() == stationId && filterDate(s.getStartHour(),date)).collect(Collectors.toList());
    }

    public List<ScheduleItem> getScheduleItemsByTrainId(int trainId, DateTime date) {
        return scheduleList.stream().filter(s -> s.getIdTrain() == trainId && filterDate(s.getStartHour(),date)).collect(Collectors.toList());
    }

    private boolean filterDate(String startHour, DateTime date){
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            DateTime dt = new DateTime(df.parse(startHour));
            return dt.getDayOfMonth() == date.getDayOfMonth() &&
                    dt.getMonthOfYear() == date.getMonthOfYear() &&
                    dt.getYear() == date.getYear();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
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
