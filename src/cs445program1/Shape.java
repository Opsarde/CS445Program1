/*************************************************************
 *     file: Shape.java
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

/**
 * INTERFACE: Shape
 * PURPOSE: each shape should have a draw and toString method
 * 
 * @author Shun Lu
 */
public interface Shape {

    /**
     * PURPOSE: draw this shape on GL projection matrix
     */
    public void draw(); 

    /**
     * PURPOSE: return some information about this shape
     */
    public String toString();
}
