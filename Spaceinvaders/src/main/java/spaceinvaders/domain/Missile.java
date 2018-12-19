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
    //false=not fired, true = fired
    private boolean state;
    
    public Missile() {
        super.setX(195);
        super.setY(350);
        super.setSpeed(25);
        this.state = false;
        super.setDirection(Direction.STILL);
    }
    public boolean getState() {
        return this.state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    /**
    * Jos ammus on laukaistu, liikkuu se vakionopeudella ylöspäin, kunnes
    * se osuu yläreunaan - tällöin se palaa takaisin valmiuteen alkuasemaansa.
    */
    public void move() {
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
