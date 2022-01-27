  package Lab_6_1;


import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class ...
  *
  * @author <your name>
  * @version 1.0 (<date>)                                                        */

public class Noisy {
    private Sound s;
    private SoundPlayer player;
    private PictureDisplayer display;
    
    private static final int FROM_X = 275;
    private static final int FROM_Y = 275;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    // instance variables
    
    
    /** This constructor ...                                                     */
    
    public Noisy ( ) {
      
      Sound s;
      Sound Exercise3;
      s = new Sound();
      
      player = new SoundPlayer();
      
      Exercise3 = repeat(s, 3);
      player.placeSound(Exercise3);
      Exercise3.save();
      player.close();
//      Picture pic;
//      pic = new Picture();
//      
//      display = new PictureDisplayer(pic);
//      display.close();
//      pic = crop(pic, FROM_X, FROM_Y, WIDTH, HEIGHT);
//      
//      display = new PictureDisplayer(pic);
//      display.close();
//      pic.save();

      
////////////////////////////////////////////////////////
//      Sound theSound;
//      theSound = new Sound();
//      
//      player = new SoundPlayer();
//      
//      player.placeSound(theSound);
//      
//      player.waitForUser();
//      
//      makeNoisy(theSound, 1000);
//      
//      player.close();
      
        
    }; // constructor
    
    
    // methods
    
    private void makeNoisy( Sound aSound, int nAmp){
     
      Sample s;
      int amp;
      int newAmp;
      
      while ( aSound.hasNext()) {
        s = aSound.next();
        amp = s.getAmp();
        s.setAmp(amp + (int)((2*nAmp+1)*random())-nAmp);
        s = aSound.next(); 
      }
      aSound.save();
    }

    
    private Picture crop ( Picture aPic, int x, int y,  int width, int height ) {
      Picture result = new Picture();
      Pixel p;
      Color c;
      for(int h = 0; h <height; h++){
        for(int j = 0; j < width; j++){ 
          p = aPic.getPixel(x+j, y+h); //275, 275
          c = p.getColor();
          result.getPixel(j,h).setColor(c);
        }
        
      }
      return result;
    }
   
    private Sound repeat ( Sound aSound, int nTimes ) {
      Sound tripled;
      Sample s;
      
      tripled = new Sound(aSound.getNumSamples() * 3, aSound);
      for(int i = 0; i < nTimes; i++) {
        for(int j = 0; j < aSound.getNumSamples(); j++) {
          s = aSound.getSample(j);
          tripled.next().setAmp(s.getAmp());
        }
      }
      return tripled;
    }
    
    
    
    public static void main ( String[] args ) { Noisy s = new Noisy(); };
    
    
} // <className>
