package e_design.elevator;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by devesh on 11/07/19.
 */
public class Elevator {

    String id;
    ElevatorState state;

    Integer currentFloor;
    Integer approachingFloor;

    List<Floor> floors;

    ConcurrentLinkedQueue<Floor> requestQueue = new ConcurrentLinkedQueue<>();


    Long speed;
    TimeUnit speedUnit;

    Long waitTime;
    TimeUnit waitTimeUnit;

    ScheduledExecutorService executor;

    public Elevator(String id, List<Floor> floors){
        this.id = id;
        this.floors = floors;
        this.currentFloor = 0;

        this.speed = 2l;
        this.speedUnit = TimeUnit.SECONDS;

        this.waitTime = 1l;
        this.waitTimeUnit = TimeUnit.SECONDS;

        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.start();
    }

    public void start(){
        this.executor.scheduleWithFixedDelay(()->{
            try {
                this.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, this.waitTime, this.waitTime, this.waitTimeUnit);
    }

    public void stop(){
        this.executor.shutdown();
    }


    private boolean isAtHighestFloor(){
        return this.currentFloor == floors.size() - 1;
    }

    private boolean isAtLowestFloor(){
        return this.currentFloor == 0;
    }

    private void moveUp() throws InterruptedException, IllegalStateException {
        if(!isAtHighestFloor()){
            this.state = ElevatorState.MOVING_UP;
            this.approachingFloor = this.currentFloor + 1;
            Thread.sleep(speedUnit.toMillis(speed));
            this.state = ElevatorState.IDLE;
            this.currentFloor = this.approachingFloor;
            this.approachingFloor = -1;
        }
        else{
            throw new IllegalStateException("can't go up");
        }

    }

    private void moveDown() throws InterruptedException, IllegalStateException {
        if(!isAtLowestFloor()){
            this.state = ElevatorState.MOVING_DOWN;
            this.approachingFloor = this.currentFloor - 1;
            Thread.sleep(speedUnit.toMillis(speed));
            this.state = ElevatorState.IDLE;
            this.currentFloor = this.approachingFloor;
            this.approachingFloor = -1;
        }
        else{
            throw new IllegalStateException("can't go down");
        }

    }

    private void moveTo(Floor floor) throws InterruptedException {
        int i = this.floors.indexOf(floor) - this.currentFloor;
        while(!this.floors.get(this.currentFloor).equals(floor)){
            if(i > 0){
                moveUp();
            }
            else{
                moveDown();
            }
        }
    }

    private void move() throws InterruptedException {
        while(!requestQueue.isEmpty()){
            Floor poll = requestQueue.poll();
            moveTo(poll);
        }
        this.state = ElevatorState.IDLE;
        Thread.sleep(waitTimeUnit.toMillis(waitTime));
    }

    public void requestFloor(Floor floor){
        this.state = ElevatorState.ACTIVE;
        requestQueue.add(floor);
    }


    public void printLiftState(){
        StringBuilder sb = new StringBuilder();
        sb.append(toString()+"\n");
        sb.append("state:" + state+ "\n");
        sb.append("current:" + currentFloor+ "\n");
        sb.append("approaching :" + approachingFloor+ "\n");

        System.out.println(sb.toString());

    }

    public String toString(){
        return "Elevator:" + this.id;
    }

    public int hashCode(){
        return id.hashCode();
    }

    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null) {
            return false;
        }
        if(object instanceof Floor){
            Elevator elevator = (Elevator) object;
            if(elevator.id == this.id){
                return true;
            }
        }
        return false;
    }


}
