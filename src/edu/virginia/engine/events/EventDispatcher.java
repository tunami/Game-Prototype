package edu.virginia.engine.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EventDispatcher implements IEventDispatcher{

    Map<String, ArrayList<IEventListener>> listeners;
    
    
    public EventDispatcher() {
        listeners = new HashMap<String, ArrayList<IEventListener>>();
        
    }
    public void addEventListener(IEventListener listener, String eventType) {
        if(listeners.containsKey(eventType)) {
            listeners.get(eventType).add(listener);
        }
        else {
            ArrayList<IEventListener> temp = new ArrayList<IEventListener>();
            temp.add(listener);
            listeners.put(eventType, temp);
        }
       
       
    }

    
    public void removeEventListener(IEventListener listener, String eventType) {
        if(listeners.containsKey(eventType)) {
            listeners.get(eventType).remove(listener);
        }
        
    }

    //hashtable.event.geteventtype
    //
    public void dispatchEvent(Event event) {
        for(int i = 0; i < listeners.get(event.getEventType()).size();  i++) {
            listeners.get(event.getEventType()).get(i).handleEvent(event);
            
        }
    }

    public boolean hasEventListener(IEventListener listener, String eventType) {
        return (listeners.get(eventType).contains(listener));
    }

}
