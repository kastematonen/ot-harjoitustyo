/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.TemporaryFolder;
import java.io.File;
import java.io.FileWriter;
import org.junit.Rule;
import spaceinvaders.dao.*;
import spaceinvaders.domain.*;
import java.util.*;
/**
 *
 * @author julia
 */
public class FilePointDaoTest {
    FilePointDao pointDao;
    
    public FilePointDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        pointDao = null;
        try {
            pointDao = new FilePointDao("testDaoFile");
            pointDao.clearFile();
            pointDao.create(new Point(20, "first"));
        } catch (Exception e) {
        }
    }
    
    @After
    public void tearDown() {
        try {
            pointDao.clearFile();
        } catch (Exception e) {
        }
    }

    @Test
    public void pointsReadFromFile() {
        List<Point> points = pointDao.getAll();
        assertEquals(1, points.size());
    }
    @Test
    public void pointsReadCorrectlyFromFile() {
        List<Point> points = pointDao.getAll();
        assertEquals(20, points.get(0).getPoints());
    }
    @Test
    public void nameReadCorrectlyFromFile() {
        List<Point> points = pointDao.getAll();
        assertEquals("first", points.get(0).getPlayer());
    }
    @Test
    public void createdPointFound() {
        try {
            pointDao.create(new Point(30, "second"));
        } catch (Exception e) {
        }
        List<Point> points = pointDao.getAll();
        assertEquals("second", points.get(1).getPlayer());
    }
}
