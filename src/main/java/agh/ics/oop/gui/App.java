package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application implements IPositionChangeObserver {
    AbstractWorldMap map;
    Stage primaryStage;
    GridPane grid;
    Thread engineThread;
    Button startButton;
    Button setDirections;
    TextField inputDirections;
    SimulationEngine engine;
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,10), new Vector2d(3,8) };


        this.engine = new SimulationEngine(this.map, positions, this, 300);


        this.engineThread = new Thread(engine);

        this.startButton = new Button("Start");
        this.startButton.setOnAction((e) -> {
            this.grid = new GridPane();
            Scene scene = new Scene(this.grid, 600, 600);
            this.primaryStage.setScene(scene);
            engineThread.start();
            this.map.toGridPane(grid);
        });
        this.startButton.setDisable(true);

        this.inputDirections = new TextField();

        this.setDirections = new Button("Set Directions");
        this.setDirections.setOnAction((e) -> {
            MoveDirection[] directions = new OptionsParser().parse(this.inputDirections.getText().split(" +"));
            this.engine.setDirections(directions);
            this.startButton.setDisable(false);
        });

        VBox directionsSection = new VBox(new Label("Podaj ruchy:"),this.inputDirections, this.setDirections);

        HBox menuUI = new HBox(this.startButton,directionsSection);
        Scene menu = new Scene(menuUI, 600, 600);
        this.primaryStage.setScene(menu);

        this.primaryStage.show();
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            this.map.toGridPane(grid);
        });

    }
}
