
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ScheduleUtils;
import utils.StationUtils;

/**
 * Created by bacalin on 03-03-18.
 */
public class Distributor {

    private static Logger log = LogManager.getLogger(Distributor.class);

    private StationUtils stationUtils;
    private ScheduleUtils scheduleUtils;
    public Distributor(){
        if(log.isDebugEnabled()){
            log.debug("Loading data file ...");
        }
        stationUtils = StationUtils.getInstance();
        scheduleUtils = ScheduleUtils.getInstance();
        if(log.isDebugEnabled()){
            log.debug("Loading data file finished");
        }
    }

    public Integer testJunit(){
        return 4;
    }

    public static void main(String[] arg) {
        if(log.isDebugEnabled()){
            log.debug("Start Distributor");
        }
        Distributor d = new Distributor();
        /*if(log.isDebugEnabled()){
            log.debug("Distributor:"+d.testJunit());
        }*/

        /*
        //Container
        ScheduleItems si = new ScheduleItems();
        Schedule s = new Schedule(true, 10, null);
        s.addMapValue("plop1", "bla1");
        s.addMapValue("plop2", "bla2");
        s.addMapValue("plop3", "bla3");
        si.addItem(s);
        s = new Schedule(true, 10, null);
        s.addMapValue("plop6", "bla1");
        s.addMapValue("plop7", "bla2");
        s.addMapValue("plop8", "bla3");
        si.addItem(s);
        s = new Schedule(true, 10, null);
        s.addMapValue("plop9", "bla1");
        s.addMapValue("plop5", "bla2");
        s.addMapValue("plop4", "bla3");
        si.addItem(s);

        //Save JB to Json
        ScheduleUtils.saveSchedule(si);

        //Load Json to JB
        ScheduleItems siLoader = ScheduleUtils.loadSchedule();
        log.debug(siLoader.toString());
        */
    }
}
