package agh.ics.oop;

public class Grass {
    private Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return "*";
    }
}
