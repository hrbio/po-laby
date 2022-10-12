package agh.ics.oop;

public class World {


    public static void run(MoveDirection[] kierunki){
        for (MoveDirection kierunek : kierunki) {
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
        MoveDirection[] kierunki = new MoveDirection[n];
        for (int i = 0; i < n; i++){
            kierunki[i] = switch (args[i]){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> null;
            };
        }

        System.out.println("system wystartował");

        World.run(kierunki);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

//        MapDirection mapD = MapDirection.NORTH;
//
//        for (int i = 0; i < 4; i++){
//            System.out.println(mapD);
//            System.out.println(mapD.toUnitVector());
//            mapD = mapD.previous();
//        }

        System.out.println("system zakończył działanie");
    }
}
