package agh.ics.oop;

public class World {

    private static OptionsParser optionsParser = new OptionsParser();
    public static void main(String[] args){

        String[] kierunki = {"r", "r", "r", "r", "r", "r"};

        MoveDirection[] directions = optionsParser.parse(kierunki);

        Animal antek = new Animal();

        for (MoveDirection direction : directions){
            antek.move(direction);
        }

        System.out.println(antek);
        System.out.println("Antek się kręci :)");

    }
}
