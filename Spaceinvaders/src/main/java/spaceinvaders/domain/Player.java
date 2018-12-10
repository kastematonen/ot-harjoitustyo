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
public class Player {
    private int id;
    private int x;
    private int y;
    private Direction direction;
    private int speed;
    private String name;
    
    public Player() {
        this.x = 195;
        this.y = 350;
        this.direction = Direction.STILL;
        this.speed = 10;
        this.name = "";
        this.id = -1;
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
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void move() {
        int newX = this.x;
        
        if (this.direction == Direction.STILL) {
            return;
        } else if (this.direction == Direction.RIGHT) {
            newX += this.speed;
            //ei pääse reunan yli
            if (newX > 360) {
                newX = 360;
            }
            this.x = newX;
        } else {
            newX -= this.speed;
            //ei pääse reunan yli
            if (newX < 20) {
                newX = 20;
            }
            this.x = newX;
        }
    }
}
