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

/**
 * Luokka kuvaa pelin pelaajan ammusta.
 */
public class Missile extends GameComponent {
//    private int x;
//    private int y;
//    private double speed;
    //false=ei laukaistu, true = laukaistu
    private boolean state;
//    private Direction direction;
    
    public Missile() {
        //this.x = 195;
        super.setX(195);
        //this.y = 350;
        super.setY(350);
        //this.speed = 25;
        super.setSpeed(25);
        this.state = false;
        //this.direction = Direction.STILL;
        super.setDirection(Direction.STILL);
    }
//    public int getX() {
//        return this.x;
//    }
//    public void setX(int x) {
//        this.x = x;
//    }
//    public int getY() {
//        return this.y;
//    }
//    public void setY(int y) {
//        this.y = y;
//    }
    public boolean getState() {
        return this.state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
//    public Direction getDirection() {
//        return this.direction;
//    }
//    public void setDirection(Direction direction) {
//        this.direction = direction;
//    }
//    public double getSpeed() {
//        return this.speed;
//    }
//    public void setSpeed(double speed) {
//        this.speed = speed;
//    }
    /**
    * Jos ammus on laukaistu, liikkuu se vakionopeudella ylöspäin, kunnes
    * se osuu yläreunaan - tällöin se palaa takaisin valmiuteen alkuasemaansa.
    */
    public void move() {
//        if (!this.state) {
//            return;
//        }
//        this.y -= this.speed;
//        if (this.y < 10) {
//            this.x = 195;
//            this.y = 350;
//            this.setState(false);
//        }
        if (!this.state) {
            return;
        }
        int speed = (int) super.getSpeed();
        super.setY(super.getY() - speed);
        if (super.getY() < 10) {
            super.setX(195);
            super.setY(350);
            this.setState(false);
        }
    }
}
