/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445program1;


/**
 * This class represents a line in a coordinate system
 *
 * @author shun7817
 */
public class Line implements Shape{
    private Point p1;
    private Point p2;
    
    /**
     * PURPOSE: Initialize Line object with given points
     */
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    /**
     * PURPOSE: draw a line by using the line algorithm
     */
    @Override
    public void draw() {
        float dx, dy;
        float incrementRight, incrementUpRight;
        float d;
        float x = p1.x; 
        float y = p1.y;

        while (x < p2.x) {
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
