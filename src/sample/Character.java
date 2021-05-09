package sample;


import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static sample.Controller.*;


public class Character extends Pane {
    public ImageView imageView;
    int count = 4;
    int columns = 4;
    int offsetX = 0;
    int offsetY = 0;
    int width = 64;
    int height = 64;
    int speed = 1;
    SpriteAnimation animation;

    public Character(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnimation(imageView, Duration.millis(300), count, columns, offsetX, offsetY, width, height);
        getChildren().addAll(imageView);
    }

    public void moveX(int x) {
        boolean right;
        right = x > 0;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right) this.setTranslateX(this.getTranslateX() + speed);
            else this.setTranslateX(this.getTranslateX() - speed);
            checkBorderX();
            checkCollision();


        }

    }

    public void checkBorderX() {
        if (this.getTranslateX() < -5) {
            this.setTranslateX(-5);
            animation.stop();
        } else if (this.getTranslateX() > widthScreen - 62 ) {
            this.setTranslateX(widthScreen - 62);
            animation.stop();
        }
    }

    public void moveY(int y) {
        boolean down;
        down = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down) this.setTranslateY(this.getTranslateY() + speed);
            else this.setTranslateY(this.getTranslateY() - speed);
            checkBorderY();
            checkCollision();

        }
    }

    public void checkBorderY() {
        if (this.getTranslateY() < 0) {
            this.setTranslateY(0);
            animation.stop();
        } else if (this.getTranslateY() > heightScreen - 112) {
            this.setTranslateY(heightScreen - 112);
            animation.stop();
        }
    }
    public void checkCollision() {
        if (this.getBoundsInParent().intersects(diamondView.getBoundsInParent())) {
            Random random = new Random();
            int diamondX = random.nextInt(widthScreen - 62);
            int diamondY = random.nextInt(heightScreen - 112);
            diamondView.setX(diamondX);
            diamondView.setY(diamondY);
            Controller.score++;
            Controller.text.setText("Score: " + Controller.score);

        }
    }
    public double checkDied() {
        double distance = Math.sqrt(Math.pow(this.getTranslateX()-chickenView.getX(),2)+Math.pow(this.getTranslateY()-chickenView.getY(),2));
        return distance;

    }
    public int getScore() {
        return score;
    }

}