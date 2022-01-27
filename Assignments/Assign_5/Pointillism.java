package Assign_5;


import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants

/**
 * This is a simple class that will create a cubistical version of a given image.
 * 
 * @author     Joshua Varghese
 * @course     COSC 1P02
 * @assignment #5
 * @student Id 7123870
 * @version    1.0
 * @since      Nov 25th, 2021
 */


public class Pointillism {
    //global/instance variables
    
    private PictureDisplayer  display;  // display for picture
    
    
    /** The constructor creates a cubistical version of the given image.                                         */
    
    public Pointillism ( ) {
        
        Picture        pic;     // picture to be displayed
        
        pic = new Picture();                 //Creates a new picture.
        display = new PictureDisplayer(pic); //Displays the chosen picture.
        display.close();                     //Closes the picture displayer.
        pic = cubistical(pic,100000);        //Passes the picture and an int into the cunistical function.
        display = new PictureDisplayer(pic); //Displays the new picture.
        display.close();                     //Closes the picture displayer.  
        
    };  // constructor

    
    private Picture cubistical (Picture pic, int repeat) {//2 parameters, returns Picture
      
      Picture result; //Define a new picture
      Color   aColor; //Define a color variable
      
      int w = pic.getWidth(); //Gets the width of the passed image.
      int h = pic.getHeight(); //Gets the height of the passed image.
      
      result = new Picture(w,h); //Creates a new picture with the given width and height of the passed image.
      
      //Loop for the number of repeats that is passed in the parameter
      for ( int i=0 ; i < repeat ; i++ ) {
        //Generate a random set of x and y coordinates to target a random pixel on the image
        int randomW = (int) (random() * (w - 6) + 3);
        int randomH = (int) (random() * (h - 6) + 3);
        
        //Get the color of the random pixel selected
        aColor = pic.getPixel(randomW,randomH).getColor();
        
        //Nested loop and start at -3 and loop up to 3  in each loop as to remain in the bounds of the image
        for(int p=-3; p <= 3; p++) {
          for(int q=-3; q <= 3; q++) {
            //Get the pixel on the new result image scaled up to 7x7 by adding the coordinates with the number of the iteration in the loop
            //Set the color of the new pixel with the color in the previous image
            result.getPixel(randomW + p,randomH + q).setColor(aColor);
          }
        }

        }
      return result; //Return the picture
      
    }

        public static void main ( String[] args ) { Pointillism p = new Pointillism(); } ;
    
    
}//Pointllism