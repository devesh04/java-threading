package e_design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by devesh on 11/07/19.
 */
public class LRUCache {

    Deque<Integer> deque = new ArrayDeque<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    int pageFrame = 5;

    public LRUCache(int pageFrame){
        this.pageFrame = pageFrame;
    }

    public void put(Integer i){
        if(map.containsKey(i)){
            deque.remove(i);
            deque.addFirst(i);
            if(deque.size() > pageFrame){
                map.remove(deque.removeLast());
            }
        }
        else{
            deque.addFirst(i);
            map.put(i, 1);
            if(deque.size() > pageFrame){
                map.remove(deque.removeLast());
            }
        }
    }

    public Integer get(Integer i){
        if(map.containsKey(i)){
            deque.remove(i);
            deque.addFirst(i);
            if(deque.size() > pageFrame){
                map.remove(deque.removeLast());
            }
            return i;
        }
        return null;
    }

    public void printCurrentQueue(){
        Iterator<Integer> iterator = this.deque.iterator();
        while(iterator.hasNext()){
            System.out.printf(iterator.next() + " ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        LRUCache cache = new LRUCache(3);
        cache.printCurrentQueue();
        cache.put(1);
        cache.printCurrentQueue();
        cache.put(2);
        cache.printCurrentQueue();
        cache.put(3);
        cache.printCurrentQueue();
        cache.put(4);
        cache.printCurrentQueue();
        cache.put(5);
        cache.printCurrentQueue();

        Integer integer = cache.get(1);
        System.out.println(">>" + integer);
        cache.printCurrentQueue();
//        cache.get(5);
        integer = cache.get(5);
        System.out.println(">>" + integer);
        cache.printCurrentQueue();


    }



}
