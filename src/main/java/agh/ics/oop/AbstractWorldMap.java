package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    abstract public boolean canMoveTo(Vector2d position);

    public boolean place(Animal animal){
        if (!canMoveTo(animal.getPosition())) return false;
        animal.addObserver(this);
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
}
