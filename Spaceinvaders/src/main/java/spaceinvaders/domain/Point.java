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
public class Point {
    Integer id;
    private int points;
    private Player player;
    
    public Point() {
        this.points = 0;
        this.id = -1;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public void add(int points) {
        this.points += points;
    }
    public Player getPlayer() {
        return this.getPlayer();
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
