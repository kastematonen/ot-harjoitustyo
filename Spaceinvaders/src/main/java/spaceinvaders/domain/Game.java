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
import java.util.ArrayList;
import java.util.Random;

public class Game {
    //loppu
    //päivitä
        //player.liiku
        //invaser.liiku
        //ammus.liiku
        //osuuko ammus invaderiin
            //iuusi invader
    //uusi invader
    //osuuko ammus invaderiin
    
    private boolean gameOver;
    private Player player;
    private ArrayList<Invader> invaders;
    private Random random;
    private Missile missile;
    
    public Game(){
        this.gameOver=false;
        this.player= new Player();
        this.invaders=new ArrayList<>();
        this.makeInvaders(10);
        this.random= new Random();
        this.missile=new Missile();
    }
    
    public boolean getGameOver(){
        return this.gameOver;
    }
    public void setGameOver(boolean over){
        this.gameOver=over;
    }
    public Player getPlayer(){
        return this.player;
    }
    public void setPlayer(Player player){
        this.player=player;
    }
    public ArrayList getInvaders(){
        return this.invaders;
    }
    public void setInvaders(ArrayList invaders){
        this.invaders=invaders;
    }
    public void makeInvaders(int howMany){
        Random rand = new Random();
        for(int i=1; i<= howMany;i++){
            int xForInvader = rand.nextInt(340);
            xForInvader+=20;
            Invader invader = new Invader(xForInvader);
            this.invaders.add(invader);
        }
    }
    public Missile getMissile(){
        return this.missile;
    }
    public void setMissile(Missile missile){
        this.missile=missile;
    }
    public void launchMissile(){
        this.missile.setState(true);
        this.missile.setX(this.player.getX());
    }
    public void update(){
        if(this.gameOver){
            return;
        }
        this.player.move();
        for(int i=0;i<this.invaders.size();i++){
            this.invaders.get(i).move();
        }
        this.missile.move();
    }
}
