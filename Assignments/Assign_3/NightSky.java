package Assign_3;

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
 * @since      Oct 29th, 2021
 */
public class NightSky{
  //global/instance variables
  //comment the purpose of each variable you have here
  private TurtleDisplayer display;//the canvas
  private Turtle yertle;// the brush
  
  /*
   * Constructor of the class that initializes the global variables.
   */
  public NightSky(){
    
    yertle = new Turtle(Turtle.FAST);
    display = new TurtleDisplayer(yertle);
    BlackSky(); //Draw the sky black.
    drawSky(); //Fill the sky with stars.
    display.close(); //Close the display.
  }
  
  /*
   * Method that draws a raypoint on screen.
   * 
   */
  private void drawRay(double rayPoint){//1 parameter, no return type
    yertle.penDown();
    //draws a ray point with four sides and with a given raypoint size in the parameter.
    yertle.left(PI/4*3);
    yertle.forward(hypotenuse(rayPoint/2));
    yertle.left(PI - (PI/4 + PI/3));
    yertle.forward(rayPoint);
    yertle.left(PI - PI/3);
    yertle.forward(rayPoint);
    yertle.left(PI - (PI/4 + PI/3));
    yertle.forward(hypotenuse(rayPoint/2));
    yertle.right(PI/4);
    yertle.penUp();
  }
  
  /*
   * Method that draws a star with ray points ranging from 4 to 7.
   */
  private void drawStar(int x, int y, int size){//Three parameters, no return type
    //local variables
    double randnum = (int) (random() * (7 - 4 + 1) + 4);
    //set pen color to random.
    yertle.setPenColor(new Color((int)(Math.random()*16777216)));
    // Move to location using the first two parameters.
    yertle.moveTo(x, y);
    //loop to draw a star made of a certain number of rays from 4 to 7.
    for(int i = 1; i <= randnum; i++){
      //Input the size provided in the parameter into the argument for the drawRay() method and draw a star.
      drawRay(size);
      yertle.right(PI/(randnum/2));
      
    }
  }
  
  /*
   * Method that relocates turtle to equidistant points and draw 4x4 stars.
   */
  private void drawSky(){//no parameters, no return type
    //Draws multiple stars to fill the canvas with each with parameters for location and size.
    drawStar(-110, 110, 2);
    drawStar(-40, 110, 22);
    drawStar(30, 110, 16);
    drawStar(100, 110, 10);
    drawStar(-110, 40, 18);
    drawStar(-40, 40, 24);
    drawStar(30, 40, 20);
    drawStar(100, 40, 10);
    drawStar(-110, -30, 28);
    drawStar(-40, -30, 12);
    drawStar(30, -30, 4);
    drawStar(100, -30, 26);
    drawStar(-110, -100, 12);
    drawStar(-40, -100, 14);
    drawStar(30, -100, 8);
    drawStar(100, -100, 6);   
  }
  
  private void BlackSky(){//no parameters, no return type
    //Enlarges the pen to make the whole canvas black.
    yertle.setPenWidth(600);
    yertle.penDown();
    yertle.forward(1);
    yertle.penUp();
    yertle.backward(1);
    yertle.setPenWidth(1);
  }
  
    private double hypotenuse(double x){//one parameter and a double return type.
     //Function to calculate the hypotenuse given one value.
    double y = (double) sqrt(pow(x, 2) + pow(x, 2));
    return y;
  }
  
  public static void main(String[] args){
    NightSky s = new NightSky();
  }
}