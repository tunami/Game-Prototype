package edu.virginia.engine.display;


import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class DisplayObjectContainer extends DisplayObject{

    private ArrayList<DisplayObject> list;
    
    public DisplayObjectContainer(String id) {
        super(id); 
        list = new ArrayList<DisplayObject>();
    }
    public DisplayObjectContainer(String id, String filename) {
        super(id, filename); 
        list = new ArrayList<DisplayObject>();
    }
    @Override
    public void draw(Graphics g){
        super.draw(g);
        
        applyTransformations((Graphics2D) g);
        
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw(g);
        }
        
        //draw the pivot point to see
        reverseTransformations((Graphics2D) g);
    }
    //cos(2pi) closer and further depending on the part of orbit, elliptical orbit
    @Override
    public void update(ArrayList<Integer> pressedKeys) {
        
        super.update(pressedKeys);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).update(pressedKeys);
        }
    }
    
    public void addChild(DisplayObject x){
        x.setParent(this);
        list.add(x);
    }
    public void addChildAtIndex(DisplayObject x, int i) {
        x.setParent(this);
        list.add(i, x);;
    }
    public void removeChild(DisplayObject x){
        x.setParent(null);
        list.remove(x);
    }
    public void removeByIndex(DisplayObject x, int i){
        x.setParent(null);
        list.remove(i);
    }
    public DisplayObject getChildAtIndex(int i) {
        return list.get(i);
    }
    public DisplayObject getChildById(String id) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }
    public void removeAll(){
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setParent(null);
            list.remove(i);
        }
    }
    public List<DisplayObject> getChildren(){
        return list;
    }
    public boolean contains(DisplayObject x){
        if(list.contains(x)){
            return true;
        }
        else{
            return false;
        }
    }
}
