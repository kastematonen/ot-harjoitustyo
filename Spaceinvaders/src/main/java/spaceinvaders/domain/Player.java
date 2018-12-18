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
 * Luokka kuvaa pelin pelaajan hahmoa.
 */
public class Player extends GameComponent {
    
    public Player() {
        super.setX(195);
        super.setY(350);
        super.setDirection(Direction.STILL);
        super.setSpeed(10);
    }
    /**
    * Metodi liikuttaa pelaajaa pelaajan suunnan mukaisesti niin, että pelaaja
    * ei kuitenkaan liiku yli pelialueen.
    */
    public void move() {
        int newX = super.getX();
        
        if (super.getDirection() == Direction.STILL) {
            return;
        } else if (super.getDirection() == Direction.RIGHT) {
            newX += super.getSpeed();
            //ei pääse reunan yli
            if (newX > 360) {
                newX = 360;
            }
            super.setX(newX);
        } else {
            newX -= super.getSpeed();
            //ei pääse reunan yli
            if (newX < 20) {
                newX = 20;
            }
            super.setX(newX);
        }
    }
}
