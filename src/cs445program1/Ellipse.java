/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
}