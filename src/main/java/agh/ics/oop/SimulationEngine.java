package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<Animal>();
    private int n = 0;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.map = map;
        this.directions = directions;

        for (Vector2d position : positions) {
            animals.add(new Animal(map, position));
        }
    }
    public void run(){
        for (Animal animal: animals){
            map.place(animal);
        }

        while (n < directions.length) {
            for (Animal animal: animals){
                if (n >= directions.length) return;
                animal.move(directions[n]);
                n++;
            }
        }


    }

}
