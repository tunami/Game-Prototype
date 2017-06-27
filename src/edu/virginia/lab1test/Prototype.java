package edu.virginia.lab1test;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.PhysicsSprite;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.events.Event;
import edu.virginia.engine.tweens.Tween;
import edu.virginia.engine.tweens.TweenJuggler;
import edu.virginia.engine.tweens.TweenableParam;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class Prototype extends Game{
    
    //public static final String COIN_PICKED_UP = "picked_up";
    
    //PhysicsSprite red = new PhysicsSprite("dog", "dog_0.png", 6);
    
    //PhysicsSprite gold = new PhysicsSprite("gold", "gold.png");
    PhysicsSprite background = new PhysicsSprite("background", "space_background.jpg");
    PhysicsSprite player = new PhysicsSprite("player", "player.png");
    PhysicsSprite rock1 = new PhysicsSprite("rock", "rock.png");
    PhysicsSprite rock2 = new PhysicsSprite("rock2", "rock.png");
    /**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public Prototype() {
		super("Spash Protype", 1280, 800);
		this.addChild(background);
		background.addChild(player);
		background.addChild(rock1);
		background.addChild(rock2);
		
		
		
		rock1.setPosx(200);
		rock1.setPosy(200);
		
		rock1.setPivotX(rock1.getPosx() + rock1.getUnscaledWidth());
		rock1.setPivotY(rock1.getPosy() + rock1.getUnscaledHeight());
		
		rock2.setPosx(700);
        rock2.setPosy(200);
		
		player.setPosx(500);
		player.setPosy(500);
	}
	
	/**
	 * Engine will automatically call this update method once per frame and pass to us
	 * the set of keys (as strings) that are currently being pressed down
	 * */
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		
		if(player.collidesWith(rock1)) {
		    if(!rock1.isSticking()){
		        rock1.setSticking(true);
		        
	              Point p = new Point();
	                p.x =  (rock1.getPosx());
	                p.y = (rock1.getPosy());
		        background.removeChild(rock1);
		        
		        player.addChild(rock1);
		        rock1.setXy(p);
		    }
		}
		if(rock1.isSticking()){
		    
		    rock1.setPosx((int) (- rock1.getXy().getX()));
            rock1.setPosy((int) ( - rock1.getXy().getY()));
		}
		//pivot point in the center and do the x-y, then move it 80% of the way
		
		
		if(pressedKeys.contains(38)) { //up
		    background.setPosy(background.getPosy() - 1); 
		    player.setPosy(player.getPosy() - 5);   
        }
        if(pressedKeys.contains(40)) { //down
            background.setPosy(background.getPosy() + 1); 
            player.setPosy(player.getPosy() + 5); 
        }
        if(pressedKeys.contains(37)) { //left
              background.setPosx(background.getPosx() - 1); 
              player.setPosx(player.getPosx() - 5); 
              
        }
        if(pressedKeys.contains(39)) { //right
              background.setPosx(background.getPosx() + 1); 
              player.setPosx(player.getPosx() + 5); 
        }
        if(player != null) player.update(pressedKeys);
		if(background != null) background.update(pressedKeys);
	}
	
	/**
	 * Engine automatically invokes draw() every frame as well. If we want to make sure player gets drawn to
	 * the screen, we need to make sure to override this method and call player's draw method.
	 * */
	@Override
	public void draw(Graphics g){
		super.draw(g);
		
	}

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls update() and draw() every frame
	 * */
	public static void main(String[] args) {
		Prototype game = new Prototype();
		game.start();

	}
}
