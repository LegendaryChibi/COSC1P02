package Lab_5_1;


import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class ...
  *
  * @author Joshua Varghese
  * @version 1.0 (October 22, 2021)                                                        */

public class Sunset {
  
  
  private PictureDisplayer display;
    
  
  
    public Sunset ( ) {
      
      Picture thePic;
      Picture thePic2;
      display = new PictureDisplayer();
      thePic = new Picture();
      thePic2 = new Picture();
      display.placePicture(thePic);
      display.placePicture(thePic2);
      display.waitForUser();
      //makeSunset(thePic);
      //makeBright(thePic);
      GreenScreen(thePic, thePic2);
      display.close();
        
    }; // constructor
    
    
    private void makeSunset(Picture pic) {
      Pixel x;
      int g;
      int b;
      while(pic.hasNext()){
        x = pic.next();
        g = x.getGreen();
        b = x.getBlue();
        x.setGreen((int) (g * 0.70));
        x.setBlue((int) (b * 0.70));
        
      }
            
    }
    
    private void makeBright(Picture pic) {
      Pixel x;
      int r;
      int g;
      int b;
      while(pic.hasNext()){
        x = pic.next();
        r = x.getRed();
        g = x.getGreen();
        b = x.getBlue();
        
        int RedVal = clip(r * 2);
        int GreenVal = clip(g * 2);
        int BlueVal = clip(b * 2);
        
        
        x.setRed((int) (RedVal));
        x.setGreen((int) (GreenVal));
        x.setBlue((int) (BlueVal));
        
      }
            
    }
    
    private int clip(int val) {
      if(val > 255){
        return 255;
      }
      else{
        return val;
        
      }
            
    }
    
    private void GreenScreen(Picture pic1, Picture pic2) {
      
      Pixel back;
      Pixel front;
      int r;
      int g;
      int b;
      Color color;
      
      while(pic1.hasNext()){
        back = pic1.next();
        front = pic2.next();
        
        if(front.getDistance(GREEN) < 200) {
          
          color = back.getColor();
          front.setColor(color);
          
        }
        
      
      }
            
    }


    
    
    public static void main ( String[] args ) { Sunset s = new Sunset(); };
    
    
} // <className>
