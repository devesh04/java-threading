package e_design.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devesh on 11/07/19.
 */
public class Building {

    List<Floor> floors = new ArrayList<>();

    List<Elevator> elevators = new ArrayList<>();


    public void addElevator(Elevator elevator){
        this.elevators.add(elevator);
    }

    public void addFloor(Floor f){
        floors.add(f);
    }

    public Floor lowestFloor(){
        return floors.get(0);
    }

    public Integer numberOfFloors(){
        return floors.size();
    }

    public Floor highestFloor(){
        return floors.get(numberOfFloors() -1);
    }


}
