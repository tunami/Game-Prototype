package edu.virginia.lab1test;

import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.IEventListener;

public class QuestManager implements IEventListener{

    private boolean complete = true;
    public void handleEvent(Event event) {
        if(event.getEventType().equals("picked_up")) {
            //instance of 
            Sprite e = (Sprite) event.getSource();
            //e.setAlpha(0);
            if(complete) {
                
                System.out.println("Quest Complete");
                complete = false;
            }
        }
        
    }
    
}
