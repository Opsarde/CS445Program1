/*************************************************************
 *     file: Ellipse.java
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
 * Ellipse class: Has center, minor, and major axis that defines an ellipse
 * 
 * @author Shun Lu
 */
public class Ellipse implements Shape{

    private Point center;
    private float rx, ry;

    /**
     * Constructor that one can pass in center, rx, and ry to create an ellipse
     */
    public Ellipse(Point center, float rx, float ry) {
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }

    /**
     * METHOD: draw
     * PURPOSE: ellipse algorithm that draws points on projected matrix
     */
    @Override
    public void draw() {
        glColor3f(0.0f, 255.0f, 0.0f);
        float theta = 0;
        float x, y;
        while (theta >= 0 && theta <= 2 * Math.PI) {
            x = (float) (rx * Math.cos(theta));
            y = (float) (ry * Math.sin(theta));
            glBegin(GL_POINTS);
                glVertex2f(center.x + x,center.y + y);
            glEnd();
            theta += (Math.PI / ((rx + ry) * 180.0f));
        }
    }

    /**
     * METHOD: toString
     * PURPOSE: print some useful information about a ellipse
     */
    @Override
    public String toString() {
        return "center: " + this.center + "; rx: " + this.rx + ", ry: " + this.ry;
    }
}