package domain;

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

    @Test
    public void constructorSetsStateRight(){
        boolean state = missile.getState();
        assertEquals(false, state);
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
    @Test
    public void movementWhenStateIsTrue(){
        missile.setState(true);
        missile.move();
        assertEquals(325, missile.getY());
    }
    @Test
    public void movemenNotOverEdge(){
        missile.setState(true);
        missile.setY(5);
        missile.move();
        assertEquals(350, missile.getY());
    }
}
