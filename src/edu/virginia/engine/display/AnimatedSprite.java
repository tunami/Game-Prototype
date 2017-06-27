package edu.virginia.engine.display;
import java.util.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class AnimatedSprite extends Sprite{

    boolean playing;
    int currentFrame;
    int animationSpeed;
    int clock;
    int startIndex;
    int endIndex;
    

    Map<String, Point> table = new HashMap<String, Point>();
    
    private BufferedImage[] images;
    
    public AnimatedSprite(String ID, String filename, int numFrames) {
       super(ID, filename);
       images = new  BufferedImage[numFrames];
       animationSpeed = 1;
       for(int i = 0; i < numFrames; i++) {
           //reads in the images w/ specific names on each png, with mario_0 ect
           //System.out.println(filename + "_"+i);
           
           images[i] = this.readImage(ID + "_"+i+".png");
       }
    }
    public AnimatedSprite(String ID, String filename) {
        super(ID, filename);
        
        animationSpeed = 1;
    }
    
    public void update(ArrayList<Integer> pressedKeys){
        clock++;
        
        
        //this.setImage(images[currentFrame % 3]);
        
        if(playing){
            if(clock%animationSpeed == 0) {
                if(currentFrame >= endIndex) {
                    currentFrame = startIndex;
                }
                else {
                    currentFrame++;
                }
                this.setImage(images[currentFrame]);
            
            }
        }
    }
    @Override
    public void draw(Graphics g){
        //g.drawImage(images[currentFrame%3], 50, 50, null);
    /* Call the super draw method in DisplayObject class */
        super.draw(g);
    }
    
    public void setAnimation(String str, int start, int end) {
        Point p = new Point(start, end);
        table.put(str, p);
    }
    //Calls an animation w/ it's name
    public void callAnimation(String str) {
        Point p = table.get(str);
        startIndex = p.x;
        endIndex = p.y;
        this.setPlaying(true);
    }
    public void setPlaying(boolean bool) {
        playing = bool;
    }
    public void setAnimationSpeed(int i){
        animationSpeed = i;
    }
    public int getAnimationSpeed(){
        return animationSpeed;
    }
}
