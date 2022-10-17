package agh.ics.oop;

public class World {
    public static void main(String[] args){
        Animal zwierzak = new Animal();

        zwierzak.move(MoveDirection.RIGHT);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.FORWARD);

        System.out.println(zwierzak);
    }
}
