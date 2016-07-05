package muditse.eventbus;

import java.util.ArrayList;
import java.util.List;


public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

/*    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }*/

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(Object obj){
        for (Observer observer : observers) {
            if(observer !=null){
                observer.update(obj);
            }
        }
    }
}
