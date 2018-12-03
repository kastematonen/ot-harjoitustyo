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
import java.lang.Math;

import spaceinvaders.database.*;
import spaceinvaders.dao.*;

public class Game {
    
    private boolean gameOver;
    private Player player;
    private ArrayList<Invader> invaders;
    private Random random;
    private Missile missile;
    //private int points;
    private Point point;
    
    //private Database db;
    
    private boolean gameOn;
    
    public Game() {
        this.gameOver = false;
        this.player = new Player();
        this.invaders = new ArrayList<>();
        this.makeInvaders(10);
        this.random = new Random();
        this.missile = new Missile();
        //this.points = 0;
        this.gameOn = false;
        this.point = new Point();
        //this.db = new Database("jdbc:sqlite:database.db");
    }
    
    public boolean getGameOver() {
        return this.gameOver;
    }
    public void setGameOver(boolean over) {
        this.gameOver = over;
    }
    public Player getPlayer() {
        return this.player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public ArrayList getInvaders() {
        return this.invaders;
    }
    public void setInvaders(ArrayList invaders) {
        this.invaders = invaders;
    }
    public void makeInvaders(int howMany) {
        Random rand = new Random();
        for (int i = 1; i <= howMany; i++) {
            int xForInvader = rand.nextInt(340);
            xForInvader += 20;
            Invader invader = new Invader(xForInvader);
            this.invaders.add(invader);
        }
    }
    public Missile getMissile() {
        return this.missile;
    }
    public void setMissile(Missile missile) {
        this.missile = missile;
    }
    public void launchMissile() {
        this.missile.setState(true);
        this.missile.setX(this.player.getX());
    }
    public void update() {
        this.isGameOver(invaders);
        if (this.gameOver) {
            return;
        }
        this.player.move();
        for (int i = 0; i < this.invaders.size(); i++) {
            this.invaders.get(i).move();
        }
        this.missile.move();
        this.handleCollision(missile, invaders);
        
    }
    public void isGameOver(ArrayList<Invader> invaders) {
        for (int i = 0; i < invaders.size(); i++) {
            if (invaders.get(i).getY() >= this.player.getY()) {
                this.setGameOver(true);
            }
        }
    }
    public boolean isCollision(Invader first, Missile second) {
        if (Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2)) < 20) {
            return true;
        } else {
            return false;
        }
    }
//    public int getGPoints() {
//        return this.points;
//    }
//    public void setPoints(int points) {
//        this.points = points;
//    }
    public int getGPoints() {
        return this.point.getPoints();
    }
    public void setPoints(int points) {
        this.point.setPoints(points);
    }
    
    public void handleCollision(Missile missile, ArrayList<Invader> invaders) {
        Random rand = new Random();
        if (missile.getState()) {
            for (int i = 0; i < invaders.size(); i++) {
                if (this.isCollision(invaders.get(i), missile)) {
                    //this.setPoints(this.points + 10);
                    this.point.add(10);
                    
                    missile.setState(false);
                    missile.setX(195);
                    missile.setY(350);
                    invaders.remove(i);
                    int xForInvader = rand.nextInt(340);
                    xForInvader += 20;
                    Invader invader = new Invader(xForInvader);
                    this.invaders.add(invader);
                }
            }
        }
    }
    public void setGameOn(boolean on) {
        this.gameOn = on;
    }
    public boolean getGameOn() {
        return this.gameOn;
    }
    public void newGame() {
        this.gameOver = false;
        this.player = new Player();
        this.invaders = new ArrayList<>();
        this.makeInvaders(10);
        this.random = new Random();
        this.missile = new Missile();
        //this.points = 0;
        this.point = new Point();
        this.gameOn = false;
    }
}
