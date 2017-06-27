package edu.virginia.engine.tweens;

import java.util.ArrayList;

import edu.virginia.engine.display.DisplayObject;
import edu.virginia.engine.events.EventDispatcher;
import edu.virginia.engine.util.GameClock;

public class Tween extends EventDispatcher{
    
    ArrayList<TweenParam> params;
    DisplayObject tweened;
    GameClock timer = new GameClock(); //reset it and get the elapsed time and stuff
    double percent;
    
    public Tween(DisplayObject object){
        params = new ArrayList<TweenParam>();
        tweened = object;
        
    }
    public boolean isComplete() {
       
        int total = 0;
        for(int i = 0; i <params.size(); i++) {
            if(params.get(i).isComplete()) {
                total++;
            }
        }
        if(total == params.size()) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * @param fieldToAnimate
     * @param startval
     * @param endval
     * @param time
     */
    public void animate(TweenableParam fieldToAnimate, double startval, double endval,
            double time) {
            
            TweenParam t = new TweenParam(fieldToAnimate, startval, endval, time);

            params.add(t);
            
    }
    public void update() {
        
        
        for(int i = 0 ; i <params.size(); i++){
        //System.out.println(params.get(i).isComplete());
          
         if(!params.get(i).isComplete())  {
            
            percent = params.get(i).getCurrTime() / params.get(i).getTotaltime();
            
            //System.out.println("percent:" +percent);
            
            //how much there is to go
            double t = ((params.get(i).getEnd() - params.get(i).getStart()) * percent);
           
            //System.out.println(t);
            
            if(params.get(i).getParam() == TweenableParam.XPOS) {
                tweened.setPosx(tweened.getPosx() + (int)t);
            }
            if(params.get(i).getParam() == TweenableParam.YPOS) {
                tweened.setPosy(tweened.getPosy() + (int)t);
            }
            if(params.get(i).getParam() == TweenableParam.YSCALE) {
                tweened.setScaleY(tweened.getScaleY() + t);
            }
            if(params.get(i).getParam() == TweenableParam.XSCALE) {
                tweened.setScaleX(tweened.getScaleX() + t);
                
            }
            if(params.get(i).getParam() == TweenableParam.ALPHA) {
                if(( (float) t) >= 0 && ((float) t) <=1) {
                    
                    tweened.setAlpha((float) t);
                }
            }
            
            
            params.get(i).setCurrTime(timer.getElapsedTime() + params.get(i).getCurrTime());
           
            //System.out.println("curr "+params.get(i).getCurrTime());
            timer.resetGameClock();
            
            if(percent >= 1) {
                
                params.get(i).setComplete(true);
                
                
            }
          }
        }
         
    }
    
    //public void setValue(TweenableParams param, double value) {}
}
