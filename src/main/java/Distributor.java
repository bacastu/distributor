
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ScheduleUtils;
import utils.StationUtils;

/**
 * Created by bacalin on 03-03-18.
 */
public class Distributor extends Application{

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

    @Override
    public void start(Stage mainPage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("distributor.fxml"));
        mainPage.setTitle("Distributeur de billets de trains");
        mainPage.setScene(new Scene(root, 800, 600));
        mainPage.show();
    }

    public static void main(String[] arg) {
        launch(arg);

        if(log.isDebugEnabled()){
            log.debug("Start Distributor");
        }
        Distributor d = new Distributor();
        if(log.isDebugEnabled()){
            log.debug("Distributor:"+d.testJunit());
        }
    }
}
