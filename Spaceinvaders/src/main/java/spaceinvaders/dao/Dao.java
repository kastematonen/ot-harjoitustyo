/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.dao;

/**
 *
 * @author julia
 */
import java.sql.*;
import java.util.*;
import spaceinvaders.domain.*;
/**
 * Luokka on tallentamisessa käytettävä rajapinta.
 */
public interface Dao {
    /**
    * Metodi tallentaa Point-olion tiedot listaan ja tiedostoon.
    * 
    * @param   point   tallennettava piste-olio
    * 
    * @return tallennettava piste
    */
    Point create(Point point) throws Exception;
    /**
    * Metodi palauttaa tiedostoon tallennetut tiedot.
    * 
    * @return lista kaikista pisteolioista
    */
    List<Point> getAll();
}
