package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private int amount;
    private int boundary;

//    Moim zdaniem nie warto tworzyć interfejsu IMapElement, ponieważ i tak musimy trzymać trawę i zwierzęta w osobnych listach (by rozróżnić je na potrzebę wypisywania mapy)

    public GrassField(int amount){
        this.amount = amount;
        this.boundary = (int) Math.sqrt(amount*10);
        for (int i = 0; i < amount; i++){
            addGrass();
        }
    }

    public void addGrass(){
        Vector2d tmp = getRandomPosition(this.boundary);
        while (isOccupied(tmp)){
            tmp = getRandomPosition(this.boundary);
        }
        grasses.put(tmp, new Grass(tmp));
        this.mapBoundary.addVector(tmp);
    }

    public Vector2d getRandomPosition(int boundary){
        final int x = (int) (Math.random()*(boundary+1));
        final int y = (int) (Math.random()*(boundary+1));
        return new Vector2d(x,y);
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    public boolean isOccupiedByGrass(Vector2d position){
        return grasses.containsKey(position);
    }

    public boolean isOccupied(Vector2d position) {
        return (isOccupiedByAnimal(position) || isOccupiedByGrass(position));
    }

    public Grass grassAt(Vector2d position){
        return grasses.get(position);
    }

    public Object objectAt(Vector2d position){
        if (isOccupiedByAnimal(position)) return animalAt(position);
        return grassAt(position);
    }

    public Vector2d getLowerBoundary(){
        this.mapBoundary.getLowerBoundary();
        Vector2d out = null;
        for (Vector2d position: animals.keySet()){
            if (out == null) out = position;
            else out = out.lowerLeft(position);
        }

        for (Vector2d position: grasses.keySet()){
            if (out == null) out = position;
            else out = out.lowerLeft(position);
        }
        return out;
    }

    public Vector2d getUpperBoundary(){
        this.mapBoundary.getUpperBoundary();
        Vector2d out = null;
        for (Vector2d position: animals.keySet()){
            if (out == null) out = position;
            else out = out.upperRight(position);
        }
        for (Vector2d position: grasses.keySet()){
            if (out == null) out = position;
            else out = out.upperRight(position);
        }
        return out;
    }
}
