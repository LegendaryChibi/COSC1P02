package Assign_4;


import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants


/**
 * This is a simple class that will reduce the pixels in an image to one of four possibilities
 * in each color channel.
 * 
 * @author     Joshua Varghese
 * @course     COSC 1P02
 * @assignment #4
 * @student Id 7123870
 * @version    1.0
 * @since      Nov 11th, 2021
 */

public class Quantization {
  //global/instance variables
  //comment the purpose of each variable you have here
  private PictureDisplayer display; //the displayer
  
  /*
   * Constructor of the class that initializes the global variables.
   */
    public Quantization ( ) {
      
      Picture thePic;
      display = new PictureDisplayer();
      thePic = new Picture();
      display.placePicture(thePic);
      display.waitForUser();
      QuantizationFilter(thePic); //Change the picture to the Quantization version.
      display.close(); //Close the display
        
    }; // constructor
    
    /*
     * Method that loops through each pixel in the image and changes them.
     * 
     */
    private void QuantizationFilter(Picture pic) {//1 parameter, no return type
      //variables
      Pixel x;
      int r;
      int g;
      int b;
      int NewRed;
      int NewGreen;
      int NewBlue;
      
      //loop through each pixel
      while(pic.hasNext()){
        //Define colors
        x = pic.next();
        r = x.getRed();
        g = x.getGreen();
        b = x.getBlue();
        //Call the QuantizationCalculation method to calculate what each color channel should be changed to
        NewRed = QuantizationCalculation(r);
        NewGreen = QuantizationCalculation(g);
        NewBlue = QuantizationCalculation(b);
        
        //Apply new values to color channels
        x.setRed(NewRed);
        x.setGreen(NewGreen);
        x.setBlue(NewBlue);
        
      }
      
    }
    
    private int QuantizationCalculation(int color) {//1 parameter, returns int
      
      //Return a new number based on the range of the number provided from the parameter
        if (0 <= color & color <= 64) {
          return 0;
        }
        else if(64 < color & color <= 128) {
          return 85;
        }
        else if (128 < color & color <= 192) {
         return 170;
        }
        else {
          return 255;
        }
        
      }


    public static void main ( String[] args ) { Quantization q = new Quantization(); };
    
    
} // Quantization
