package Assign_4;


import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants


/**
 * This is a simple class that isolates each pixel's colour to only its brightest channel.
 * 
 * @author     Joshua Varghese
 * @course     COSC 1P02
 * @assignment #4
 * @student Id 7123870
 * @version    1.0
 * @since      Nov 11th, 2021
 */                                                   

public class ChannelSelection {
  //global/instance variables
  //comment the purpose of each variable you have here
  private PictureDisplayer display; //the displayer
  
  /*
   * Constructor of the class that initializes the global variables.
   */
    public ChannelSelection ( ) {
      
      Picture thePic;
      display = new PictureDisplayer();
      thePic = new Picture();
      display.placePicture(thePic);
      display.waitForUser();
      ChannelIsolater(thePic); //Change the picture to isolated channels version.
      display.close(); //Close the display
        
    }; // constructor
    
    /*
     * Method that loops through each pixel in the image and changes them so only the brightest of each color channel appears.
     * 
     */
    private void ChannelIsolater(Picture pic) {//1 parameter, no return type
      //Define variables
      Pixel x;
      int r;
      int g;
      int b;
      int average;
      
      //Loop through each pixel in the image
      while(pic.hasNext()){
        //Define colors
        x = pic.next();
        r = x.getRed();
        g = x.getGreen();
        b = x.getBlue();
        //Calculate the average number between each color channel in a pixel.
        average = (r + g + b)/3;
        
        //Based on which color channel is the highest, primarily change the color of the pixel to the calculated average and set all other channels to 0.
        if (r >= g & r >= b) {
          x.setRed((int) (average));
          x.setGreen((int) (0));
          x.setBlue((int) (0));
        }
        else if(g  >= r & g >= b) {
          x.setRed((int) (0));
          x.setGreen((int) (average));
          x.setBlue((int) (0));
        }
        else if (b >= r & b >= g) {
          x.setRed((int) (0));
          x.setGreen((int) (0));
          x.setBlue((int) (average));
        }
        else {
          //If none of the above conditions are met, change the pixel to black.
          x.setRed((int) (0));
          x.setGreen((int) (0));
          x.setBlue((int) (0));
        }
        
      }
      
    }
    
    
    public static void main ( String[] args ) { ChannelSelection c = new ChannelSelection(); };
    
    
} // ChannelSelection
