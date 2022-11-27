package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    private static GuiElementBox guiElementBox = new GuiElementBox();
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();
    abstract public boolean canMoveTo(Vector2d position);

    public boolean place(Animal animal){
        if (!canMoveTo(animal.getPosition())) throw new IllegalArgumentException("Can't place animal on position " + animal.getPosition());
        animal.addObserver(this);
        animal.addObserver(this.mapBoundary);
        this.mapBoundary.addVector(animal.getPosition());
        animals.put(animal.getPosition(), animal);
        return true;
    };

    abstract public boolean isOccupied(Vector2d position);

    abstract public Object objectAt(Vector2d position);

    boolean isOccupiedByAnimal(Vector2d position){
        return animals.containsKey(position);
    }

    public Animal animalAt(Vector2d position){
        return animals.get(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    abstract public Vector2d getLowerBoundary();

    abstract public Vector2d getUpperBoundary();

    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(getLowerBoundary(), getUpperBoundary());
    }

    public String objectAtToString(Vector2d position){

        Object object = this.objectAt(position);
        if (object != null){
            return object.toString();
        }
        return "";
    }

    public void toGridPane(GridPane grid){
        grid.setGridLinesVisible(true);
        Vector2d lowerBound = getLowerBoundary();
        Vector2d upperBound = getUpperBoundary();

        final String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 0;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n";


        for (int i = lowerBound.y; i <= upperBound.y; i++){
            for (int j = lowerBound.x; j <= upperBound.x; j++) {
                Object object = this.objectAt(new Vector2d(j, i));
                if (object instanceof IMapElement){
                    IMapElement element = (IMapElement) object;
                    try {
                        VBox vBox = guiElementBox.getCell(element);
                        vBox.setStyle(cssLayout);
                        GridPane.setHalignment(vBox, HPos.CENTER);
                        grid.add(vBox, j-lowerBound.x+1, Math.abs(i-upperBound.y)+1, 1, 1);
                    } catch (FileNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                } else {
                    VBox vBox = new VBox();
                    vBox.setStyle(cssLayout);
                    grid.add(vBox, j-lowerBound.x+1, Math.abs(i-upperBound.y)+1, 1, 1);
                }
            }
        }
        Label startLabel = new Label("x/y");
        VBox startBox = new VBox(startLabel);
        GridPane.setHalignment(startBox, HPos.CENTER);
        startBox.setStyle(cssLayout);
        grid.add(startBox, 0, 0, 1, 1);

        for (int i = lowerBound.x; i <= upperBound.x; i++){
            Label indexLabel = new Label(Integer.toString(i));
            VBox indexBox = new VBox(indexLabel);
            GridPane.setHalignment(indexBox, HPos.CENTER);
            indexBox.setStyle(cssLayout);
            grid.add(indexBox, i-lowerBound.x+1, 0, 1, 1);
        }

        for (int i = lowerBound.y; i <= upperBound.y; i++){
            Label indexLabel = new Label(Integer.toString(i));
            VBox indexBox = new VBox(indexLabel);
            GridPane.setHalignment(indexBox, HPos.CENTER);
            indexBox.setStyle(cssLayout);
            grid.add(indexBox, 0, Math.abs(i-upperBound.y)+1, 1, 1);
        }

        for (int i = lowerBound.x; i <= upperBound.x+1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for (int i = lowerBound.y; i <= upperBound.y+1; i++){
            grid.getRowConstraints().add(new RowConstraints(40));
        }
    }
}
