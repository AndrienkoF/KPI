package com.company;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.shape.*;

public class Lab1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250);

        //////////////////////////////////////////////////////
        Rectangle redRec = new Rectangle(100, 170, 200, 50);
        root.getChildren().add(redRec);
        redRec.setFill(Color.RED);
        //////////////////////////////////////////////////////
        Ellipse blueEllipse = new Ellipse(130,125,30,95);
        root.getChildren().add(blueEllipse);
        blueEllipse.setFill(Color.BLUE);
        //////////////////////////////////////////////////////
        Rectangle greenRec = new Rectangle(100, 30, 200, 50);
        root.getChildren().add(greenRec);
        greenRec.setFill(Color.GREEN);
        //////////////////////////////////////////////////////
        Ellipse yellowEllipse = new Ellipse(270,125,30,95);
        root.getChildren().add(yellowEllipse);
        yellowEllipse.setFill(Color.YELLOW);
        //////////////////////////////////////////////////////
        Rectangle redRec2 = new Rectangle(200, 170, 100, 50);
        root.getChildren().add(redRec2);
        redRec2.setFill(Color.RED);
        //////////////////////////////////////////////////////

        scene.setFill(Color.ORCHID);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
