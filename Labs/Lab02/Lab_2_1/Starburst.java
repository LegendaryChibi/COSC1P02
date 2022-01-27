package Lab_2_1;


import Media.*;                  // for Turtle and TurtleDisplayer
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** COSC1P02 ...
  *
  * @author Joshua Varghese
  * 
  * @version 1.0 (9/24/2021)**/  
public class Starburst {
  private TurtleDisplayer display;
  private Turtle yertle;
  
  public Starburst() { 
    display = new TurtleDisplayer();
    yertle = new Turtle();
    display.placeTurtle(yertle);
    
    yertle.left(PI/2);
    yertle.forward(50);
    yertle.penDown();
    yertle.forward(10);
    yertle.backward(10);
    yertle.right(PI/2);
    
    for(int i = 1; i <= 5; i++){
      yertle.forward(10);
      yertle.right(PI/2);
      yertle.forward(10);
      yertle.left(PI / 2);
      
    }
    yertle.forward(10);
    yertle.backward(10);
    yertle.right(PI / 2);
    for(int i = 1; i <= 5; i++){
      yertle.forward(10);
      yertle.right(PI/2);
      yertle.forward(10);
      yertle.left(PI / 2);
      
    }
    yertle.forward(10);
    yertle.backward(10);
    yertle.right(PI/2);
    for(int i = 1; i <= 5; i++){
      yertle.forward(10);
      yertle.right(PI/2);
      yertle.forward(10);
      yertle.left(PI / 2);
      
    }
    yertle.forward(10);
    yertle.backward(10);
    yertle.right(PI/2);
    for(int i = 1; i <= 5; i++){
      yertle.forward(10);
      yertle.right(PI/2);
      yertle.forward(10);
      yertle.left(PI / 2);
      
    }
    display.close();
  }
  
  public static void main(String[] args) { 
    Starburst s = new Starburst();
    
  }
}
