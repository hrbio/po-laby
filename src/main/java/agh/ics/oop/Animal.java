package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {


    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    private final List<IPositionChangeObserver> observers = new ArrayList<>();
    private IWorldMap map;
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d position){
        this.map = map;
        this.position = position;
    }

    public String toString(){
        return switch (orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        if (direction == MoveDirection.FORWARD){
            Vector2d tmp = this.position.add(this.orientation.toUnitVector());
            if (map.canMoveTo(tmp)){
                this.positionChanged(this.position, tmp);
                this.position = tmp;
            }
        }

        if (direction == MoveDirection.RIGHT){
            this.orientation = this.orientation.next();
            return;
        }

        if (direction == MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
            return;
        }

        if (direction == MoveDirection.BACKWARD){
            Vector2d tmp = this.position.subtract(this.orientation.toUnitVector());
            if (map.canMoveTo(tmp)){
                this.positionChanged(this.position, tmp);
                this.position = tmp;
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public Vector2d getPosition(){
        return this.position;
    }

}
