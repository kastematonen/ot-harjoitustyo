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
import java.util.*;
import java.sql.*;
import spaceinvaders.domain.*;
import spaceinvaders.database.*;
import spaceinvaders.dao.*;

public class PlayerDao implements Dao<Player, Integer> {
    private Database database;
    
    public PlayerDao(Database database) {
        this.database = database;
    }
    
    @Override
    public Player findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Player WHERE id = ?");
        stmt.setInt(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Player a = new Player();
        a.setId(rs.getInt("id"));
        a.setName(rs.getString("name"));

        stmt.close();
        rs.close();

        conn.close();

        return a;
    }
    
    @Override
    public List<Player> findAll() throws SQLException {
        List<Player> players;
        try (Connection connection = database.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Player");
            ResultSet rs = stmt.executeQuery();
            players = new ArrayList<>();
            while (rs.next()) {
                Player a = new Player();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
 
                players.add(a);
            }
            stmt.close();
            rs.close();
        }
 
        return players;
    }
    
    @Override
    public Player save(Player object) throws SQLException {
        if (object.getId() == -1) {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Player"
                + " (name)"
                + " VALUES (?)");
            stmt.setString(1, object.getName());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return object;
        } else {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Player SET "
                + " name = ? WHERE id = ?");
            stmt.setString(1, object.getName());
            stmt.setInt(2, object.getId());
 
            stmt.executeUpdate();
 
            stmt.close();
            conn.close();
 
            return object;
        }
    }
}
