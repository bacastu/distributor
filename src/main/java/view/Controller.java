package view;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public Controller(){
        super();
    }

    public void onClickButtonHoraire(MouseEvent event) throws Exception{
        changeScene(event, "horaire.fxml");
    }

    public void onClickButtonAnnuler(MouseEvent event) throws Exception{
        changeScene(event, "distributor.fxml");
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    private void changeScene(MouseEvent event, String sceneFxml) throws Exception{
        Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource(sceneFxml));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
