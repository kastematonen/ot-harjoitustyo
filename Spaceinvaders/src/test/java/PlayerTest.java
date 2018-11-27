/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import spaceinvaders.domain.Player; 
import spaceinvaders.domain.Direction;

import spaceinvaders.domain.Missile; 

/**
 *
 * @author julia
 */
public class PlayerTest {
    Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player = new Player();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
    
    @Test
    public void constructorSetsXRight(){
        int x = player.getX();
        assertEquals(195, x);
    }
    @Test
    public void constructorSetsYRight(){
        int y = player.getY();
        assertEquals(350, y);
    }
    @Test
    public void constructorSetsDirectionRight(){
        Direction direction = player.getDirection();
        assertEquals(Direction.STILL, direction);
    }
    @Test
    public void constructorSetsSpeedRight(){
        int speed = player.getSpeed();
        assertEquals(10, speed);
    }
    @Test
    public void setXWorks(){
        player.setX(20);
        assertEquals(20, player.getX());
    }
    @Test
    public void setYWorks(){
        player.setY(20);
        assertEquals(20, player.getY());
    }
    @Test
    public void setSpeedWorks(){
        player.setSpeed(20);
        assertEquals(20, player.getSpeed());
    }
    @Test
    public void setDirectionWorks(){
        player.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, player.getDirection());
    }
    @Test
    public void notMovingWhenStill(){
        player.setDirection(Direction.STILL);
        player.move();
        assertEquals(195, player.getX());
    }
    @Test
    public void movingRight(){
        player.setDirection(Direction.RIGHT);
        player.move();
        assertEquals(205, player.getX());
    }
    @Test
    public void movingRightNotOverEdge(){
        player.setDirection(Direction.RIGHT);
        player.setX(355);
        player.move();
        assertEquals(360, player.getX());
    }
    @Test
    public void movingLeft(){
        player.setDirection(Direction.LEFT);
        player.move();
        assertEquals(185, player.getX());
    }
    @Test
    public void movingLeftNotOverEdge(){
        player.setDirection(Direction.LEFT);
        player.setX(15);
        player.move();
        assertEquals(20, player.getX());
    }
    
}
