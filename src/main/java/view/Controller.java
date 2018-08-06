package view;

import bean.items.ScheduleItem;
import bean.items.StationItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ScheduleUtils;
import utils.StationUtils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private static Logger log = LogManager.getLogger(Controller.class);

    @FXML
    private ComboBox comboStationHoraire;

    @FXML
    private TableView<TableHoraire> tableHoraire;

    private StationUtils stationUtils;
    private ScheduleUtils scheduleUtils;

    public Controller(){
        super();
    }

    public void initialize(URL location, ResourceBundle resources) {
        if (stationUtils == null) {
            if(log.isDebugEnabled()){
                log.debug("Loading station file ...");
            }
            stationUtils = StationUtils.getInstance();
            if(log.isDebugEnabled()){
                log.debug("Loading station file finished");
            }
        }

        if (scheduleUtils == null) {
            if(log.isDebugEnabled()){
                log.debug("Loading schedule file ...");
            }
            scheduleUtils = ScheduleUtils.getInstance();
            if(log.isDebugEnabled()){
                log.debug("Loading schedule file finished");
            }
        }
    }

    //-------------------------------------------------------------------
    // MouseEvent
    //-------------------------------------------------------------------

    public void onClickButtonHoraire(MouseEvent event) throws Exception{
        changeScene(event, "horaire.fxml");
    }

    public void onClickButtonAnnuler(MouseEvent event) throws Exception{
        changeScene(event, "distributor.fxml");
    }

    public void onClickSearchHoraire(MouseEvent event) throws Exception{
        String valueComboStationHoraire = (String)comboStationHoraire.getValue();
        StationItem station = stationUtils.getStations().getStationByName(valueComboStationHoraire);
        List<ScheduleItem> scheduleItems = scheduleUtils.getSchedules().getScheduleItemsByStationId(station.getId());

        if(tableHoraire.getColumns().size() == 0){
            TableColumn trainName = new TableColumn("Train");
            trainName.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("trainName")
            );
            TableColumn startHour = new TableColumn("Départ");
            startHour.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("startHour")
            );
            tableHoraire.getColumns().addAll(trainName, startHour);
        }

        ObservableList<TableHoraire> items = FXCollections.observableArrayList();
        tableHoraire.setItems(items);
        scheduleItems.forEach(item -> {
                items.addAll(new TableHoraire(item.getTrainName(), item.getStartHour()));
            }
        );
    }

    public void initializeStationHoraire(Event event) throws Exception{
        if(comboStationHoraire.getItems().size() > 0){
            return;
        }
        List<StationItem> stationItems = stationUtils.getStations().getStationList();
        ObservableList<String> items = FXCollections.observableArrayList();
        for(StationItem station: stationItems){
            items.add(station.getName());
        }
        comboStationHoraire.setItems(items);
    }

    //-------------------------------------------------------------------
    // Utils
    //-------------------------------------------------------------------

    private void changeScene(MouseEvent event, String sceneFxml) throws Exception{
        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource(sceneFxml));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
