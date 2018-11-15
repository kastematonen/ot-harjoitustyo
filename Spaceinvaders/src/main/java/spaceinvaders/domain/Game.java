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
    private Invader invader;
    
    public Game(){
        this.gameOver=false;
        this.player= new Player();
        //arvo randomilla invaderin lähtösijainti?
        this.invader=new Invader(10);
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
    public Invader getInvader(){
        return this.invader;
    }
    public void setInvader(Invader invader){
        this.invader=invader;
    }
    public void update(){
        if(this.gameOver){
            return;
        }
        this.player.move();
        this.invader.move();
        
    }
}
