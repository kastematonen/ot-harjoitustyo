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
//    private int x;
//    private int y;
//    private Direction direction;
//    private double speed;
    //private String name;
    
    public Player() {
        //this.x = 195;
        super.setX(195);
        //this.y = 350;
        super.setY(350);
        //this.direction = Direction.STILL;
        super.setDirection(Direction.STILL);
        //this.speed = 10;
        super.setSpeed(10);
        //this.name = "";
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
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
    
    /**
    * Metodi liikuttaa pelaajaa pelaajan suunnan mukaisesti niin, että pelaaja
    * ei kuitenkaan liiku yli pelialueen.
    */
    public void move() {
//        int newX = this.x;
//        
//        if (this.direction == Direction.STILL) {
//            return;
//        } else if (this.direction == Direction.RIGHT) {
//            newX += this.speed;
//            //ei pääse reunan yli
//            if (newX > 360) {
//                newX = 360;
//            }
//            this.x = newX;
//        } else {
//            newX -= this.speed;
//            //ei pääse reunan yli
//            if (newX < 20) {
//                newX = 20;
//            }
//            this.x = newX;
//        }
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
