package Assign_1;

import Media.*;                  // for Turtle and TurtleDisplayer
import java.awt.*;               // for Color objects, constructor and methods
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** Wreath
  *
  * @author:         Joshua Varghese
  * @student number: 7123870                                              */

public class Wreath {
  private TurtleDisplayer  display;  // displayer to draw ion
  private Turtle           yertle;   // turtle to draw with

  
  public Wreath ( ) {
    // setting up the display and drawing the Wreath
    display = new TurtleDisplayer();
    yertle = new Turtle();
    yertle.setSpeed(0);
    display.placeTurtle(yertle);
    drawWreath();
    display.close();
    
  };                                                   
  
  private void drawWreath ( ) {
    // Creating a loop to draw 20 heptagrams in a wreath
    for (int i=1; i<=20; i++) {
      yertle.forward(80);
      drawHeptagram();
      yertle.penUp();
      yertle.moveTo(0,0);  //Resetting the position of the turtle
      yertle.right(PI/10); //angling the turtle to draw the next heptagram
    };
  };
  
  private void drawHeptagram ( ) {
    //Drawing a singular heptagram
    for ( int i=1 ; i<=7 ; i++ ) {
      yertle.penDown();
      yertle.forward(50);
      yertle.right(4 * PI/7);
    };
  };
  
  public static void main ( String[] args ) { Wreath h = new Wreath(); };
  
  
}