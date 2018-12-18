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
//    private int x;
//    private int y;
//    private Direction direction;
//    private double speed;
    
    public Invader(int x) {
        //this.x = x;
        super.setX(x);
        //this.y = 20;
        super.setY(20);
        //this.direction = Direction.RIGHT;
        super.setDirection(Direction.RIGHT);
        //this.speed = 10;
        super.setSpeed(10);
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
//    public double getSpeed() {
//        return this.speed;
//    }
//    public void setSpeed(double speed) {
//        this.speed = speed;
//    }
//    public Direction getDirection() {
//        return this.direction;
//    }
//    public void setDirection(Direction direction) {
//        this.direction = direction;
//    }
    /**
    * Vastustaja liikkuu siihen suuntaan, johon se osoittaa ja osuessaan reunaan 
    * se vaihtaa suuntaa ja liikkuu pykälän alaspäin.
    */
    public void move() {
//        int newX = this.x;
//        if (this.direction == Direction.RIGHT) {
//            newX += this.speed;
//            if (newX > 360) {
//                newX = 360;
//                this.setDirection(Direction.LEFT);
//                this.setY(this.y + 25);
//            }
//            this.setX(newX);
//        } else if (this.direction == Direction.LEFT) {
//            newX -= this.speed;
//            if (newX < 20) {
//                newX = 20;
//                this.setDirection(Direction.RIGHT);
//                this.setY(this.y + 25);
//            }
//            this.setX(newX);
//        }
//        double newSpeed = this.speed + 0.001 * this.speed;
//        this.setSpeed(newSpeed);
        int newX = super.getX();
        if (super.getDirection() == Direction.RIGHT) {
            newX += super.getSpeed();
            if (newX > 360) {
                newX = 360;
                this.setDirection(Direction.LEFT);
                this.setY(super.getY() + 25);
            }
            //this.setX(newX);
        } else if (super.getDirection() == Direction.LEFT) {
            newX -= super.getSpeed();
            if (newX < 20) {
                newX = 20;
                this.setDirection(Direction.RIGHT);
                this.setY(super.getY() + 25);
            }
            //this.setX(newX);
        }
        this.setX(newX);
        //double newSpeed = super.getSpeed() + 0.001 * super.getSpeed();
        this.setSpeed(super.getSpeed() + 0.001 * super.getSpeed());
    }
    
}
