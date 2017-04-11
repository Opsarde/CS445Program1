/*************************************************************
 *     file: DataReader.java
 *     author: Shun Lu
 *     class: CS 445 - Computer Graphics
 * 
 *     assignment: program 1
 *     last modified: 4/10/2017
 * 
 *     purpose: This program reads coordinates.txt and draw line,
 *     circle, and ellipse on a window using OpenGL
 * 
 *************************************************************/
package cs445program1;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

/**
 * This class reads data from a txt file and stores primitive shapes
 * in fields.  I am not sure if shapes are going to be polymorphic.
 * 
 * @author Shun Lu
 */
public class DataReader {
    //private ArrayList<Shape> list;
    private List<Shape> list;

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
                else if (data[0].equals("c")) {
                    Point center = new Point(data[1].split(","));
                    float radius = Float.parseFloat(data[2]);
                    list.add(new Circle(center, radius));
                }
                else if (data[0].equals("e")) {
                    Point center = new Point(data[1].split(","));
                    String[] r = data[2].split(",");
                    float rx = Float.parseFloat(r[0]);
                    float ry = Float.parseFloat(r[1]);
                    list.add(new Ellipse(center, rx, ry));
                }
                else 
                    System.out.println("Provided shape is not provided. PASS.");
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * METHOD: getData
     * PURPOSE: get list from DataReader object
     */
    public List<Shape> getData() {
        return list;
    }
}
