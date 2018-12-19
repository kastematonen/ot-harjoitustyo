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
public class PointTest {
    Point point;
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        point = new Point(0, "player");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void setPlayerWorks(){
        point.setPlayer("player1");
        assertEquals("player1", point.getPlayer());
    }
    @Test
    public void setPointsWorks(){
        point.setPoints(10);
        assertEquals(10, point.getPoints());
    }
}
