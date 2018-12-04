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

import spaceinvaders.domain.Invader; 
import spaceinvaders.domain.Direction;

/**
 *
 * @author julia
 */
public class InvaderTest {
    Invader invader;
    
    public InvaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        invader = new Invader(20);
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
    public void getXWorks(){
        assertEquals(20, invader.getX());
    }
    @Test
    public void setXWorks(){
        invader.setX(30);
        assertEquals(30, invader.getX());
    }
    @Test
    public void setYWorks(){
        invader.setY(20);
        assertEquals(20, invader.getY());
    }
    @Test
    public void setDirectionWorks(){
        invader.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, invader.getDirection());
    }
    @Test
    public void movingRight(){
        invader.setX(250);
        invader.setDirection(Direction.RIGHT);
        invader.move();
        assertEquals(260, invader.getX());
    }
    @Test
    public void movingRightNotOverEdge(){
        invader.setX(355);
        invader.setDirection(Direction.RIGHT);
        invader.move();
        assertEquals(360, invader.getX());
    }
    @Test
    public void movingRightChangeDirection(){
        invader.setX(355);
        invader.setDirection(Direction.RIGHT);
        invader.move();
        assertEquals(Direction.LEFT, invader.getDirection());
    }
    @Test
    public void movingRightChangeY(){
        invader.setX(355);
        invader.setDirection(Direction.RIGHT);
        invader.move();
        assertEquals(45, invader.getY());
    }
    @Test
    public void movingLeft(){
        invader.setX(250);
        invader.setDirection(Direction.LEFT);
        invader.move();
        assertEquals(240, invader.getX());
    }
    @Test
    public void movingLefttNotOverEdge(){
        invader.setX(25);
        invader.setDirection(Direction.LEFT);
        invader.move();
        assertEquals(20, invader.getX());
    }
    @Test
    public void movingLeftChangeDirection(){
        invader.setX(25);
        invader.setDirection(Direction.LEFT);
        invader.move();
        assertEquals(Direction.RIGHT, invader.getDirection());
    }
    @Test
    public void movingLeftChangeY(){
        invader.setX(25);
        invader.setDirection(Direction.LEFT);
        invader.move();
        assertEquals(45, invader.getY());
    }
}
