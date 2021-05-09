package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane infoPane;

    @FXML
    private AnchorPane morePane;

    @FXML
    private AnchorPane aimPane;

    @FXML
    private AnchorPane testPane;

    @FXML
    private Pane mainPane;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    void button1() {

        label1.setFont(new Font("System Bold", 13));
        label2.setFont(new Font("System", 12));
        label3.setFont(new Font("System", 12));
        label4.setFont(new Font("System", 12));
        infoPane.setDisable(true);
        infoPane.setOpacity(0.0);
        aimPane.setDisable(false);
        aimPane.setOpacity(1.0);
        morePane.setDisable(true);
        morePane.setOpacity(0.0);
        testPane.setDisable(true);
        testPane.setOpacity(0.0);
    }

    @FXML
    void button2() {

        label1.setFont(new Font("System", 12));
        label2.setFont(new Font("System Bold", 13));
        label3.setFont(new Font("System", 12));
        label4.setFont(new Font("System", 12));
        infoPane.setDisable(true);
        infoPane.setOpacity(0.0);
        aimPane.setDisable(true);
        aimPane.setOpacity(0.0);
        testPane.setDisable(false);
        testPane.setOpacity(1.0);
        morePane.setDisable(true);
        morePane.setOpacity(0.0);
    }

    @FXML
    void button3() {

        label1.setFont(new Font("System", 12));
        label2.setFont(new Font("System", 12));
        label3.setFont(new Font("System Bold", 13));
        label4.setFont(new Font("System", 12));
        infoPane.setDisable(true);
        infoPane.setOpacity(0.0);
        aimPane.setDisable(true);
        aimPane.setOpacity(0.0);
        testPane.setDisable(true);
        testPane.setOpacity(0.0);
        morePane.setDisable(false);
        morePane.setOpacity(1.0);
    }

    @FXML
    void button4() {

        label1.setFont(new Font("System", 12));
        label2.setFont(new Font("System", 12));
        label3.setFont(new Font("System", 12));
        label4.setFont(new Font("System Bold", 13));
        infoPane.setDisable(false);
        infoPane.setOpacity(1.0);
        aimPane.setDisable(true);
        aimPane.setOpacity(0.0);
        testPane.setDisable(true);
        testPane.setOpacity(0.0);
        morePane.setDisable(true);
        morePane.setOpacity(0.0);
    }


    @FXML
    void goToAim() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sampleA.fxml"));
        stage.setTitle("Aim Trainer");
        stage.setScene(new Scene(root, 800, 600));
        stage.getIcons().add(new Image("crosshair.png"));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();
        appOpened();
        stage.setOnCloseRequest(e -> appExit());
    }

    void appOpened(){
        mainPane.setDisable(true);
    }

    void appExit(){
        mainPane.setDisable(false);
    }
    @FXML
    void openTest() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sovm.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Compatibility Test");
        stage.setScene(new Scene(root, 779, 555));
        stage.getIcons().add(new Image("heart.png"));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();
        appOpened();
        stage.setOnCloseRequest(e -> appExit());
    }
    @FXML
    void openG() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sampleG.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Guess the Number");
        stage.setScene(new Scene(root, 300, 300));
        stage.getIcons().add(new Image("1.png"));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();
        appOpened();
        stage.setOnCloseRequest(e -> appExit());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
