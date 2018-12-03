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
import spaceinvaders.domain.Player;
import spaceinvaders.domain.Point; 
import spaceinvaders.database.*;
import spaceinvaders.dao.*;

public class PointDao implements Dao<Point, Integer> {
    private Database database;
    private Dao<Player, Integer> playerDao;
    
    public PointDao(Database database, Dao<Player, Integer> playerDao) {
        this.database = database;
        this.playerDao = playerDao;
    }
    
    @Override
    public Point findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Points WHERE id = ?");
        stmt.setInt(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Point a = new Point();
        a.setId(rs.getInt("id"));
        Player player = this.playerDao.findOne(rs.getInt("player_id"));
        a.setPlayer(player);
        
        stmt.close();
        rs.close();

        conn.close();

        return a;
    }
    
    @Override
    public List<Point> findAll() throws SQLException {
        List<Point> points;
        try (Connection connection = database.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Points");
            ResultSet rs = stmt.executeQuery();
            points = new ArrayList<>();
            while (rs.next()) {
                Point a = new Point();
                a.setId(rs.getInt("id"));
                Player player = this.playerDao.findOne(rs.getInt("player_id"));
                a.setPlayer(player);
 
                points.add(a);
            }
            stmt.close();
            rs.close();
        }
 
        return points;
    }
    
    @Override
    public Point save(Point object) throws SQLException {
        if (object.getId() == -1) {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Points"
                + " (points)"
                + " (player_id)"
                + " VALUES (?, ?)");
            stmt.setInt(1, object.getPoints());
            stmt.setInt(1, object.getPlayer().getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return object;
        } else {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Points SET "
                + " points = ? WHERE id = ?");
            stmt.setInt(1, object.getPoints());
            stmt.setInt(2, object.getId());
 
            stmt.executeUpdate();
 
            stmt.close();
            conn.close();
 
            return object;
        }
    }
}
