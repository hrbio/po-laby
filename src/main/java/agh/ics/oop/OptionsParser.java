package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    private boolean isCorrect(String direction){
        return switch (direction) {
            case "f", "forward", "r", "right", "b", "backward", "l", "left" -> true;
            default -> false;
        };
    }

    private MoveDirection getDirection(String direction){
        return switch (direction){
            case "f", "forward" -> MoveDirection.FORWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "l", "left" -> MoveDirection.LEFT;
            default -> null;
        };
    }
    public MoveDirection[] parse(String[] directions){
        return Arrays.stream(directions).filter(direction -> isCorrect(direction)).map(e -> getDirection(e)).toArray(MoveDirection[]::new);
    }
}
