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
import java.util.Collections;

import spaceinvaders.database.*;
import spaceinvaders.dao.*;

import java.util.*;
/**
 * Luokka vastaa pelin logiikasta kuten pelin elementeistä ja niiden päivityksestä.
 */
public class Game {
    
    private boolean gameOver;
    private Player player;
    private ArrayList<Invader> invaders;
    private Random random;
    private Missile missile;
    private int points;
    
    //private Database db;
    
    private TreeMap<Integer, String> topPoints;
    
    private boolean gameOn;
    
    public Game() {
        this.gameOver = false;
        this.player = new Player();
        this.invaders = new ArrayList<>();
        this.makeInvaders(10);
        this.random = new Random();
        this.missile = new Missile();
        this.points = 0;
        this.gameOn = false;
        //miksi tämä antaa erroria, sanoo ettei database-tiedostoa löydy
        //this.db = new Database("jdbc:sqlite:database.db");
        
        this.topPoints = new TreeMap<Integer, String>(Collections.reverseOrder());
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
    public TreeMap<Integer, String> getTopPoints() {
        return this.topPoints;
    }
    public void setTopPoints(TreeMap<Integer, String> topPoints) {
        this.topPoints = topPoints;
    }
    /**
    * Metodi luo tarvittavan määrän vastustajia niin, että jokainen niistä asettuu sattumanvaraiseen kohtaan x-koordinatiltaan.
    * 
    * @param   howMany   luotavien vastustajien lukumäärä
    */
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
    /**
    * Metodi laukaisee ammuksen eli se muuttaa ammuksen tilaa ja asettaa sen samaan kohtaan, jossa pelaaja sijaitsee.
    * 
    */
    public void launchMissile() {
        this.missile.setState(true);
        this.missile.setX(this.player.getX());
    }
    /**
    * Jos peli on käynnissä (eli mikään vastustaja ei ole liian alhaalla), metodi 
    * päivittää pelin liikuttamalla pelaajaa, vastustajia ja ammusta sekä tarkastamalla, törmääkö ammus vastustajaan.
    */
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
    /**
    * Metodi tarkistaa, onko peli päättynyt eli onko mikään vastustajista liian alhaalla.
    * 
    * @param   invaders   lista vastustajia
    */
    public void isGameOver(ArrayList<Invader> invaders) {
        for (int i = 0; i < invaders.size(); i++) {
            if (invaders.get(i).getY() >= this.player.getY()) {
                this.setGameOver(true);
            }
        }
    }
    /**
    * Metodi tarkistaa, törmääkö vastustaja ammuksen kanssa, jos ammus on laukaistu.
    * 
    * @param   first   vastustaja
    * 
    * @param   second   ammus
    * 
    * @return törmäävätkö vastustaja ja ammus
    */
    public boolean isCollision(Invader first, Missile second) {
        if (Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2)) < 20) {
            return true;
        } else {
            return false;
        }
    }
    public int getPoints() {
        return this.points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    /**
    * Jos jokin vastustaja ja laukaistu ammus törmävät, kasvavat pisteet, ammus 
    * palautuu alkutilaansa ja vastustaja palautuu takaisin alkuun.
    * 
    * @param   missile   ammus
    * 
    * @param   invaders   lista vastustajia
    * 
    */
    public void handleCollision(Missile missile, ArrayList<Invader> invaders) {
        Random rand = new Random();
        if (missile.getState()) {
            for (int i = 0; i < invaders.size(); i++) {
                if (this.isCollision(invaders.get(i), missile)) {
                    
                    this.setPoints(this.points + 10);
                    
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
    /**
    * Metodi aloittaa pelin alusta palauttamalla sen muuttujat alkulukemiinsa. 
    * 
    */
    public void newGame() {
        this.gameOver = false;
        this.player = new Player();
        this.invaders = new ArrayList<>();
        this.makeInvaders(10);
        this.random = new Random();
        this.missile = new Missile();
        this.points = 0;
        this.gameOn = false;
    }
    /**
    * Jos pisteet ovat tarpeeksi korkeat, ne tallennetaan huippupistelistalle. 
    * 
    * @param   points   pisteet
    * 
    * @param   name   pelaajan nimimerkki
    * 
    */
    public void addPointsToList(int points, String name) {
//        if (this.topPoints.size() > 9) {
//            
//            int lastKey = this.topPoints.lastKey();
//            String lastvalue = this.topPoints.get(lastKey);
//            String[] splitted = lastvalue.split("\t");
//            int lastPoints = Integer.parseInt(splitted[0]);
//            if (points > lastPoints) {
//                this.topPoints.remove(lastKey);
//                
//                String pointsToSave = Integer.toString(points) + "\t" + name;
//                this.topPoints.put(this.topPoints.size(), pointsToSave);
//            }
//        } else {
//            String pointsToSave = Integer.toString(points) + "\t" + name;
//            this.topPoints.put(this.topPoints.size(), pointsToSave);
//        }
        
        if (this.topPoints.size() > 9) {
            int lastKey = this.topPoints.lastKey();
            if (points > lastKey) {
                this.topPoints.remove(lastKey);
                this.topPoints.put(points, name);
            }
        } else {
            this.topPoints.put(points, name);
        }
    }
    
}
