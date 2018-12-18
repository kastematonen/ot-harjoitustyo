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

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import spaceinvaders.domain.*;

public class FilePointDao implements Dao {
    private List<Point> points;
    private String file;
    
    public FilePointDao(String file)  throws Exception {
        points = new ArrayList<>();
        this.file = file;
        
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int part0 = Integer.parseInt(parts[0]);
                Point p = new Point(part0, parts[1]);
                points.add(p);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Point point : points) {
                writer.write(point.getPoints() + ";" + point.getPlayer() + "\n");
            }
        }
    }
    
    @Override
    public List<Point> getAll() {
        return points;
    }
    
    @Override
    public Point create(Point point) throws Exception {
        points.add(point);
        save();
        return point;
    }
    public void clearFile() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            writer.write("");
        } 
    }
}
