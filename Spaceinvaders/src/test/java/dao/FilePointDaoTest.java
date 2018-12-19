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
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File file;  
    FilePointDao dao;
    
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
        file = testFolder.newFile("testfile_points.txt");  
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("20;first player\n");
        }
        try (FileWriter file = new FileWriter(file.getAbsolutePath())) {
            file.write("testertester;Teppo Testaaja\n");
        }
        dao = new FilePointDao("testfile_points.txt");
    }
    
    @After
    public void tearDown() {
        file.delete();
    }

    @Test
    public void pointsReadFromFile() {
        List<Point> points = dao.getAll();
        assertEquals(1, points.size());
    }
    @Test
    public void pointsReadCorrectlyFromFile() {
        List<Point> points = dao.getAll();
        assertEquals(20, points.get(0).getPoints());
    }
    @Test
    public void nameReadCorrectlyFromFile() {
        List<Point> points = dao.getAll();
        assertEquals("firs player", points.get(0).getPlayer());
    }
}
