package Lab_8_2;


import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color class
import BasicIO.*;

/** This class is a program to show color represented by RGB value.
  * 
  * @author  D. Hughes
  * 
  * @version  1.0 (June 2013)
  * 
  * new concepts: Picture constructor, function method                           */

public class ColorPicker {
    
    
    private static final int R = 64;   // red component
    private static final int G = 128;  // green component
    private static final int B = 192;  // blue component
    
    private BasicForm display;
    
    /** The constructor creates and displays the color swatch.                   */
    
    public ColorPicker ( ) {
        
        Picture        pic;     // picture to be displayed
        Color          c;       // color for swatch
        int button;
        int r;
        int g;
        int b;
        
        display = new BasicForm("View", "Save", "Quit");
        pic = new Picture(0,0);
        
        buildForm();
        
        
        
        for ( ; ; ){
          
           button = display.accept();
           if(button == 2) break;
           
           if(button == 0) {
            //view is clicked
             r = display.readInt("r");
             g = display.readInt("g");
             b = display.readInt("b");
             
             c = new Color(r, g, b);
             pic = makeSwatch(200, 200, c);
             display.placePicture("pic", pic);
           }
           if(button == 1) {
            pic.save();
           }
           else if(button ==2) {
            //quit is clicked
             break;
           }
        }
        display.close();
        
    };  // constructor
    
    
    private void buildForm(){
      
      display.setTitle("Lab 10 Basic Form");
      display.addCanvas("pic", "Color", 200, 200, 25,10);
      display.addTextField("r", "Red", 3, 10, 240);
      display.addTextField("g", "Green", 3, 90, 240);
      display.addTextField("b", "Blue", 3, 170, 240);
      
    }
    
    /** This method creates a color swatch of specified size and color.
      * 
      * @param  width   width of color swatch
      * @param  height  height of color swatch
      * @param  aColor  color for swatch
      * 
      * @return  Picture  the color swatch as a Picture                          */
    
    private Picture makeSwatch ( int width, int height, Color aColor ) {
        
        Picture  result;  // picture for swatch
        Pixel    p;       // a pixel of the picture
        
        result = new Picture(width,height);
        while ( result.hasNext() ) {
            p = result.next();
            p.setColor(aColor);
        };
        return result;
        
    };  // makeSwatch
    
    
    public static void main ( String[] args )
                            { ColorPicker c = new ColorPicker(); } ;
    
}  // ColorPicker