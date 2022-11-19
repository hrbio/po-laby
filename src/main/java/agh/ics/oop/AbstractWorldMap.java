package agh.ics.oop;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

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

    public GridPane toGridPane(){
        GridPane grid = new GridPane();
        Vector2d lowerBound = getLowerBoundary();
        Vector2d upperBound = getUpperBoundary();


        for (int i = lowerBound.y; i <= upperBound.y; i++){
            for (int j = lowerBound.x; j <= upperBound.x; j++) {

                Label label = new Label(this.objectAtToString(new Vector2d(j, i)));
                GridPane.setHalignment(label, HPos.CENTER);
                grid.add(label, j-lowerBound.x+1, Math.abs(i-upperBound.y)+1, 1, 1);
            }
        }

        Label startLabel = new Label("x/y");
        GridPane.setHalignment(startLabel, HPos.CENTER);
        grid.add(startLabel, 0, 0, 1, 1);

        for (int i = lowerBound.x; i <= upperBound.x; i++){
            Label indexLabel = new Label(Integer.toString(i));
            GridPane.setHalignment(indexLabel, HPos.CENTER);
            grid.add(indexLabel, i-lowerBound.x+1, 0, 1, 1);
        }

        for (int i = lowerBound.y; i <= upperBound.y; i++){
            Label indexLabel = new Label(Integer.toString(i));
            GridPane.setHalignment(indexLabel, HPos.CENTER);
            grid.add(indexLabel, 0, Math.abs(i-upperBound.y)+1, 1, 1);
        }

        for (int i = lowerBound.x; i <= upperBound.x+1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(20));
        }

        for (int i = lowerBound.y; i <= upperBound.y+1; i++){
            grid.getRowConstraints().add(new RowConstraints(20));
        }
        return grid;
    }
}
