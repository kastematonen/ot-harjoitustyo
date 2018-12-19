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


import spaceinvaders.domain.*;
import spaceinvaders.dao.*;
import java.util.*;
/**
 *
 * @author julia
 */
public class GameTest {
    Game game;
    FilePointDao pointDao;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pointDao = null;
        try {
            pointDao = new FilePointDao("testPointFile");
            pointDao.clearFile();
        } catch (Exception e) {
        }
        game = new Game(pointDao);
    }
    
    @After
    public void tearDown() {
        try {
            pointDao.clearFile();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void constructorSetsGemeOverRight(){
        boolean gameOver = game.getGameOver();
        assertEquals(false, gameOver);
    }
    @Test
    public void constructorSetsPointsRight(){
        int points = game.getPoints();
        assertEquals(0, points);
    }
    @Test
    public void constructorSetsGemeOnRight(){
        boolean gameOn = game.getGameOn();
        assertEquals(false, gameOn);
    }
    @Test
    public void setsGameOn(){
        game.setGameOn(true);
        assertEquals(true, game.getGameOn());
    }
    @Test
    public void setsGameOver(){
        game.setGameOver(true);
        assertEquals(true, game.getGameOver());
    }
    @Test
    public void setsPoints(){
        game.setPoints(20);
        assertEquals(20, game.getPoints());
    }
    @Test
    public void getPlayer(){
        Player player = game.getPlayer();
        assertEquals(195, player.getX());
    }
    @Test
    public void setPlayer(){
        Player player = new Player();
        player.setX(200);
        game.setPlayer(player);
        assertEquals(200, game.getPlayer().getX());
    }
    @Test
    public void getMissile(){
        Missile missile = game.getMissile();
        assertEquals(195, missile.getX());
    }
    @Test
    public void setMissile(){
        Missile missile = new Missile();
        missile.setX(200);
        game.setMissile(missile);
        assertEquals(200, game.getMissile().getX());
    }
    @Test
    public void getInvaders(){
        ArrayList<Invader> invaders = game.getInvaders();
        assertEquals(10, invaders.size());
    }
    @Test
    public void setInvaders(){
        ArrayList<Invader> invaders = new ArrayList<>();
        invaders.add(new Invader(20));
        game.setInvaders(invaders);
        assertEquals(1, game.getInvaders().size());
    }
    @Test
    public void getTopPointsEmpty(){
        TreeMap<Integer, String> topPoints  = game.getTopPoints();
        assertEquals(0, topPoints.size());
    }
    @Test
    public void setTopPoints(){
        TreeMap<Integer, String> topPoints  = new TreeMap<Integer, String>(Collections.reverseOrder());
        topPoints.put(40, "player");
        game.setTopPoints(topPoints);
        assertEquals(1, game.getTopPoints().size());
    }
    @Test
    public void launchMissileMissileStateCganges(){
        game.launchMissile();
        assertEquals(true, game.getMissile().getState());
    }
    @Test
    public void launchMissileMissileXCganges(){
        game.getPlayer().setX(150);
        game.launchMissile();
        assertEquals(150, game.getMissile().getX());
    }
    @Test
    public void newGame(){
        game.setPoints(400);
        game.newGame();
        assertEquals(0, game.getPoints());
    }
    @Test
    public void isGameOver(){
        ArrayList<Invader> invaders = game.getInvaders();
        invaders.get(0).setY(360);
        game.setInvaders(invaders);
        game.isGameOver(game.getInvaders());
        assertEquals(true, game.getGameOver());
    }

    @Test
    public void addPointsToListListWorks(){
        game.addPointsToList(5, "testPlayer");
        List<Point> allPoints = game.getAllPoints();
        Point first = allPoints.get(0);
        
        assertEquals("testPlayer", first.getPlayer());
    }
    @Test
    public void isCollisionTrueWhenIsCollision(){
        game.getMissile().setX(50);
        game.getMissile().setY(50);
        ArrayList<Invader> invaders = game.getInvaders();
        invaders.get(0).setX(50);
        invaders.get(0).setY(50);
        assertEquals(true, game.isCollision(invaders.get(0), game.getMissile()));
    }
    @Test
    public void isCollisionFalseWhenIsNotCollision(){
        game.getMissile().setX(50);
        game.getMissile().setY(50);
        ArrayList<Invader> invaders = game.getInvaders();
        invaders.get(0).setX(100);
        invaders.get(0).setY(50);
        assertEquals(false, game.isCollision(invaders.get(0), game.getMissile()));
    }
    @Test
    public void updateDoesNotUpdateIfGameOver(){
        game.getPlayer().setX(200);
        game.getPlayer().setDirection(Direction.RIGHT);
        game.setGameOver(true);
        game.update();
        assertEquals(200, game.getPlayer().getX());
    }
    @Test
    public void updatePlayerMovesIfGameNotOver(){
        game.getPlayer().setX(200);
        game.getPlayer().setDirection(Direction.RIGHT);
        game.setGameOver(false);
        game.update();
        assertEquals(210, game.getPlayer().getX());
    }
    @Test
    public void handleCollisionDoesNothingWhenMissileNotFired(){
        game.getMissile().setState(false);
        game.getMissile().setX(50);
        game.getMissile().setY(50);
        ArrayList<Invader> invaders = game.getInvaders();
        invaders.get(0).setX(50);
        invaders.get(0).setY(50);
        game.setInvaders(invaders);
        game.handleCollision(game.getMissile(), game.getInvaders());
        assertEquals(0, game.getPoints());
    }
    @Test
    public void handleCollisionAddsPointsWhenNeeded(){
        game.getMissile().setState(true);
        game.getMissile().setX(50);
        game.getMissile().setY(50);
        ArrayList<Invader> invaders = game.getInvaders();
        invaders.get(0).setX(50);
        invaders.get(0).setY(50);
        game.setInvaders(invaders);
        game.handleCollision(game.getMissile(), game.getInvaders());
        assertEquals(10, game.getPoints());
    }
    @Test
    public void getLast10PointsWorksWithLessThan10(){
        try {
            pointDao.create(new Point(20, "first"));
            pointDao.create(new Point(30, "second"));
            pointDao.create(new Point(40, "third"));
        } catch (Exception e) {
        }
        List<Point> points = game.getLast10Points();
        assertEquals(3, points.size());
    }
    @Test
    public void getLast10PointsWorksWithMoreThan10TakesLastOneIn(){
        try {
            pointDao.create(new Point(20, "one"));
            pointDao.create(new Point(30, "two"));
            pointDao.create(new Point(40, "three"));
            pointDao.create(new Point(50, "four"));
            pointDao.create(new Point(60, "five"));
            pointDao.create(new Point(70, "six"));
            pointDao.create(new Point(80, "seven"));
            pointDao.create(new Point(90, "eight"));
            pointDao.create(new Point(100, "nine"));
            pointDao.create(new Point(110, "ten"));
            pointDao.create(new Point(120, "eleven"));
        } catch (Exception e) {
        }
        List<Point> points = game.getLast10Points();
        assertEquals("eleven", points.get(9).getPlayer());
    }
    @Test
    public void getLast10PointsWorksWithMoreThan10DeletesFirstOne(){
        try {
            pointDao.create(new Point(20, "one"));
            pointDao.create(new Point(30, "two"));
            pointDao.create(new Point(40, "three"));
            pointDao.create(new Point(50, "four"));
            pointDao.create(new Point(60, "five"));
            pointDao.create(new Point(70, "six"));
            pointDao.create(new Point(80, "seven"));
            pointDao.create(new Point(90, "eight"));
            pointDao.create(new Point(100, "nine"));
            pointDao.create(new Point(110, "ten"));
            pointDao.create(new Point(120, "eleven"));
        } catch (Exception e) {
        }
        List<Point> points = game.getLast10Points();
        assertEquals("two", points.get(0).getPlayer());
    }
    @Test
    public void getBestPointsWorksWithPoints(){
        try {
            pointDao.create(new Point(20, "one"));
            pointDao.create(new Point(50, "two"));
            pointDao.create(new Point(30, "three"));
            
        } catch (Exception e) {
        }
        String points = game.getBestPoints();
        assertEquals("50" + "\t" + "two", points);
    }
    @Test
    public void getBestPointsWorksWithEmptyList(){
        String points = game.getBestPoints();
        assertEquals("", points);
    }
}
