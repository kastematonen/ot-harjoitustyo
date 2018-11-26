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
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.ArrayList;

//tarvitaanko kaikkia näitä
import spaceinvaders.domain.Direction;
import spaceinvaders.domain.Game;
import spaceinvaders.domain.Invader;
import spaceinvaders.domain.Player;

public class SpaceinvadersUi extends Application{
    @Override
    public void start(Stage ikkuna) {
        //etusivu
        Label tervetuloteksti = new Label("Space Invaders");
        Button alkunakymastaOhjeisiin = new Button("Ohjeisiin");
        Button alkunakymastaPeliin = new Button("Peliin");
        Button exit = new Button("Lopeta");
        BorderPane etusivu = new BorderPane();
        etusivu.setCenter(tervetuloteksti);
        HBox etusivunPalkki = new HBox();
        etusivunPalkki.getChildren().add(alkunakymastaOhjeisiin);
        etusivunPalkki.getChildren().add(alkunakymastaPeliin);
        etusivunPalkki.getChildren().add(exit);
        etusivunPalkki.setSpacing(10);
        etusivu.setBottom(etusivunPalkki);
        etusivu.setPrefSize(400, 400);
        etusivu.setPadding(new Insets(20, 20, 20, 20));
        Scene alkunakyma= new Scene(etusivu);
        
        //ohjenakyma
        Label ohjeteksti = new Label("Space Invaders -pelin ohjeet");
        Button ohjeistaAlkunakymaan = new Button("Etusivulle");
        BorderPane ohjesivu = new BorderPane();
        ohjesivu.setTop(ohjeteksti);
        ohjesivu.setBottom(ohjeistaAlkunakymaan);
        ohjesivu.setPrefSize(400, 400);
        ohjesivu.setPadding(new Insets(20, 20, 20, 20));
        Scene ohjenakyma= new Scene(ohjesivu);
        
        //pelinäkymän piirtäminen
        
        Canvas canvas = new Canvas(400,380);
        GraphicsContext drawer = canvas.getGraphicsContext2D();
        
        Game game = new Game();
        
        //pelinäkymä
        BorderPane pelisivu = new BorderPane();
        Label pisteet = new Label("pisteet: " + game.getGPoints());
        pelisivu.setTop(pisteet);
        pelisivu.setCenter(canvas);
        pelisivu.setPrefSize(400, 400);
        Scene pelinakyma= new Scene(pelisivu);
        
        //drawing
        new AnimationTimer(){
            private long previous;
            
            @Override
            public void handle(long now){
                if(now - previous < 1_000_000_000 / 30){
                    return;
                }
                previous = now;
                //musta tausta
                drawer.setFill(Color.BLACK);
                drawer.fillRect(0, 0, 400, 380);
                //sininen pelaaja 
                //ympyränä
                drawer.setFill(Color.BLUE);
                drawer.fillOval(game.getPlayer().getX(), game.getPlayer().getY(), 20, 20);
                //kolmiona
//                double xpoints[]={game.getPlayer().getX()-10, game.getPlayer().getX()+10};
//                double ypoints[]={20};
//                int npoints = 3;
//                drawer.fillPolygon(xpoints, ypoints, npoints);
                //punainen valtaaja
                drawer.setFill(Color.RED);
                ArrayList<Invader> invaders= game.getInvaders();
                for(int i=0;i<invaders.size();i++){
                    drawer.fillOval(invaders.get(i).getX(), invaders.get(i).getY(), 25, 25);
                }
                //keltainen ammus
                if(game.getMissile().getState()==true){
                    drawer.setFill(Color.YELLOW);
                    drawer.fillOval(game.getMissile().getX(), game.getMissile().getY(), 15, 15);
                }
            }
        }.start();
        
//        Label pisteet = new Label("pisteet: " + game.getGPoints());
        
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
                    pisteet.setText("pisteet: " + game.getGPoints());
                }

                if(game.getGameOver()){
                    //vaihda pistenäkymä
                    ikkuna.setScene(alkunakyma);
                    //pelille uuden pelin aloittava metodi
                    game.newGame(); 
                }
            }
        }.start();
        
        //pelinäkymä: näppäimet
        pelinakyma.setOnKeyPressed((event) -> {
            if(event.getCode().equals(KeyCode.RIGHT)){
                game.getPlayer().setDirection(Direction.RIGHT);
            } else if(event.getCode().equals(KeyCode.LEFT)){
                game.getPlayer().setDirection(Direction.LEFT);
            } else if(event.getCode().equals(KeyCode.SPACE) && game.getMissile().getState()==false){
                game.launchMissile();
            }
        });
        
        pelinakyma.setOnKeyReleased((event) -> {
            if(event.getCode().equals(KeyCode.RIGHT)){
                game.getPlayer().setDirection(Direction.STILL);
            } else if(event.getCode().equals(KeyCode.LEFT)){
                game.getPlayer().setDirection(Direction.STILL);
            } 
        });
        
        //napit
        alkunakymastaOhjeisiin.setOnAction((event) -> {
            ikkuna.setScene(ohjenakyma);
        });
        
        alkunakymastaPeliin.setOnAction((event) -> {
            ikkuna.setScene(pelinakyma);
            //peli ei pyöri taustalla, vaikka sinne ei siirrytä heti alkunäkymästä
            game.setGameOn(true);
        });
        
        ohjeistaAlkunakymaan.setOnAction((event) -> {
            ikkuna.setScene(alkunakyma);
        });
        
        exit.setOnAction((event)->{
            ikkuna.close();
        });
        
        
        
        ikkuna.setScene(alkunakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SpaceinvadersUi.class);
    }
}
