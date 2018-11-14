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
public class Player {
    private int x;
    private int y;
    private Direction direction;
    private int speed;
    
    public Player (){
        //testaa sopivat arvot vielä -lähte alalaidan keskeltä
        this.x=195;
        this.y=350;
        this.direction= Direction.STILL;
        this.speed=10;
    }
    //liiku
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return this.y;
    }
    //tarvitaanko tätä
    public void setY(int y){
        this.y=y;
    }
    public Direction getDirection(){
        return this.direction;
    }
    public void setDirection(Direction direction){
        this.direction=direction;
    }
    public void move(){
        int newX=this.x;
        
        if(this.direction == Direction.STILL){
            return;
        } else if (this.direction == Direction.RIGHT){
            newX+=this.speed;
            //ei pääse reunan yli
            if(newX>380){
                newX=380;
            }
            this.x=newX;
        } else {
            newX-=this.speed;
            //ei pääse reunan yli
            if(newX<20){
                newX=20;
            }
            this.x=newX;
        }
    }
}
