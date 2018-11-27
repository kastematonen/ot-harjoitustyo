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
}
