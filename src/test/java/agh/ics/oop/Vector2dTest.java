package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    @Test
    void testEquals(){
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(1,2);
        Vector2d c = new Vector2d(-2, 1);
        int d = 12;

        Assertions.assertTrue(a.equals(b));
        Assertions.assertFalse(a.equals(c));
        Assertions.assertFalse(a.equals(d));
    }

    @Test
    void testToString(){
        Vector2d a = new Vector2d(1,2);
        Assertions.assertEquals(a.toString(), "(1,2)");
    }

    @Test
    void testPrecedes(){
        Vector2d a = new Vector2d(-2, 1);
        Vector2d b = new Vector2d(1,2);
        Vector2d c = new Vector2d(-3, 89);

        Assertions.assertTrue(a.precedes(b));
        Assertions.assertTrue(a.precedes(a));
        Assertions.assertFalse(a.precedes(c));
    }

    @Test
    void testFollows(){
        Vector2d a = new Vector2d(-2, 1);
        Vector2d b = new Vector2d(-3, 0);
        Vector2d c = new Vector2d(-1, 2);

        Assertions.assertTrue(a.follows(b));
        Assertions.assertTrue(a.follows(a));
        Assertions.assertFalse(a.follows(c));
    }

    @Test
    void testUpperRight(){
        Vector2d a = new Vector2d(1, 8);
        Vector2d b = new Vector2d(8, 1);
        Assertions.assertEquals(a.upperRight(b), new Vector2d(8,8));
    }

    @Test
    void testLowerLeft(){
        Vector2d a = new Vector2d(1, 8);
        Vector2d b = new Vector2d(8, 1);
        Assertions.assertEquals(a.lowerLeft(b), new Vector2d(1,1));
    }

    @Test
    void testAdd(){
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(-2, 1);

        Assertions.assertEquals(a.add(b), new Vector2d(-1, 3));
    }

    @Test
    void testSubtract(){
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(-2, 1);

        Assertions.assertEquals(a.subtract(b), new Vector2d(-3, -1));
    }

    @Test
    void testOpposite(){
        Vector2d a = new Vector2d(1, 1);

        Assertions.assertEquals(a.opposite(), new Vector2d(-1,-1));
    }
}
