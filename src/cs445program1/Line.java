/*************************************************************
 *     file: Line.java
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

import static org.lwjgl.opengl.GL11.*;


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
     * METHOD: draw
     * PURPOSE: draw a line by using the line algorithm
     */
    @Override
    public void draw() {
        glColor3f(255.0f, 0.0f, 0.0f);
        float dx = Math.abs(p2.x - p1.x);
        float dy = Math.abs(p2.y - p1.y);
        float incrementRight = 2 * dy;
        float incrementUpRight = 2 * (dy - dx);
        float d = 2 * dy - dx;
        float x = p1.x; 
        float y = p1.y;
        glBegin(GL_POINTS);
        glVertex2f(x, y);
        if (dx == 0) {
            drawVertical();
        }
        else {
            while ((x < p2.x && p2.x - p1.x >= 0) ||
                    (x > p2.x && p2.x - p1.x < 0)) {
               if (d > 0) {
                   d += incrementUpRight;
                   if (p2.x - p1.x >= 0) ++x; else --x;
                   if (p2.y - p1.y >= 0) ++y; else --y;
               } 
               else {
                   d += incrementRight;
                   if (p2.x - p1.x >= 0) ++x; else --x;
               }
               glVertex2f(x, y);
            }
            glEnd();
        }
    }

    /**
     * METHOD: toString
     * PURPOSE: print some useful information about a line
     */
    @Override
    public String toString() {
        return "p1: " + p1.toString() + "; p2: " + p2.toString();
    }

    /**
     * METHOD: drawVertical
     * PURPOSE: draw a vertical line
     */
    private void drawVertical() {
        float begin, end; 
        if (p1.y <= p2.y) {
            begin = p1.y;
            end = p2.y;
        }
        else {
            begin = p2.y;
            end = p1.y;
        }
        glBegin(GL_POINTS);
        glVertex2f(p1.x, begin);
        while (begin < end) {
            ++begin;
            glVertex2f(p1.x, begin);
        }
        glEnd();
    }
}
