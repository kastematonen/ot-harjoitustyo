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

import spaceinvaders.domain.Missile; 
import spaceinvaders.domain.Direction;

/**
 *
 * @author julia
 */
public class MissileTest {
    Missile missile;
    
    public MissileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        missile = new Missile();
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
        int x = missile.getX();
        assertEquals(195, x);
    }
    @Test
    public void constructorSetsYRight(){
        int y = missile.getY();
        assertEquals(350, y);
    }
    @Test
    public void constructorSetsDirectionRight(){
        Direction direction = missile.getDirection();
        assertEquals(Direction.STILL, direction);
    }
    @Test
    public void constructorSetsSpeedRight(){
        int speed = missile.getSpeed();
        assertEquals(25, speed);
    }
    @Test
    public void constructorSetsStateRight(){
        boolean state = missile.getState();
        assertEquals(false, state);
    }
    @Test
    public void setXWorks(){
        missile.setX(20);
        assertEquals(20, missile.getX());
    }
    @Test
    public void setYWorks(){
        missile.setY(20);
        assertEquals(20, missile.getY());
    }
    @Test
    public void setSpeedWorks(){
        missile.setSpeed(20);
        assertEquals(20, missile.getSpeed());
    }
    @Test
    public void setDirectionWorks(){
        missile.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, missile.getDirection());
    }
    @Test
    public void setStateWorks(){
        missile.setState(true);
        assertEquals(true, missile.getState());
    }
    @Test
    public void noMovementWhenStateIsFalse(){
        missile.setState(false);
        missile.move();
        assertEquals(350, missile.getY());
    }
}
