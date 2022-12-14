package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    public boolean canMoveTo(Vector2d position){
        if (!upperRight.lowerLeft(position).equals(position) || !lowerLeft.upperRight(position).equals(position)) return false;
        return !isOccupiedByAnimal(position);
    }

    public boolean isOccupied(Vector2d position){
        return isOccupiedByAnimal(position);
    }

    public Object objectAt(Vector2d position){
        return animalAt(position);
    }

    public Vector2d getLowerBoundary(){
        return lowerLeft;
    }

    public Vector2d getUpperBoundary(){
        return upperRight;
    }
}
