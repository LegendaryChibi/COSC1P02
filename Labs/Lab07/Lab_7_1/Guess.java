package Lab_7_1;


import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class ...
  *
  * @author <your name>
  * @version 1.0 (<date>)                                                        */

public class Guess {
    
    
    // instance variables
    private ASCIIPrompter prompt;
    private ASCIIDisplayer display;
    private ASCIIDataFile invData;
    private ReportPrinter report;
    
    /** This constructor ...                                                     */
    
    public Guess ( ) {

        // local variables
//        int random;
//        int guess;
//        int guessnum;
//        
//        display = new ASCIIDisplayer();
//        prompt = new ASCIIPrompter();
//        guessnum = (int) (0);
//        random = (int) (random() * 100 + 1);
//        // statements
//        
//        display.writeLine("Lab 16 week 7 first exercise");
//        
//      
//        guess = 0;
//        
//        while(guess != random) {
//          prompt.setLabel("Guess");
//          guess = prompt.readInt();
//          display.writeInt(guess);
//          guessnum += 1;
//          
//         
//         
//          if(guess==random) {
//            display.writeLine("is the right answer!");
//            break;
//          }
//          if(guess > random) {
//           display.writeLine("High");
//            
//          }
//          else{
//            display.writeLine("Low");
//          }
//        }
//        display.newLine();
//        display.writeLine("Total Step(s):"+ guessnum);
//        
//        
//        display.close();
        
      ///////////////////////////////////////////////////////////////////////////////////
      
      invData = new ASCIIDataFile();
      report = new ReportPrinter();
      
      String itemNumber;
      int reorder;
      int quant;
      
      report.addField("itemNum", "My Item Name", 8);
      report.addField("reorder", "Reorder Pt", 6);
      report.addField("quant", "Quant", 4);
      
      
      for ( ; ; ) {
        itemNumber = invData.readString();
        if(invData.isEOF()) {
         break; 
        }
        reorder = invData.readInt();
        quant = invData.readInt();
        report.setTitle("Our Lab 16");
        
        if(quant <= reorder) {
          report.writeString("itemNum", itemNumber);
          report.writeInt("reorder", reorder);
          report.writeInt("quant", quant);
        }
      }
      
      invData.close();
      report.close();
      
      
      
    }; // constructor
    
    
    // methods

    
    
    public static void main ( String[] args ) { Guess g = new Guess(); };
    
    
} // <className>
