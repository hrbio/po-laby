package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap{
    private final List<Grass> grasses = new ArrayList<>();
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
        grasses.add(new Grass(tmp));
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
        for (Grass grass: grasses){
            if (grass.getPosition().equals(position)) return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return (isOccupiedByAnimal(position) || isOccupiedByGrass(position));
    }

    public Grass grassAt(Vector2d position){
        for (Grass grass: grasses){
            if (grass.getPosition().equals(position)) return grass;
        }
        return null;
    }

    public Object objectAt(Vector2d position){
        if (isOccupiedByAnimal(position)) return animalAt(position);
        return grassAt(position);
    }

    public Vector2d getLowerBoundary(){
        Vector2d out = animals.get(0).getPosition();
        for (Animal animal: animals){
            out = out.lowerLeft(animal.getPosition());
        }

        for (Grass grass: grasses){
            out = out.lowerLeft(grass.getPosition());
        }
        return out;
    }

    public Vector2d getUpperBoundary(){
        Vector2d out = animals.get(0).getPosition();
        for (Animal animal: animals){
            out = out.upperRight(animal.getPosition());
        }

        for (Grass grass: grasses){
            out = out.upperRight(grass.getPosition());
        }
        return out;
    }
}
