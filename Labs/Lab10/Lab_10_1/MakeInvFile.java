package Lab_10_1;


import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class ...
  *
  * @author <your name>
  * @version 1.0 (<date>)                                                        */

public class MakeInvFile {
    
    public ASCIIDataFile InvData;
    public BinaryOutputFile newInvData;
    public ASCIIDisplayer display;
    
    public MakeInvFile(){
      InvData = new ASCIIDataFile();
      newInvData = new BinaryOutputFile();
      display = new ASCIIDisplayer();
      Item anItem;
      int numItem=0;
      
      for(; ;) {
       
        anItem = new Item(InvData);
        if(InvData.isEOF()) break;
        newInvData.writeObject(anItem);
        numItem++;
      
    }
    
      display.writeString("Number of items inserted: ");
      display.writeInt(numItem);
      display.close();
      newInvData.close();
  } // constructor
  
  
  // methods
  
  
  // For main classes only:
  public static void main ( String[] args ) { MakeInvFile m = new MakeInvFile(); };
  
  
} // <className>
