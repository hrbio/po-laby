package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class World {

    private static OptionsParser optionsParser = new OptionsParser();
    public static void main(String[] args){
        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map.toString());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
