package Lab_10_1;


import BasicIO.*;
import static BasicIO.Formats.*;


/** This class is a program to do a simple inventory control producing a report.
  * 
  * @author David Hughes
  * 
  * @version 1.1 (Nov. 2016)                                                    */

public class Inventory {
    
    
    private ASCIIDataFile    invData;     // data file for inventory info
    private BasicForm        display;     // GUI for user input
    private ASCIIOutputFile  newInvData;  // new (updated) inventory file
    private ReportPrinter    report;      // printer for report
    
    
    /** The constructor does the day-end inventory control for a small company
      * generating a report.                                                    */
    
    public Inventory ( ) {
        
        Item    anItem;      // item in inventory
        int     oQuant;      // old quantity on hand
        int     sold;        // number sold
        int     numReorder;  // number of items requiring reorder
        
        invData = new ASCIIDataFile();
        display = new BasicForm();
        newInvData = new ASCIIOutputFile();
        report = new ReportPrinter();
        setUpReport();
        buildForm();
        numReorder = 0;
        for ( ; ; ) {
            anItem = new Item(invData);
        if ( invData.isEOF() ) break;
            fillForm(anItem);
            display.accept();
            sold = display.readInt("sold");
            oQuant = anItem.getQuant();
            anItem.sell(sold);
            if ( anItem.shouldReorder() ) {
                writeDetail(anItem,oQuant,sold);
                numReorder = numReorder + 1;
            };
            anItem.write(newInvData);
        };
        writeSummary(numReorder);
        invData.close();
        newInvData.close();
        display.close();
        report.close();
        
    };  // constructor
    
    
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
      * @param  anItem    the item
      * @param  oQuant    old quantity
      * @param  sold      items sold                                            */
    
    private void writeDetail ( Item anItem, int oQuant, int sold ) {
        
        report.writeString("itemNum",anItem.getItemNum());
        report.writeInt("reorder",anItem.getReorder());
        report.writeInt("oQuant",oQuant);
        report.writeInt("sold",sold);
        report.writeInt("nQuant",anItem.getQuant());
        
    };  // writeDetail
    
    
    /** This method generates the report summary.
      * 
      * @param  numReorder number of items requiring reorder                     */
    
    private void writeSummary ( int numReorder ) {
        
        report.writeLine("# Items to Reorder: "+numReorder);
        
    };  // writeSummary
    
    
    /** This method builds the form for user input.                              */
    
    private void buildForm ( ) {
        
        display.setTitle("Inventory");
        display.addTextField("num","Item #",10,10,10);
        display.setEditable("num",false);
        display.addTextField("reorder","Reorder Point",5,10,40);
        display.setEditable("reorder",false);
        display.addTextField("quant","Quantity on Hand",5,10,70);
        display.setEditable("quant",false);
        display.addTextField("sold","Number Sold",5,10,100);
        
    };  // buildForm
    
    
    /** This method fills inventory datat into the form.
      * 
      * @param  itemNum  item number
      * @param  reorder  reorder point
      * @param  quant    quantity on hand                                        */
    
    public void fillForm ( Item anItem ) {
        
        display.writeString("num",anItem.getItemNum());
        display.writeInt("reorder",anItem.getReorder());
        display.writeInt("quant",anItem.getQuant());
        display.clear("sold");
        
    };  // fillForm
    
    
    public static void main ( String[] args ) { Inventory i = new Inventory(); };
    
    
}  // Inventory