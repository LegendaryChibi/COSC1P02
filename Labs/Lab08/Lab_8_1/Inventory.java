package Lab_8_1;


import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class is a program to do a simple inventory control producing a report.
  * 
  * @author David Hughes
  * 
  * @version 1.0 (Nov. 2013)                                                    */

public class Inventory {
    
    
    private ASCIIDataFile    invData;     // data file for inventory info
    private ReportPrinter    report;      // printer for report
    private ASCIIOutputFile newInvData;
     private ASCIIPrompter prompter;
    /** The constructor does the day-end inventory control for a small company
      * generating a report.                                                    */
    
    public Inventory ( ) {
        
        String  itemNum;     // item number
        int     reorder;     // reorder point
        int     oQuant;       // quantity on hand
        int     numReorder;  // number of items requiring reorder
        int sold;
        int nQuant;
        
        invData = new ASCIIDataFile();
        report = new ReportPrinter();
        newInvData = new ASCIIOutputFile();
        prompter = new ASCIIPrompter();
        setUpReport();
        numReorder = 0;
        
        for ( ; ; ) {
            itemNum = invData.readString();
            prompter.setLabel(itemNum);
            sold = prompter.readInt();
        if ( invData.isEOF() ) break;
            reorder = invData.readInt();
            oQuant = invData.readInt();
            nQuant = oQuant - sold;
            if ( oQuant <= reorder ) {
                writeDetail(itemNum,reorder,oQuant,sold,nQuant);
                numReorder = numReorder + 1;
            };
            writeInvData(itemNum, reorder, oQuant);
        };
        writeSummary(numReorder);
        newInvData.close();
        invData.close();
        report.close();
        
    };  // constructor
    
    private void writeInvData( String itemNum, int reorder, int quant) {
      
      newInvData.writeString(itemNum);
      newInvData.writeInt(reorder);
      newInvData.writeInt(quant);
      newInvData.newLine();
      
      
    }
    
    
    /** This method sets up the report, adding all fields.                      */
    
    private void setUpReport ( ) {
        
        report.setTitle("National Widgets","Inventory Control");
        report.addField("itemNum","Item #",6);
        report.addField("reorder","Reorder Pt",10);
        report.addField("oQuant","Quantity",8);
         report.addField("sold","Sold",8);
          report.addField("nQuant","New Quant",8);
        
    };  // setUpReport
    
    
    /** This method generates a report detail line.
      * 
      * @param  itemNum  item number
      * @param  reorder  reorder point
      * @param  quant    quantity                                               */
    
    private void writeDetail ( String itemNum, int reorder, int oQuant, int sold, int nQuant ) {
        
        report.writeString("itemNum",itemNum);
        report.writeInt("reorder",reorder);
        report.writeInt("oQuant",oQuant);
        report.writeInt("sold",sold);
        report.writeInt("nQuant", nQuant);
        
    };  // writeDetail
    
    
    /** This method generates the report summary.
      * 
      * @param  numReorder number of items requiring reorder                     */
    
    private void writeSummary ( int numReorder ) {
        
        report.writeLine("# Items to Reorder: "+numReorder);
        
    };  // writeSummary
    
    
    public static void main ( String[] args ) { Inventory i = new Inventory(); };
    
    
}  // Inventory