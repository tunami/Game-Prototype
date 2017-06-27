package edu.virginia.engine.display;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Nothing in this class (yet) because there is nothing specific to a Sprite yet that a DisplayObject
 * doesn't already do. Leaving it here for convenience later. you will see!
 * */
public class Sprite extends DisplayObjectContainer {

	public Sprite(String id, String imageFileName) {
		super(id, imageFileName);
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
	}
	/*
	public Point localToGlobal(Point p) {
	    if(this.parent == null) {
	        return p;
	    }
	    else {
	        Point iter;
	        iter.setLocation(this.getx + p.x, this.getY + p.y);
	        localToGlobal(iter);
	    }
	}*/
}
