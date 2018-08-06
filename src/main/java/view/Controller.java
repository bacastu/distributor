package view;

import bean.items.ScheduleItem;
import bean.items.StationItem;
import bean.items.TrainItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import utils.ScheduleUtils;
import utils.StationUtils;
import utils.TrainUtils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private static Logger log = LogManager.getLogger(Controller.class);

    @FXML
    private ComboBox comboStationHoraire;
    @FXML
    private ComboBox comboTrainHoraire;

    @FXML
    private TableView<TableHoraire> tableHoraire;

    @FXML
    private ToggleGroup groupRadioHoraire;
    @FXML
    private RadioButton radioStationHoraire;
    @FXML
    private RadioButton radioTrainHoraire;
    @FXML
    private DatePicker dateHoraire;

    private StationUtils stationUtils;
    private TrainUtils trainUtils;
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

        if (trainUtils == null) {
            if(log.isDebugEnabled()){
                log.debug("Loading train file ...");
            }
            trainUtils = TrainUtils.getInstance();
            if(log.isDebugEnabled()){
                log.debug("Loading train file finished");
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
        DateTime date = new DateTime()
                .withDayOfMonth(dateHoraire.getValue().getDayOfMonth())
                .withMonthOfYear(dateHoraire.getValue().getMonthValue())
                .withYear(dateHoraire.getValue().getYear());
        List<ScheduleItem> scheduleItems;
        if(radioStationHoraire.isSelected()) {
            String valueComboStationHoraire = (String) comboStationHoraire.getValue();
            StationItem station = stationUtils.getStations().getStationByName(valueComboStationHoraire);
            scheduleItems = scheduleUtils.getSchedules().getScheduleItemsByStationId(station.getId(), date);
        }else{
            String valueComboTrainHoraire = (String)comboTrainHoraire.getValue();
            TrainItem train = trainUtils.getTrains().getTrainItemsByTrainName(valueComboTrainHoraire);
            scheduleItems = scheduleUtils.getSchedules().getScheduleItemsByTrainId(train.getId(), date);
        }





        if(tableHoraire.getColumns().size() == 0){
            TableColumn trainName = new TableColumn("Train");
            trainName.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("trainName")
            );
            TableColumn stationStartName = new TableColumn("Gare de départ");
            stationStartName.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("stationStartName")
            );
            TableColumn startHour = new TableColumn("Départ");
            startHour.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("startHour")
            );
            TableColumn stationEndName = new TableColumn("Gare d'arrivée");
            stationEndName.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("stationEndName")
            );
            TableColumn endHour = new TableColumn("Arrivée");
            endHour.setCellValueFactory(
                    new PropertyValueFactory<TableHoraire,String>("endHour")
            );
            tableHoraire.getColumns().addAll(trainName, stationStartName, startHour, stationEndName,endHour);
        }

        ObservableList<TableHoraire> items = FXCollections.observableArrayList();
        tableHoraire.setItems(items);
        scheduleItems.forEach(item -> {
                TrainItem trainHoraire = trainUtils.getTrains().getTrainItemsByTrainId(item.getIdTrain());
                StationItem stationStartHoraire = stationUtils.getStations().getStationById(item.getIdStationSrc());
                ScheduleItem scheduleHoraire = scheduleUtils.getSchedules().getScheduleItemsByTrainIdAndDestId(item.getIdStationDest(),trainHoraire.getId());
                StationItem stationEndHoraire = stationUtils.getStations().getStationById(scheduleHoraire.getIdStationDest());

                items.addAll(new TableHoraire(trainHoraire.getTrainName(), stationStartHoraire.getName(), item.getStartHour(), stationEndHoraire.getName(), scheduleHoraire.getStartHour()));
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

    public void initializeTrainHoraire(Event event) throws Exception{
        if(comboTrainHoraire.getItems().size() > 0){
            return;
        }
        List<TrainItem> trainItems = trainUtils.getTrains().getTrainList();
        ObservableList<String> items = FXCollections.observableArrayList();
        for(TrainItem train:trainItems){
            items.add(train.getTrainName());
        }
        comboTrainHoraire.setItems(items);

        if(groupRadioHoraire == null) {
            groupRadioHoraire = new ToggleGroup();
            radioStationHoraire.setToggleGroup(groupRadioHoraire);
            radioTrainHoraire.setToggleGroup(groupRadioHoraire);
        }
    }

    public void onClickOnRadioHoraire(Event event) throws Exception{
        if(((RadioButton)event.getSource()).getId().equals("radioStationHoraire")){
            comboStationHoraire.setDisable(false);
            comboTrainHoraire.setDisable(true);
        }else if(((RadioButton)event.getSource()).getId().equals("radioTrainHoraire")){
            comboStationHoraire.setDisable(true);
            comboTrainHoraire.setDisable(false);
        }
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
