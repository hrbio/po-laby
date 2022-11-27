package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements Runnable{
    private MoveDirection[] directions;
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<Animal>();
    IPositionChangeObserver gui;
    private int n = 0;

    private int moveDelay;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions, IPositionChangeObserver gui, int moveDelay){
        this.map = map;
        this.directions = directions;
        this.gui = gui;
        this.moveDelay = moveDelay;

        for (Vector2d position : positions) {
            animals.add(new Animal(map, position));
        }
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positions, IPositionChangeObserver gui, int moveDelay){
        this.map = map;
        this.gui = gui;
        this.moveDelay = moveDelay;

        for (Vector2d position : positions) {
            animals.add(new Animal(map, position));
        }
    }

    public void setDirections(MoveDirection[] directions){
        this.directions = directions;
    }
    public void run(){
        for (Animal animal: animals){
            animal.addObserver(gui);
            map.place(animal);
        }

        while (n < directions.length) {
            try {
            for (Animal animal: animals){
                Thread.sleep(this.moveDelay);
                if (n >= directions.length) return;
                animal.move(directions[n]);
                n++;
            }
        }
        catch (InterruptedException e){

        }}




    }

}
