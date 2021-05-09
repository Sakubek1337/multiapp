package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.*;
import java.util.Random;

public class ControllerG {

    int diff = 0;
    int score = 0;
    int hidden = 0;
    boolean again = false;

    @FXML
    private AnchorPane startPane;

    @FXML
    private Button checkB;

    @FXML
    private CheckBox easy;

    @FXML
    private CheckBox medium;

    @FXML
    private CheckBox hard;

    @FXML
    private CheckBox ult;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private TextField hiddenN;

    @FXML
    private TextField gText;

    @FXML
    private Label scoreL;

    @FXML
    void actE(ActionEvent event) {
        medium.setSelected(false);
        hard.setSelected(false);
        ult.setSelected(false);
        diff = 3;
    }

    @FXML
    void actH(ActionEvent event) {
        medium.setSelected(false);
        easy.setSelected(false);
        ult.setSelected(false);
        diff = 12;
    }

    @FXML
    void actM(ActionEvent event) {
        easy.setSelected(false);
        hard.setSelected(false);
        ult.setSelected(false);
        diff = 8;
    }

    @FXML
    void actU(ActionEvent event) {
        medium.setSelected(false);
        hard.setSelected(false);
        easy.setSelected(false);
        diff = 20;
    }

    @FXML
    void back(ActionEvent event) {
        gamePane.setDisable(true);
        gamePane.setOpacity(0.0);
        startPane.setOpacity(1.0);
        startPane.setDisable(false);
        diff = 0;
        easy.setSelected(false);
        hard.setSelected(false);
        ult.setSelected(false);
        medium.setSelected(false);
        gText.setText("");
        hiddenN.setStyle("-fx-background-color: white;");
    }

    @FXML
    void check(ActionEvent event) {
        if (!again) {
            try {
                int number = Integer.parseInt(gText.getText().trim());
                hiddenN.setText(String.format("%d", hidden));
                if (hidden == number) {
                    score += diff;
                    scoreL.setText(String.format("%d", score));
                    hiddenN.setStyle("-fx-background-color: green;");
                } else {
                    hiddenN.setStyle("-fx-background-color: red;");
                }
                checkB.setText("Again!");
                again = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Incorrect input!");
            }
        } else {
            gText.setText("");
            Random r = new Random();
            hidden = r.nextInt(diff) + 1;
            again = false;
            checkB.setText("Check!");
            hiddenN.setText("?");
            hiddenN.setStyle("-fx-background-color: white;");
        }
    }

    @FXML
    void start(ActionEvent event) {
        gamePane.setDisable(false);
        gamePane.setOpacity(1.0);
        startPane.setOpacity(0.0);
        startPane.setDisable(true);
        Random r = new Random();
        hiddenN.setText("?");
        hidden = r.nextInt(diff) + 1;
    }

}

