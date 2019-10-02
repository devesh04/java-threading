package e_design.kafka;

/**
 * Created by devesh on 01/11/18.
 */
public class Topic {

    String name;

    public Topic(String name){
        this.name = name;
    }

    public int hashcode(){
        return name.hashCode();
    }

    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(this == object){
            return true;
        }
        if(object instanceof Topic && object.hashCode() == this.hashCode()){
            return true;
        }
        return false;
    }

    public String toString(){
        return this.name;
    }

}
