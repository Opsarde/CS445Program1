/*************************************************************
 *     file: Main.java
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

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 *
 * @author Shun Lu
 */
public class Main {
    String filePath = "src/cs445program1/coordinates.txt";
    
    /**
     * METHOD: start
     * PURPOSE: method to start GL window and render
     */
    public void start() {
        try {
            createWindow();
            createKeyboard();
            initGL();
            render();
        } catch (Exception e) {
            // what is the error
            e.printStackTrace();
        }
    }
    
    /**
     * METHOD: createWindow
     * PURPOSE: method to create display object 
     */
    private void createWindow() throws Exception {
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(640, 480));
        Display.setTitle("Simple Graphic Rendering");
        Display.create();
    }
    
    /**
     * METHOD: createKeyboard
     * PURPOSE: method to create keyboard object 
     */
    private void createKeyboard() throws Exception {
        Keyboard.create();
    }

    /**
     * METHOD: initGL
     * PURPOSE: method that initialize projection matrix on window 
     */
    private void initGL() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 0, 480, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
    
    /**
     * METHOD: render
     * PURPOSE: render every frame until window is closed or press escape key
     */
    private void render() {
        DataReader reader = new DataReader(filePath);
        List<Shape> list = reader.getData();
        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            try {
                glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
                glLoadIdentity();
                for (Shape s: list) {
                    s.draw();
                }
                Display.update();
                Display.sync(60);
            } catch (Exception e) {
            }
        }
        Display.destroy();
        Keyboard.destroy();
    }
    
    /**
     * METHOD: main
     * PURPOSE: run the OpenGL program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main main = new Main();
        if (args.length == 1)
           main.filePath = args[0]; 
        main.start();
    }
}
