
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class Controller {

    @FXML
    private Button aim;

    String time;
    String time2;
    String diff;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button startButton;

    @FXML
    private CheckBox number15;

    @FXML
    private CheckBox number25;

    @FXML
    private CheckBox number35;

    @FXML
    private CheckBox size15;

    @FXML
    private CheckBox size25;

    @FXML
    private CheckBox size35;

    @FXML
    private Label score;

    @FXML
    private Label accLabel;

    @FXML
    private Label timeLabel;


    int buttons = 15;
    int butt = buttons;
    int shots = 0;
    int total = 0;
    boolean on = false;


    @FXML
    void got() {
        if (buttons != 1) {

            total++;
            shots += 1;
            change();
            buttons--;
            score.setText(String.format("LEFT: %d", butt - total));
        } else {
            total++;
            shots += 1;
            score.setText(String.format("LEFT: %d", butt - total));
            double acc = (double) total / (double) shots * 100.0;

            startButton.setDisable(false);

            aim.setOpacity(0.0);
            on = false;
            time2 = java.time.LocalTime.now().toString();
            diff = razn();
            timeLabel.setText(String.format("Your time: %s", diff));
            timeLabel.setOpacity(1.0);
            accLabel.setText(String.format("Accuracy: %.2f ", acc) + "% " + String.format("(%d/%d)", total, shots));
            total = 0;
            shots = 0;
            accLabel.setOpacity(1.0);
            aim.setDisable(true);
            menuBar.setDisable(false);


        }
    }

    @FXML
    void start() {

        if (!on) {
            buttons = butt;
            score.setText(String.format("LEFT: %d", butt - total));
            change();
            aim.setOpacity(1.0);
            on = true;
            startButton.setDisable(true);
            menuBar.setDisable(true);
            time = java.time.LocalTime.now().toString();

            aim.setDisable(false);

            timeLabel.setOpacity(0.0);
            accLabel.setOpacity(0.0);
        }


    }

    @FXML
    void click(MouseEvent event) {
        shots++;
    }

    void change() {
        double[] arr = randomC();
        aim.setLayoutX(arr[0]);
        aim.setLayoutY(arr[1]);
    }

    String razn() {
        String vr = time.substring(0, 12);
        String vr2 = time2.substring(0, 12);
        int minutes, seconds, millis, minutes2, seconds2, millis2, minutes3, seconds3, millis3, hours, hours2, hours3;

        hours = Integer.parseInt(vr.substring(0, 2));
        hours2 = Integer.parseInt(vr2.substring(0, 2));
        minutes = Integer.parseInt(vr.substring(3, 5));
        minutes2 = Integer.parseInt(vr2.substring(3, 5));
        seconds = Integer.parseInt(vr.substring(6, 8));
        seconds2 = Integer.parseInt(vr2.substring(6, 8));
        millis = Integer.parseInt(vr.substring(9, 12));
        millis2 = Integer.parseInt(vr2.substring(9, 12));

        if (millis2 < millis) {
            if (seconds2 > 0) {
                seconds2--;
            } else {
                if (minutes2 > 0) {
                    minutes2--;
                } else {
                    hours2--;
                    minutes2 += 59;
                }
                seconds2 += 59;
            }
            millis2 += 1000;
        }
        millis3 = millis2 - millis;

        if (seconds2 < seconds) {
            if (minutes2 > 0) {
                minutes2--;
                seconds2 += 60;
            } else {
                hours2--;
                seconds2 += 60;
                minutes2 += 59;
            }
        }
        seconds3 = seconds2 - seconds;

        if (minutes2 < minutes) {
            hours--;
            minutes += 60;
        }
        minutes3 = minutes2 - minutes;
        hours3 = hours2 - hours;
        String outm, outs, outms;
        outm = String.format("%d", minutes3);
        outs = String.format("%d", seconds3);
        outms = String.format("%d", millis3);
        if (minutes3 < 10) {
            outm = String.format("0%d", minutes3);
        }
        if (seconds3 < 10) {
            outs = String.format("0%d", seconds3);
        }
        if (millis3 < 10) {
            outms = String.format("00%d", millis3);
        } else if (millis3 < 100) {
            outms = String.format("0%d", millis3);
        }
        return String.format("%s:%s:%s", outm, outs, outms);

    }

    double[] randomC() {

        Random random = new Random();
        double x = random.nextInt(800 - (int) aim.getPrefWidth());
        double y = random.nextInt(450 - (int) aim.getPrefHeight());
        return new double[]{x, y};
    }

    @FXML
    void setNumber15() {
        buttons = 15;
        butt = buttons;
        number25.setSelected(false);
        number35.setSelected(false);
    }

    @FXML
    void setNumber25() {
        buttons = 25;
        butt = buttons;
        number15.setSelected(false);
        number35.setSelected(false);
    }

    @FXML
    void setNumber35() {
        buttons = 35;
        butt = buttons;
        number25.setSelected(false);
        number15.setSelected(false);
    }

    @FXML
    void setSize15() {
        aim.setPrefWidth(35.0);
        aim.setPrefHeight(35.0);
        size35.setSelected(false);
        size25.setSelected(false);
    }

    @FXML
    void setSize25() {
        aim.setPrefWidth(50.0);
        aim.setPrefHeight(50.0);
        size35.setSelected(false);
        size15.setSelected(false);
    }

    @FXML
    void setSize35() {
        aim.setPrefWidth(75.0);
        aim.setPrefHeight(75.0);
        size15.setSelected(false);
        size25.setSelected(false);
    }

}

