/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445program1;

import static org.lwjgl.opengl.GL11.*;

/**
 * Circle Class: Has center and radius that define a circle
 * @author Shun Lu
 */
public class Circle implements Shape{
    private Point center;
    private float radius;

    /**
     * Constructor that one can pass in center and radius to create a circle
     */
    public Circle(Point center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * METHOD: draw
     * PURPOSE: circle algorithm that draws points on projected matrix
     */
    @Override
    public void draw() {
        glColor3f(0.0f, 0.0f, 255.0f);
        float theta = 0;
        float x, y;
        while (theta >= 0 && theta <= 2 * Math.PI) {
            x = (float) (radius * Math.cos(theta));
            y = (float) (radius * Math.sin(theta));
            glBegin(GL_POINTS);
                glVertex2f(center.x + x,center.y + y);
            glEnd();
            theta += (Math.PI / (radius * 180.0f));
        }
    }

    /**
     * METHOD: toString
     * PURPOSE: print some useful infommation about a circle
     */
    @Override
    public String toString() {
        return "center: " + this.center + "; radius: " + this.radius;
    }
}
