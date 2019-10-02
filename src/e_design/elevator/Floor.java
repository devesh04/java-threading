package e_design.elevator;

/**
 * Created by devesh on 11/07/19.
 */
public class Floor {

    int number;
    String name;

    public Floor(int number){
        this.number = number;
    }

    public Floor(int number, String name){
        this.number = number;
        this.name = name;
    }


    public String toString(){
        return "Floor:" + this.number +" " + name;
    }

    public int hashCode(){
        return Integer.hashCode(number);
    }

    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null) {
            return false;
        }
        if(object instanceof Floor){
            Floor floor = (Floor) object;
            if(floor.number == this.number){
                return true;
            }
        }
        return false;
    }
}
