package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
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

    void appOpened() {
        mainPane.setDisable(true);
    }

    void appExit() {
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
    public static int chickenY;
    public static int chickenX;
    public static int widthScreen  = 650;
    public static int heightScreen  = 650;
    private final HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public Image image = new Image("gZ3c5.png");
    public ImageView imageView = new ImageView(image);
    public static Image imageofDiamond = new Image("eggre.png",25,20,false,false);
    public static  ImageView diamondView  = new ImageView(imageofDiamond);
    public static  Image imageofChicken = new Image("chickenright.gif",40,35,false,false);
    public static ImageView chickenView  = new ImageView(imageofChicken);
    Character player = new Character(imageView);
    static Pane root1 = new Pane();
    Random random = new Random();
    public static Text text = new Text();
    public static int  score = 0 ;
    String musicorigin;
    Clip clip;
    public void chicken() {

        chickenX = random.nextInt(600);
        chickenY = random.nextInt(600);
        chickenView.setX(chickenX);
        chickenView.setY(chickenY);

        root1.getChildren().addAll(chickenView);


    }
    int x = chickenX;
    int chickenX_change;


    public void chickenMove() {
        x += chickenX_change;
        if (x <= 0) {
            chickenX_change = 2;
            imageofChicken = new Image("chickenright.gif",40,35,false,false);
        }else if (x >= 600) {
            chickenX_change = -2;
            imageofChicken = new Image("chickenleft.gif",40,35,false,false);
        }
        chickenView.setX(x);
        chickenView.setImage(imageofChicken);


    }

    public void music() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = new File("C:\\Users");
        fileChooser.setInitialDirectory(file);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            if (musicorigin != null) {
                clip.stop();
            }
            musicorigin = selectedFile.getAbsolutePath();
            File file2 = new File(musicorigin);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file2);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }else {
            System.out.println();
        }
    }


    public void diamond() {

        int diamondX = random.nextInt(450);
        int diamondY = random.nextInt(250);
        diamondView.setX(diamondX);
        diamondView.setY(diamondY);

        root1.getChildren().addAll(diamondView);

    }




    public void update() {

        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(192);
            player.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(128);
            player.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(64);
            player.moveX(-2);
        }
        else{
            player.animation.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }
    boolean first = true;
    @FXML
    void startG() {
        Stage primaryStage = new Stage();
        root1 = new Pane();
        Scene scene = new Scene(root1);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Getter.io");
        primaryStage.setScene(scene);
        primaryStage.setHeight(heightScreen + 50);
        primaryStage.setWidth(widthScreen );
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> appExit());
        appOpened();
        text.setY(20);
        text.setX(300);

        text.setFill(Color.RED);
        text.setText("Score: " + score);
        text.setFont(Font.font("Verdana",30));
        text.setLayoutX(-50);
        text.setLayoutY(-30);
        Button button = new Button("\uD83D\uDCC0");
        button.setOpacity(1);
        button.setLayoutX(0);
        button.setLayoutY(-50);
        button.setOnAction(event -> {
            try {
                music();
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                e.printStackTrace();
            }
        });
        root1.getChildren().addAll(button);
        primaryStage.getIcons().add(new Image("mainchicken.gif"));
        root1.setPrefSize(widthScreen,heightScreen);
        root1.setLayoutX(0);
        root1.setLayoutY(50);
        BackgroundImage myBI= new BackgroundImage(new Image("https://i.redd.it/s80ltgvbyso11.png",widthScreen,heightScreen,false,false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        diamond();
        chicken();
        root1.getChildren().addAll(player);
        root1.setBackground(new Background(myBI));
        root1.getChildren().addAll(text);
        scene.setOnKeyPressed(event->keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event-> keys.put(event.getCode(), false));
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                chickenMove();

                if(player.checkDied() < 30) {
                    root1.getChildren().remove(player);
                    root1.getChildren().remove(chickenView);
                    root1.getChildren().remove(diamondView);
                    Text text = new Text("You lost");
                    text.setFont(Font.font("Rockwell",65));
                    text.setLayoutX(200);
                    text.setLayoutY(300);
                    text.setFill(Color.rgb(200,122,111));
                    root1.getChildren().addAll(text);




                }else if (player.getScore() > 19) {
                    root1.getChildren().remove(player);
                    root1.getChildren().remove(chickenView);
                    root1.getChildren().remove(diamondView);
                    Text text = new Text("You won");
                    text.setFont(Font.font("Rockwell",65));
                    text.setLayoutX(200);
                    text.setLayoutY(300);
                    text.setFill(Color.rgb(200,122,111));
                    root1.getChildren().addAll(text);
                }



            }
        };
        timer.start();


}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}





