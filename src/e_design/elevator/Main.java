package e_design.elevator;

/**
 * Created by devesh on 11/07/19.
 */
public class Main {

    public static void main(String ar[]) throws InterruptedException {

        Building building = new Building();
        building.addFloor(new Floor(0, "GF"));
        building.addFloor(new Floor(1));
        building.addFloor(new Floor(2));
        building.addFloor(new Floor(3));
        building.addFloor(new Floor(4));
        building.addFloor(new Floor(5));

        building.addElevator(new Elevator("abcd", building.floors));


        Elevator elevator = building.elevators.get(0);
        elevator.printLiftState();
        System.out.println("-------");

        elevator.requestFloor(new Floor(4));
        elevator.requestFloor(new Floor(4));

        while(elevator.state != ElevatorState.IDLE){
            elevator.printLiftState();
            System.out.println("-------");
            Thread.sleep(1000);
        }
        elevator.printLiftState();

        while(elevator.state != ElevatorState.IDLE){
            elevator.printLiftState();
            System.out.println("-------");
            Thread.sleep(1000);
        }


        elevator.requestFloor(new Floor(0));
        elevator.printLiftState();
        while(elevator.state != ElevatorState.IDLE){
            elevator.printLiftState();
            System.out.println("-------");
            Thread.sleep(1000);
        }
        elevator.printLiftState();
    }
}
