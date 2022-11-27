//package agh.ics.oop;
//
//import org.junit.jupiter.api.Assumptions;
//import org.junit.jupiter.api.Test;
//
//public class GrassFieldTest {
////    nie wiem jak testować trawę, z powodu losowości
//    private static OptionsParser optionsParser = new OptionsParser();
//
//    @Test
//    void testOne(){
//        String[] dir = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(dir);
//        IWorldMap map = new GrassField(10);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        Assumptions.assumeTrue(map.isOccupied(new Vector2d(2, -1)));
//        Assumptions.assumeTrue(map.isOccupied(new Vector2d(3, 7)));
//    }
//
//
//    @Test
//    void testTwo(){
//        String[] dir = {"r", "f", "f", "f", "b", "b", "r", "f", "b", "f"};
//        MoveDirection[] directions = optionsParser.parse(dir);
//        IWorldMap map = new GrassField(5);
//        Vector2d[] positions = { new Vector2d(8,1), new Vector2d(0,0)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        Assumptions.assumeTrue(map.isOccupied(new Vector2d(0, 3)));
//        Assumptions.assumeTrue(map.isOccupied(new Vector2d(8, 2)));
//    }
//
//    @Test
//    void testThree(){
//        String[] dir = {"b", "l", "b", "f", "r", "b", "b", "f", "b", "b", "l", "l"};
//        MoveDirection[] directions = optionsParser.parse(dir);
//        IWorldMap map = new GrassField(9);
//        Vector2d[] positions = { new Vector2d(6,4), new Vector2d(9,4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        Assumptions.assumeTrue(map.isOccupied(new Vector2d(9, 4)));
//        Assumptions.assumeTrue(map.isOccupied(new Vector2d(4, 2)));
//    }
//}
