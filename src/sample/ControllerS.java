package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

public class ControllerS implements Initializable {

    Image img = new Image("heart.png");
    @FXML
    private ProgressBar progBar;

    @FXML
    private TextField nameOne;

    @FXML
    private TextField nameTwo;

    @FXML
    private Label topLabel;

    @FXML
    private Label rightLabel;

    @FXML
    private Label leftLabel;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label9;

    @FXML
    private ImageView imgview;

    Random random = new Random();


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        progBar.setStyle("-fx-accent: #00FF00;");
        imgview.setImage(img);
    }

    @FXML
    void progressing() throws InterruptedException {
        submit();

    }

    public void submit() throws InterruptedException{
        String name1 = nameOne.getText().trim();
        String name2 = nameTwo.getText().trim();
        if (name1.length() != 0 && name2.length() != 0){

            int rand = random.nextInt(101);
            double rant = Double.parseDouble(Integer.toString(rand)) / 100;
            Thread.sleep(1000);
            progBar.setProgress(rant);
            String message = String.format("%s + %s = %d", name1, name2, rand) + "%";
            JOptionPane.showMessageDialog(null, message);
            nameOne.setText("");
            nameTwo.setText("");
            leftLabel.setText(name1);
            rightLabel.setText(name2);
            setText(message);
            setProgBarColor(rand);
        }else{
            String message = "Неправильный ввод!";
            JOptionPane.showMessageDialog(null, message);
        }
    }

    public void setText(String msg){
        if (label1.getText().equals("")){
            label1.setText(msg);
        }else if (label2.getText().equals("")){
            label2.setText(msg);
        }else if (label3.getText().equals("")){
            label3.setText(msg);
        }else if (label4.getText().equals("")){
            label4.setText(msg);
        }else if (label5.getText().equals("")){
            label5.setText(msg);
        }else if (label6.getText().equals("")){
            label6.setText(msg);
        }else if (label7.getText().equals("")){
            label7.setText(msg);
        }else if (label8.getText().equals("")){
            label8.setText(msg);
        }else if (label9.getText().equals("")){
            label9.setText(msg);
        }else{
            label1.setText(label2.getText());
            label2.setText(label3.getText());
            label3.setText(label4.getText());
            label4.setText(label5.getText());
            label5.setText(label6.getText());
            label6.setText(label7.getText());
            label7.setText(label8.getText());
            label8.setText(label9.getText());
            label9.setText(msg);
        }
    }

    public void setProgBarColor(int percent){
        if (percent < 26){
            progBar.setStyle("-fx-accent: #fc0303;");
            topLabel.setText("Poor 😢");
        }else if (percent < 60){
            progBar.setStyle("-fx-accent: #f8fc03;");
            topLabel.setText("Not bad 😉");
        }else if (percent < 80){
            progBar.setStyle("-fx-accent: #03fc03;");
            topLabel.setText("Good 😁");
        }else if (percent < 100){
            progBar.setStyle("-fx-accent: #03fcfc;");
            topLabel.setText("Excellent😊");
        }else{
            progBar.setStyle("-fx-accent: #fa39d3;");
            topLabel.setText("Perfect 😍❤");
        }
    }

    public void enter(KeyEvent event) throws InterruptedException {
        if (event.getCode() == KeyCode.ENTER) {
            submit();
        }
    }




}
