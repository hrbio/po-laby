package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class World {

    private static OptionsParser optionsParser = new OptionsParser();
    public static void main(String[] args){
        MoveDirection[] directions = optionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
    }
}
