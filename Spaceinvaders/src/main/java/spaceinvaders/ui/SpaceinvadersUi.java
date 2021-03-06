package spaceinvaders.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julia
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import java.util.*;
import java.sql.*;
import java.util.stream.Collectors;
import spaceinvaders.domain.*;
import spaceinvaders.dao.*;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Luokka vastaa sovelluksen käyttöliittymästä.
 */
public class SpaceinvadersUi extends Application{
    
    @Override
    public void start(Stage ikkuna) {
        //frontpage
        Label welcomeText = new Label("Space Invaders");
        Button beginningToDirections = new Button("Ohjeisiin");
        Button beginningToGame = new Button("Peliin");
        Button beginningToPoints = new Button("Huippupisteet");
        Button exit = new Button("Lopeta");
        BorderPane frontPage = new BorderPane();
        frontPage.setCenter(welcomeText);
        HBox frontpageMenu = new HBox();
        frontpageMenu.getChildren().add(beginningToDirections);
        frontpageMenu.getChildren().add(beginningToGame);
        frontpageMenu.getChildren().add(beginningToPoints);
        frontpageMenu.getChildren().add(exit);
        frontpageMenu.setSpacing(10);
        frontPage.setBottom(frontpageMenu);
        frontPage.setPrefSize(400, 400);
        frontPage.setPadding(new Insets(20, 20, 20, 20));
        Scene beginningPage= new Scene(frontPage);
        
        //directions page
        Label header = new Label("Space Invaders -pelin ohjeet");
        Label rule1 = new Label("Pelaajan hahmo on sininen ja se liikkuu nuolinäppäimistä sekä ampuu X-näppäimestä.");
        Label rule2 = new Label("Vastustajat ovat punaisia, ja ne pitää ampua ennen kuin ne ehtivät maahan asti. Osuessaan vastustajaan ammuksella pelaaja  saa pisteitä.");
        Label rule3 = new Label("Pisteesi näet pelin vasemmasta yläkulmasta, ja pelin voit keskeyttää keskeytä-nappulasta pelin aikana.");
        Label rule4 = new Label("Pelin jälkeen voit tallentaa pisteesi, ja niitä pääset tarkastelemaan Huippupisteet-valikosta.");
        rule1.setWrapText(true);
        rule2.setWrapText(true);
        rule3.setWrapText(true);
        rule4.setWrapText(true);
        VBox rules = new VBox();
        rules.setSpacing(5);
        rules.getChildren().add(rule1);
        rules.getChildren().add(rule2);
        rules.getChildren().add(rule3);
        rules.getChildren().add(rule4);
        Button directionsToBeginning = new Button("Etusivulle");
        BorderPane rulePage = new BorderPane();
        
        rulePage.setTop(header);
        rulePage.setCenter(rules);
        rulePage.setBottom(directionsToBeginning);
        rulePage.setPrefSize(400, 400);
        rulePage.setPadding(new Insets(20, 20, 20, 20));
        Scene ruleview= new Scene(rulePage);
        
        //for drawing game view
        Canvas canvas = new Canvas(400,380);
        GraphicsContext drawer = canvas.getGraphicsContext2D();
        
        //creating the game
        FilePointDao pointDao = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config.properties"));
            String pointsFile = properties.getProperty("pointFile");
            pointDao = new FilePointDao(pointsFile);
        } catch (Exception e) {
            try {
                pointDao = new FilePointDao("pointFile");
            } catch (Exception e2) {
            }
        }
        Game game = new Game(pointDao);
        
        //points view
        Label pointsHeader = new Label("Viimeisimmät pisteet:");
        Button pointsToBeginning = new Button("Etusivulle");
        BorderPane pointsPage = new BorderPane();
        pointsPage.setTop(pointsHeader);
        pointsPage.setBottom(pointsToBeginning);
        
        VBox pointTable = new VBox();
        pointTable.setSpacing(5);
        
        List<Point> pointsSaved = game.getLast10Points();
        if(pointsSaved.size() != 0) {
            for(int i = 0; i < pointsSaved.size();i ++) {
                pointTable.getChildren().add(new Label(pointsSaved.get(i).getPoints() + "\t" + pointsSaved.get(i).getPlayer()));
            }
        }
        
        Label bestPointsHeader = new Label("Parhaat pisteet:");
        VBox bestPointTable = new VBox();
        bestPointTable.setSpacing(5);
        bestPointTable.getChildren().add(bestPointsHeader);
        bestPointTable.getChildren().add(new Label(game.getBestPoints()));
        
        pointsPage.setCenter(pointTable);
        pointsPage.setRight(bestPointTable);

        pointsPage.setPrefSize(400, 400);
        pointsPage.setPadding(new Insets(20, 20, 20, 20));
        Scene pointsScene = new Scene(pointsPage);
        
        
        
        //game view
        BorderPane gamePage = new BorderPane();
        Label points = new Label("pisteet: " + game.getPoints());
        Button gameToBeginning = new Button("Keskeytä peli");
        HBox upButtons = new HBox();
        upButtons.getChildren().add(points);
        upButtons.getChildren().add(gameToBeginning);
        upButtons.setSpacing(20);
        gamePage.setTop(upButtons);
        gamePage.setCenter(canvas);
        gamePage.setPrefSize(400, 400);
        Scene gameview= new Scene(gamePage);
        
        //game end view
        BorderPane resultPage = new BorderPane();
        Label endPoints = new Label("pisteesi: " + game.getPoints());
        Button savePoints = new Button("Tallenna pisteet");
        TextField playerName = new TextField("Nimi");
        VBox endTexts = new VBox();
        endTexts.setSpacing(5);
        endTexts.getChildren().add(endPoints);
        endTexts.getChildren().add(playerName);
        endTexts.getChildren().add(savePoints);
        resultPage.setCenter(endTexts);
        resultPage.setPrefSize(400, 400);
        resultPage.setPadding(new Insets(20, 20, 20, 20));
        Scene resultview= new Scene(resultPage);
        
        //drawing
        new AnimationTimer(){
            private long previous;
            
            @Override
            public void handle(long now){
                if(now - previous < 1_000_000_000 / 30){
                    return;
                }
                previous = now;
                //black background
                drawer.setFill(Color.BLACK);
                drawer.fillRect(0, 0, 400, 380);
                //blue player
                drawer.setFill(Color.BLUE);
                drawer.fillOval(game.getPlayer().getX(), game.getPlayer().getY(), 20, 20);
                //red invader
                drawer.setFill(Color.RED);
                ArrayList<Invader> invaders= game.getInvaders();
                for(int i=0;i<invaders.size();i++){
                    drawer.fillOval(invaders.get(i).getX(), invaders.get(i).getY(), 25, 25);
                }
                //yellow missile
                if(game.getMissile().getState()==true){
                    drawer.setFill(Color.YELLOW);
                    drawer.fillOval(game.getMissile().getX(), game.getMissile().getY(), 15, 15);
                }
            }
        }.start();
        
        //updating game
        new AnimationTimer(){
            private long previous;
            @Override
            public void handle(long now){
                if(now - previous < 1_000_000_000 / 5){
                    return;
                }
                previous=now;
                if(game.getGameOn()){
                    game.update();
                    points.setText("pisteet: " + game.getPoints());
                }

                if(game.getGameOver()){
                    endPoints.setText("pistesi: " + game.getPoints());
                    ikkuna.setScene(resultview);
                }
            }
        }.start();
        
        //game view: keys
        gameview.setOnKeyPressed((event) -> {
            if(event.getCode().equals(KeyCode.RIGHT)){
                game.getPlayer().setDirection(Direction.RIGHT);
            } else if(event.getCode().equals(KeyCode.LEFT)){
                game.getPlayer().setDirection(Direction.LEFT);
            } else if(event.getCode().equals(KeyCode.X) && game.getMissile().getState()==false){
                game.launchMissile();
            }
        });
        
        gameview.setOnKeyReleased((event) -> {
            if(event.getCode().equals(KeyCode.RIGHT)){
                game.getPlayer().setDirection(Direction.STILL);
            } else if(event.getCode().equals(KeyCode.LEFT)){
                game.getPlayer().setDirection(Direction.STILL);
            } 
        });
        
        //buttons
        beginningToDirections.setOnAction((event) -> {
            ikkuna.setScene(ruleview);
        });
        
        beginningToGame.setOnAction((event) -> {
            ikkuna.setScene(gameview);
            //game does not run in background even if you do not go to the game straight away
            game.setGameOn(true);
        });
        
        directionsToBeginning.setOnAction((event) -> {
            ikkuna.setScene(beginningPage);
        });
        
        exit.setOnAction((event)->{
            ikkuna.close();
        });
        
        gameToBeginning.setOnAction((event) -> {
            game.newGame();
            ikkuna.setScene(beginningPage);
        });
        
        pointsToBeginning.setOnAction((event) -> {
            ikkuna.setScene(beginningPage);
        });
        
        beginningToPoints.setOnAction((event) -> {
            ikkuna.setScene(pointsScene);
        });
        
        savePoints.setOnAction((event) -> {
            
            String[] pieces = endPoints.getText().split(" ");
            int pointsToSave = Integer.parseInt(pieces[1]);
            String nameToSave = playerName.getText();
            game.addPointsToList(pointsToSave, nameToSave);
            
            pointTable.getChildren().clear();
            List<Point> lastPoints = game.getLast10Points();
            for(int i = 0; i < lastPoints.size();i ++) {
                pointTable.getChildren().add(new Label(lastPoints.get(i).getPoints() + "\t" + lastPoints.get(i).getPlayer()));
            }
            bestPointTable.getChildren().clear();
            bestPointTable.getChildren().add(bestPointsHeader);
            bestPointTable.getChildren().add(new Label(game.getBestPoints()));
            
            game.newGame();
            ikkuna.setScene(beginningPage);
            
        });
        
        ikkuna.setScene(beginningPage);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SpaceinvadersUi.class);
    }
}
