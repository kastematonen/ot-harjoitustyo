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
    private int points;
    private String player;
    
    public Point(int points, String player) {
        this.points = points;
        this.player = player;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public String getPlayer() {
        return this.player;
    }
    
    public void setPlayer(String player) {
        this.player = player;
    }
}
