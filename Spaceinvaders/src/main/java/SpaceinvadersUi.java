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

public class SpaceinvadersUi extends Application{
    @Override
    public void start(Stage ikkuna) {
        //etusivu
        Label tervetuloteksti = new Label("Space Invaders");
        Button alkunakymastaOhjeisiin = new Button("Ohjeisiin");
        BorderPane etusivu = new BorderPane();
        etusivu.setCenter(tervetuloteksti);
        etusivu.setBottom(alkunakymastaOhjeisiin);
        etusivu.setPrefSize(300, 200);
        etusivu.setPadding(new Insets(20, 20, 20, 20));
        Scene alkunakyma= new Scene(etusivu);
        
        //ohjenakyma
        Label ohjeteksti = new Label("Space Invaders -pelin ohjeet");
        Button ohjeistaAlkunakymaan = new Button("Etusivulle");
        BorderPane ohjesivu = new BorderPane();
        ohjesivu.setTop(ohjeteksti);
        ohjesivu.setBottom(ohjeistaAlkunakymaan);
        ohjesivu.setPrefSize(300, 200);
        ohjesivu.setPadding(new Insets(20, 20, 20, 20));
        Scene ohjenakyma= new Scene(ohjesivu);
        
        alkunakymastaOhjeisiin.setOnAction((event) -> {
            ikkuna.setScene(ohjenakyma);
        });
        
        ohjeistaAlkunakymaan.setOnAction((event) -> {
            ikkuna.setScene(alkunakyma);
        });
        
        ikkuna.setScene(alkunakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SpaceinvadersUi.class);
    }
}
