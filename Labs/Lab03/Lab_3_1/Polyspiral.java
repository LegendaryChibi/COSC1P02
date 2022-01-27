package Lab_3_1;


import Media.*;                  // for Turtle and TurtleDisplayer
import java.awt.*;               // for Color objects, constructor and methods
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class ...
  *
  * @author Joshua Varghese
  *
  * @version 1.0 (<date>)                                                        */

public class Polyspiral {
  private TurtleDisplayer  display;  // displayer to draw ion
  private Turtle           yertle;   // turtle to draw with
  
  
  // instance variables
  
  
  /** This constructor ...                                                     */
  
  public Polyspiral ( ) {
    
    display = new TurtleDisplayer();
    yertle = new Turtle(FAST);
    display.placeTurtle(yertle);
    drawFireworks();
    display.close();
    
    // statements including call of method
    
  }; // constructor
  
  
  
  /** This method ...                                                          */
  
  private void drawFireworks ( ) {
    int x = (int)(301*random())-150;
    int y = (int)(301*random())-150;
    for (int i=1; i <= 5; i++) {
      x = (int)(301*random())-150;
      y = (int)(301*random())-150;
      yertle.moveTo(x, y);
      drawStarburst();
    };
    
  }
  
  private void drawStarburst ( ) {
    int c = (int)(random()*16777216);
    for ( int i=1 ; i<=10 ; i++ ) {
      yertle.setPenColor(new Color(c));
      yertle.forward(20);
      yertle.penDown();
      yertle.forward(10);
      yertle.penUp();
      yertle.backward(30);      // back to center
      yertle.right(PI/5);
    };
    
    
    // local variables
    // statements
    
  }; // <methodName>
    
    
    
    public static void main ( String[] args ) { Polyspiral p = new Polyspiral(); };
    
    
    
  }  // <className>
