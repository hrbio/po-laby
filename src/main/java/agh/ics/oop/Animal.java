package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final Vector2d upperRight = new Vector2d(4, 4);

    public String toString(){
        return "Zwierzak jest na pozycji " + position.toString() + ", w kierunku " + orientation.toString() + ".";
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        if (direction == MoveDirection.FORWARD){
            Vector2d tmp = this.position.add(this.orientation.toUnitVector());

            if (upperRight.lowerLeft(tmp).equals(tmp) && lowerLeft.upperRight(tmp).equals(tmp)){
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
            Vector2d tmp = this.position.add(this.orientation.toUnitVector());

            if (upperRight.lowerLeft(tmp).equals(tmp) && lowerLeft.upperRight(tmp).equals(tmp)){
                this.position = tmp;
            }
        }
    }

}
