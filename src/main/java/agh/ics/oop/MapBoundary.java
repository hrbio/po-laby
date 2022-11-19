package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private TreeSet<Vector2d> xBound = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d v1, Vector2d v2) {
            int x1 = v1.getX();
            int x2 = v2.getX();

            if (x1 == x2) {
                int y1 = v1.getY();
                int y2 = v2.getY();
                return Integer.compare(y1, y2);
            }
            return Integer.compare(x1, x2);
        }
    });

    private TreeSet<Vector2d> yBound = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d v1, Vector2d v2) {
            int y1 = v1.getY();
            int y2 = v2.getY();

            if (y1 == y2) {
                int x1 = v1.getX();
                int x2 = v2.getX();
                return Integer.compare(x1, x2);
            }
            return Integer.compare(y1, y2);
        }
    });
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        xBound.remove(oldPosition);
        yBound.remove(oldPosition);
        xBound.add(newPosition);
        yBound.add(newPosition);
    }

    public void addVector(Vector2d position){
        xBound.add(position);
        yBound.add(position);
    }

    public Vector2d getLowerBoundary(){
        return new Vector2d(xBound.first().x,yBound.first().y);
    }

    public Vector2d getUpperBoundary(){
        return new Vector2d(xBound.last().x,yBound.last().y);
    }
}
