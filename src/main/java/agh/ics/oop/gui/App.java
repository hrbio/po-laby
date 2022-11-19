package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage){
        MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,12), new Vector2d(3,8) };

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        GridPane grid = map.toGridPane();

        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
