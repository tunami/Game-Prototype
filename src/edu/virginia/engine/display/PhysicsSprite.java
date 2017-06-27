package edu.virginia.engine.display;

import java.awt.Point;

public class PhysicsSprite extends AnimatedSprite{

    private double gravity;
    private double mass;
    private double velocity;
    private double acceleration;
    private boolean isJumping;
    private boolean isSticking;
    private Point xy;
    
    public Point getXy() {
        return xy;
    }
    public void setXy(Point xy) {
        this.xy = xy;
    }
    public boolean isSticking() {
        return isSticking;
    }
    public void setSticking(boolean isSticking) {
        this.isSticking = isSticking;
    }
    public boolean isJumping() {
        return isJumping;
    }
    public void setJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }
    public PhysicsSprite(String ID, String filename, int numFrames) {
        super(ID, filename, numFrames);
        gravity = 1;
        mass = 1;
        velocity = 0;
        acceleration = 0;
    }
    public PhysicsSprite(String ID, String filename) {
        super(ID, filename);
        gravity = 1;
        mass = 1;
        velocity = 0;
        acceleration = 0;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

}
