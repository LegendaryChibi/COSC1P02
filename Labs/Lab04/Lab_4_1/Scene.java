package Lab_4_1;


import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class ...
  *
  * @author Joshua Varghese
  *
  * @version 1.0 (<date>)                                                        */

public class Scene {
  private TurtleDisplayer  display;  // displayer to draw ion
  private Turtle           yertle;   // turtle to draw with
  
  // instance variables
  
  
  /** This constructor ...                                                     */
  
  public Scene ( ) {
    display = new TurtleDisplayer();
    yertle = new Turtle(FAST);
    display.placeTurtle(yertle);
    yertle.moveTo(0, -40);
    yertle.setPenColor(RED);
    drawHouse(0.2);
    yertle.moveTo(0, -40);
    yertle.backward(120);
    yertle.setPenColor(GREEN);
    drawHouse(1);
    yertle.moveTo(75, 100);
    drawStarburst(30);
    display.close();
    
  }; // constructor
  
  
  
  /** This method ...                                                          */
  
  private void drawTriangle ( double side ) {
    yertle.penDown();
    for (int i = 1; i <= 3; i++) {
      yertle.forward(side);
      yertle.left(2*PI/3);
    }
    yertle.penUp();
    
  }; // <methodName>
  
  private void drawRectangle ( double width, double height ) {
    yertle.penDown();
    yertle.forward(width);
    yertle.left(PI/2);
    yertle.forward(height);
    yertle.left(PI/2);
    yertle.forward(width);
    yertle.left(PI/2);
    yertle.forward(height);
    yertle.left(PI/2);
    yertle.penUp();
    
    
  }; // <methodName>
  
  private void drawHouse (double size) {
    drawRectangle(100 * size, 80 * size);
    yertle.left(PI/2);
    yertle.forward(80* size);
    yertle.right(PI/2);
    yertle.backward(10* size);
    drawTriangle(120 * size);
    
  }; // <methodName>
  
  private void drawStarburst ( double radius ) {;
    for ( int i=1 ; i<=10 ; i++ ) {
      yertle.setPenColor(ORANGE);
      yertle.forward(2*radius/3);
      yertle.penDown();
      yertle.forward(radius/3);
      yertle.penUp();
      yertle.backward(2*radius/3 + radius/3);      // back to center
      yertle.right(PI/5);
    };
  };
    
    
    public static void main ( String[] args ) { Scene s = new Scene(); };
    
    
    
  }  // <className>
