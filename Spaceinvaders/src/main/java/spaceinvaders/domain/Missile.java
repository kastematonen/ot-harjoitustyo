/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.domain;

/**
 *
 * @author julia
 */

public class Missile {
    private int x;
    private int y;
    private int speed;
    //false=ei laukaistu, true = laukaistu
    private boolean state;
    private Direction direction;
    
    public Missile() {
        this.x = 195;
        this.y = 350;
        this.speed = 25;
        this.state = false;
        this.direction = Direction.STILL;
    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean getState() {
        return this.state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public Direction getDirection() {
        return this.direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void move() {
        if (!this.state) {
            return;
        }
        this.y -= this.speed;
        if (this.y < 10) {
            this.x = 195;
            this.y = 350;
            this.setState(false);
        }
    }
}
