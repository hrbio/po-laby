package agh.ics.oop;

public class Animal {


    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final Vector2d upperRight = new Vector2d(4, 4);
//    public Animal(IWorldMap map){
//        this.map = map;
//    }
//
//    public Animal(IWorldMap map, Vector2d position){
//        this.map = map;
//        this.position = position;
//    }

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
                this.position = tmp;
            }
        }
    }

}
