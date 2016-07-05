package muditse.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.security.Key;
import java.util.HashMap;


public class EventManager {

    private static EventManager eventManager;

    private HashMap<String,Subject> events = new HashMap<>();

    private EventManager(){

    }

    public static EventManager getInstance(){
        return eventManager!=null?eventManager:(eventManager =new EventManager());
    }

    public void fireEvent(final String key,final Object obj){
        if(events.get(key)!=null){
            if(Looper.myLooper() == Looper.getMainLooper()){
                events.get(key).notifyAllObservers(obj);
            }else{
                if(Looper.getMainLooper() !=null){
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            events.get(key).notifyAllObservers(obj);
                        }
                    });
                }else{
                    throw new IllegalStateException("Activity is not running on main thread");
                }

            }

        }else{
            throw new IllegalStateException("Please Create Your Event First");
        }
    }

    public void createEvent(String key){
        try {
            events.put(key,new Subject());
            Log.i(EventManager.class.getName(),"Event Created by name " +key);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addObserver(String key,Observer observer){
        events.get(key).attach(observer);
    }
}
