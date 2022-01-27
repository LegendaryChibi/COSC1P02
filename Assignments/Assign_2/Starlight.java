package Assign_2;

import Media.*;                  // for Turtle and TurtleDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants

/**
 * This is a simple class that will show how to insert the class header (this block)
 * and comment the methods in the class.
 * 
 * @author     Joshua Varghese
 * @course     COSC 1P02
 * @assignment #2
 * @student Id 7123870
 * @version    1.0
 * @since      Oct 24th, 2020
 */
public class Starlight{
  //global/instance variables
  //comment the purpose of each variable you have here
  private TurtleDisplayer display;//the canvas
  private Turtle yertle;// the brush
  
  /*
   * Constructor of the class that initializes the global variables.
   */
  public Starlight(){
    
    yertle = new Turtle(Turtle.FAST);
    display = new TurtleDisplayer(yertle);
    yertle.moveTo(-110, 110);
    drawSky();
    display.close();
  }
  
  /*
   * Method that draws a raypoint on screen.
   * 
   */
  private void drawRay(){//no parameters, no return type
    //local variables
    int rayPoint = 30;
    yertle.penDown();
    //draws a ray point with four sides and with a raypoint of 30
    yertle.left(PI/4*3);
    yertle.forward(sqrt(pow(rayPoint/2, 2) + pow(rayPoint/2, 2)));
    yertle.left(PI - (PI/4 + PI/3));
    yertle.forward(30);
    yertle.left(PI - PI/3);
    yertle.forward(30);
    yertle.left(PI - (PI/4 + PI/3));
    yertle.forward(sqrt(pow(rayPoint/2, 2) + pow(rayPoint/2, 2)));
    yertle.right(PI/4);
    yertle.penUp();
  }
  
  /*
   * Method that draws a star with ray points ranging from 4 to 7.
   */
  private void drawStar(){//no parameters, no return type
    //local variables
    double randnum = (int) (random() * (7 - 4 + 1) + 4);
    //loop to draw a star made of a certain number of rays from 4 to 7.
    for(int i = 1; i <= randnum; i++){
      drawRay();
      yertle.right(PI/(randnum/2.0));
      
    }
  }
  
  /*
   * Method that relocates turtle to equidistant points and draw 4x4 stars.
   */
  private void drawSky(){//no parameters, no return type
    //loop to draw each row 4 times and have each row spaced from one another.
    for(int i = 1; i <= 4; i++){
      drawRow();
      yertle.right(PI/2);
      yertle.forward(70);
      yertle.left(PI/2);
    }
    
  }
 
  
  /*
   * Method that draws a row of 4 stars using the drawStar() method.
   */
  private void drawRow(){//no parameters, no return type
    //loop to draw 4 rays in a single row and have them equally space from one another.
    for(int j = 1; j <= 4; j++){
      drawStar();
      yertle.forward(70);
    }
    //resets the turtle to it's original position before it drew a row.
    yertle.backward(280);
  }
  
  public static void main(String[] args){
    Starlight s = new Starlight();
  }
}