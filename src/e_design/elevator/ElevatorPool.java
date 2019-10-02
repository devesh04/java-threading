package e_design.elevator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devesh on 11/07/19.
 */
public class ElevatorPool {

    private static final Map<String, Elevator> elevators = new HashMap<>();

    public static void addNewElevator(Elevator elevator){
        elevators.put(elevator.id, elevator);
    }
    public static Elevator getElevator(String id){
        return elevators.get(id);
    }

}
