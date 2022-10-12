package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {

    @Test
    void testNext(){
        MapDirection mapDirection = MapDirection.NORTH;
        mapDirection = mapDirection.next();
        Assertions.assertEquals(mapDirection, MapDirection.EAST);
        mapDirection = mapDirection.next();
        Assertions.assertEquals(mapDirection, MapDirection.SOUTH);
        mapDirection = mapDirection.next();
        Assertions.assertEquals(mapDirection, MapDirection.WEST);
        mapDirection = mapDirection.next();
        Assertions.assertEquals(mapDirection, MapDirection.NORTH);
    }

    @Test
    void testPrevious(){
        MapDirection mapDirection = MapDirection.NORTH;
        mapDirection = mapDirection.previous();
        Assertions.assertEquals(mapDirection, MapDirection.WEST);
        mapDirection = mapDirection.previous();
        Assertions.assertEquals(mapDirection, MapDirection.SOUTH);
        mapDirection = mapDirection.previous();
        Assertions.assertEquals(mapDirection, MapDirection.EAST);
        mapDirection = mapDirection.previous();
        Assertions.assertEquals(mapDirection, MapDirection.NORTH);
    }

}
