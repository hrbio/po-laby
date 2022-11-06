package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{

    protected final List<Animal> animals = new ArrayList<>();
    abstract public boolean canMoveTo(Vector2d position);

    public boolean place(Animal animal){
        if (!canMoveTo(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    };

    abstract public boolean isOccupied(Vector2d position);

    abstract public Object objectAt(Vector2d position);

    boolean isOccupiedByAnimal(Vector2d position){
        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }
        return false;
    }

    public Animal animalAt(Vector2d position){
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }

    abstract public Vector2d getLowerBoundary();

    abstract public Vector2d getUpperBoundary();

    public String toString(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(getLowerBoundary(), getUpperBoundary());
    }
}
