package agh.ics.oop;

public class World {


    public static void run(Direction.Directions[] kierunki){
        for (Direction.Directions kierunek : kierunki) {
            String message = switch (kierunek){
                case FORWARD -> "Zwierzak idzie do przodu\n";
                case BACKWARD -> "Zwierzak idzie do tyłu\n";
                case RIGHT -> "Zwierzak skręca w prawo\n";
                case LEFT -> "Zwierzak skręca w lewo\n";
                default -> "";
            };
            System.out.print(message);
        }

    }

    public static void main(String[] args){
        int n = args.length;
        Direction.Directions[] kierunki = new Direction.Directions[n];
        for (int i = 0; i < n; i++){
            kierunki[i] = switch (args[i]){
                case "f" -> Direction.Directions.FORWARD;
                case "b" -> Direction.Directions.BACKWARD;
                case "r" -> Direction.Directions.RIGHT;
                case "l" -> Direction.Directions.LEFT;
                default -> null;
            };
        }
        System.out.println("system wystartował");
        World.run(kierunki);
        System.out.println("system zakończył działanie");
    }
}
