package Lab_10_1;


import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class represents an inventory item in the National Widgets warehouse. An
  * item has an item number, a reorder point and a quantity on hand.
  * 
  * @author David Hughes
  * 
  * @version 1.2 (Nov. 2014)                                                     */

public class Item{
    
    
    private String  itemNum;     // item number
    private int     reorder;     // reorder point
    private int     quant;       // quantity on hand

    
    /** This constructor creates a new Item loading its attributes from a file.
      * 
      * @param  from  file to load attributes from                               */
    
    public Item ( ASCIIDataFile from ) {
        
        itemNum = from.readString();
        if ( ! from.isEOF() ) {
            reorder = from.readInt();
            quant = from.readInt();
        };
        
    };  // constructor
    
    
    /** This method returns the item's item number.
      * 
      * @return String  the item's item number.                                 */
    
    public String getItemNum ( ) {
        
        return itemNum;
        
    };  // getItemNum
    
    
    /** This method returns the item's reorder point.
      * 
      * @return int  the item's reorder point.                                  */
    
    public int getReorder ( ) {
        
        return reorder;
        
    };  // getReorder
    
    
    /** This method returns the item's quantity on hand.
      * 
      * @return int  the item's quantity on hand.                               */
    
    public int getQuant ( ) {
        
        return quant;
        
    };  // getQuant
    
    
    /** This method updates the item's reorder point.
      * 
      * @param newReorder  the item's new reorder point.                        */
    
    public void setReorder ( int newReorder ) {
        
        reorder = newReorder;
        
    };  // setReorder
    
    
    /** This method represents the sale of some number of the item.
      * 
      * @param  num  number of the item sold.                                   */
    
    public void sell ( int num ) {
        
        quant = quant - num;
        
    };  // sell
    
    
    /** This method determines if the widget needs to be reordered.
      *
      * @return boolean  ture if the item needs to be reordered.                 */
    
    public boolean shouldReorder ( ) {
        
        return quant <= reorder;
            
    };  // shouldReorder
    
    
    /** This method writes the iyem's attributes to a file suitable for reading
      * in the constructor.
      * 
      * @param  to  the file to write the attributes to.                         */
    
    public void write ( ASCIIOutputFile to ) {
        
        to.writeString(itemNum);
        to.writeInt(reorder);
        to.writeInt(quant);
        to.newLine();
            
    };  // write
    
    
}  // Item