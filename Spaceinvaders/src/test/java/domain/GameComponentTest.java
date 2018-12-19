/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.domain.*;
/**
 *
 * @author julia
 */
public class GameComponentTest {
    GameComponent component;
    
    public GameComponentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        component = new GameComponent();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void setXWorks(){
        component.setX(20);
        assertEquals(20, component.getX());
    }
    @Test
    public void setYWorks(){
        component.setY(20);
        assertEquals(20, component.getY());
    }
    @Test
    public void setSpeedWorks(){
        component.setSpeed(20);
        assertEquals(20, component.getSpeed(), 0.01);
    }
    @Test
    public void setDirectionWorks(){
        component.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, component.getDirection());
    }
}
