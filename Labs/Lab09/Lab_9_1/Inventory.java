package Lab_9_1;


import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class is a program to do a simple inventory control producing a report.
  * 
  * @author David Hughes
  * 
  * @version 1.1 (Nov. 2016)                                                    */

public class Inventory {
    
    
    private ASCIIDataFile    invData;     // data file for inventory info
    private ASCIIPrompter    prompter;    // prompter for user input
    private ASCIIOutputFile  newInvData;  // new (updated) inventory file
    private ReportPrinter    report;      // printer for report
    private BasicForm display;
    
    /** The constructor does the day-end inventory control for a small company
      * generating a report.                                                    */
    
    public Inventory ( ) {
        
        String  itemNum;     // item number
        int     reorder;     // reorder point
        int     oQuant;      // old quantity on hand
        int     nQuant;      // new quantity on hand
        int     sold;        // number sold
        int     numReorder;  // number of items requiring reorder
        
        invData = new ASCIIDataFile();
        display = new BasicForm();
        //newInvData = new ASCIIOutputFile();
        report = new ReportPrinter();
        setUpReport();
        buildForm();
        numReorder = 0;
        for ( ; ; ) {
            itemNum = invData.readString();
        if ( invData.isEOF() ) break;
            reorder = invData.readInt();
            oQuant = invData.readInt();
            fillForm(itemNum,reorder,oQuant);
            display.accept();
            sold = display.readInt("sold");
            nQuant = oQuant - sold;
            if ( nQuant <= reorder ) {
                writeDetail(itemNum,reorder,oQuant,sold,nQuant);
                numReorder = numReorder + 1;
            };
            writeInvData(itemNum,reorder,nQuant);
        };
        writeSummary(numReorder);
        invData.close();
        //newInvData.close();
        //prompter.close();
        report.close();
        
    };  // constructor
    
    private void fillForm(String itemNumber, int reorder, int quant){
      display.clearAll();
      display.writeString("itemNumber", itemNumber);
      display.writeInt("reorder", reorder);
      display.writeInt("quant", quant);
    }
    private void buildForm(){
      display.setTitle("My BasicForm");
      display.addTextField("itemNumber", "Item #", 10, 10, 10);
      display.setEditable("itemNumber", false);
      display.addTextField("reorder", "Reorder Point", 5, 10, 40);
        display.setEditable("reorder", false);
      display.addTextField("quant", "Quantity on hand", 5, 10, 70);
        display.setEditable("quant", false);
      display.addTextField("sold", "Number sold", 5, 10, 100);
    }
    
    /** This method sets up the report, adding all fields.                      */
    
    private void setUpReport ( ) {
        
        report.setTitle("National Widgets","Inventory Control");
        report.addField("itemNum","Item #",6);
        report.addField("reorder","Reorder Pt",10);
        report.addField("oQuant","Old",8);
        report.addField("sold","Sold",8);
        report.addField("nQuant","New",8);
        
    };  // setUpReport
    
    
    /** This method generates a report detail line.
      * 
      * @param  itemNum   item number
      * @param  reorder   reorder point
      * @param  oQuant    old quantity
      * @param  sold      items sold
      * @param  nQuant    new quantity                                          */
    
    private void writeDetail ( String itemNum, int reorder, int oQuant,
                               int sold, int nQuant ) {
        
        report.writeString("itemNum",itemNum);
        report.writeInt("reorder",reorder);
        report.writeInt("oQuant",oQuant);
        report.writeInt("sold",sold);
        report.writeInt("nQuant",nQuant);
        
    };  // writeDetail
    
    
    /** This method generates the report summary.
      * 
      * @param  numReorder number of items requiring reorder                     */
    
    private void writeSummary ( int numReorder ) {
        
        report.writeLine("# Items to Reorder: "+numReorder);
        
    };  // writeSummary
    
    
    /** This method writes a record to the new inventory file.
      * 
      * @param  itemNum  item number
      * @param  reorder  reorder point
      * @param  quant    quantity                                                */
    
    private void writeInvData ( String itemNum, int reorder, int quant ) {
        
//        newInvData.writeString(itemNum);
//        newInvData.writeInt(reorder);
//        newInvData.writeInt(quant);
//        newInvData.newLine();
        
    };  // writeInvData
    
    
    public static void main ( String[] args ) { Inventory i = new Inventory(); };
    
    
}  // Inventory