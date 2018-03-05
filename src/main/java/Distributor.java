import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by bacalin on 03-03-18.
 */
public class Distributor {

    private static Logger log = LogManager.getLogger(Distributor.class);

    public static void main(String[] arg) {
        System.out.println("Start Maven project");

        if(log.isDebugEnabled()){
            log.debug("Start Maven project with log4J");
        }
    }
}
