import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by bacalin on 03-03-18.
 */
public class Distributor {

    private static Logger log = LogManager.getLogger(Distributor.class);

    public Distributor(){

    }

    public Integer testJunit(){
        return 4;
    }

    public static void main(String[] arg) {
        if(log.isDebugEnabled()){
            log.debug("Start Maven project with log4J");
        }
        Distributor d = new Distributor();
        if(log.isDebugEnabled()){
            log.debug("Distributor:"+d.testJunit());
        }
    }
}
