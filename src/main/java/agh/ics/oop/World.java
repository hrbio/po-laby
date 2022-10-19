package agh.ics.oop;

public class World {
    public static void main(String[] args){

        OptionsParser optionsParser = new OptionsParser();

        String[] kierunki = {"r", "r", "b", "b"};

        MoveDirection[] directions = optionsParser.parse(kierunki);

        Animal zwierzak = new Animal();

        for (MoveDirection direction : directions){
            zwierzak.move(direction);
        }

        System.out.println(zwierzak);
    }
}
