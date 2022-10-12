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
//        World.run(kierunki);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("system zakończył działanie");
    }
}
