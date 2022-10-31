package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final List<Animal> animals = new ArrayList<Animal>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    public boolean canMoveTo(Vector2d position){
        if (!upperRight.lowerLeft(position).equals(position) || !lowerLeft.upperRight(position).equals(position)) return false;
        for (Animal animal : animals) {
            if (animal.isAt(position)) return false;
        }
        return true;
    }

    public boolean place(Animal animal){
        if (!canMoveTo(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }

    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

}
