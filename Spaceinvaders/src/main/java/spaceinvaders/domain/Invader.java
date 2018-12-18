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
 * Luokka kuvaa pelin yhtä vastustajaa.
 */
public class Invader extends GameComponent {
    
    public Invader(int x) {
        super.setX(x);
        super.setY(20);
        super.setDirection(Direction.RIGHT);
        super.setSpeed(10);
    }
    /**
    * Vastustaja liikkuu siihen suuntaan, johon se osoittaa ja osuessaan reunaan 
    * se vaihtaa suuntaa ja liikkuu pykälän alaspäin.
    */
    public void move() {
        int newX = super.getX();
        if (super.getDirection() == Direction.RIGHT) {
            newX += super.getSpeed();
            if (newX > 360) {
                newX = 360;
                this.setDirection(Direction.LEFT);
                this.setY(super.getY() + 25);
            }
        } else if (super.getDirection() == Direction.LEFT) {
            newX -= super.getSpeed();
            if (newX < 20) {
                newX = 20;
                this.setDirection(Direction.RIGHT);
                this.setY(super.getY() + 25);
            }
        }
        this.setX(newX);
        this.setSpeed(super.getSpeed() + 0.001 * super.getSpeed());
    }
    
}
