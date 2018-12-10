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
public class Invader {
    private int x;
    private int y;
    private Direction direction;
    private int speed;
    
    public Invader(int x) {
        this.x = x;
        this.y = 20;
        this.direction = Direction.RIGHT;
        this.speed = 10;
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
    public Direction getDirection() {
        return this.direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    /**
    * Vastustaja liikkuu siihen suuntaan, johon se osoittaa ja osuessaan reunaan 
    * se vaihtaa suuntaa ja liikkuu pykälän alaspäin.
    */
    public void move() {
        int newX = this.x;
        if (this.direction == Direction.RIGHT) {
            newX += this.speed;
            if (newX > 360) {
                newX = 360;
                this.setDirection(Direction.LEFT);
                this.setY(this.y + 25);
            }
            this.setX(newX);
        } else if (this.direction == Direction.LEFT) {
            newX -= this.speed;
            if (newX < 20) {
                newX = 20;
                this.setDirection(Direction.RIGHT);
                this.setY(this.y + 25);
            }
            this.setX(newX);
        }
    }
    
}
