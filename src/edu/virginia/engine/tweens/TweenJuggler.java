package edu.virginia.engine.tweens;

import java.util.ArrayList;

public class TweenJuggler {
    private static TweenJuggler source;
    ArrayList<Tween> tweens;
    
    public TweenJuggler() {
        if(source != null) {
            System.out.println("No more than one source");
        }
        else {
            source = this;
        }
        tweens = new ArrayList<Tween>();
    }
    public void add(Tween t){
        tweens.add(t);
    }
    public static TweenJuggler getSource(){
        return source;
    }
    public void update(){
        for(int i = 0; i < tweens.size(); i++){
            tweens.get(i).update();
        }
        
        for(int i = 0; i < tweens.size(); i++){
           if( tweens.get(i).isComplete()) {
               tweens.remove(i);
           }
        }
    }
    
}
