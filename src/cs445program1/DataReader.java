/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445program1;
import java.util.ArrayList;
import java.io.*;

/**
 * This class reads data from a txt file and stores primitive shapes
 * in fields.  I am not sure if shapes are going to be polymorphic.
 * 
 * @author Shun Lu
 */
public class DataReader {
    private ArrayList<Shape> list;

    /**
     * This constructor constructs data read from txt
     */
    public DataReader(String filePath) {
        list = new ArrayList<>(); 
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line; 
            while ( (line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].equals("l")) {
                    Point p1 = new Point(data[1].split(","));
                    Point p2 = new Point(data[2].split(","));
                    list.add(new Line(p1, p2));
                }
                // TODO: condition for ellipse and circle
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * METHOD: getData
     * PURPOSE: get list from DataReader object
     */
    public ArrayList<Shape> getData() {
        return list;
    }
}
