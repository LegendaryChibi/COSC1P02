package Assign_6;

import BasicIO.*;

/**
 * This is a simple class that will read a binary file, create an output binary file with a report, and prompt the user for a score threshold.
 * 
 * @author     Joshua Varghese
 * @course     COSC 1P02
 * @assignment #6
 * @student Id 7123870
 * @version    1.0
 * @since      December 15th, 2021
 */                                                     

public class HonourList {
  
  private ASCIIPrompter    prompter;    // prompter for user input
  private ReportPrinter    report;      // printer for report
  private BinaryOutputFile output;      // output file for report
  
  public HonourList ( ) {
    prompter = new ASCIIPrompter(); // Create new prompter.
    BinaryDataFile input=new BinaryDataFile(); //New input binary supplier file.
    output = new BinaryOutputFile(); //New output binary file.
    report = new ReportPrinter(); // New report.
    setUpReport(); //Call the setUpReport() function with all fields required.
    int threshold = prompter.readInt(); //Prompt the user for minimum score threshold.
    
    Student s=(Student)input.readObject(); //Get first record.
    
    while (!input.isEOF()) { //read file.
      if (s.getGrade() >= threshold) { //if this record's grade is above. 
        //print it to the new binary file.
        output.writeObject(s);
        
        //print it to the report.
        writeDetail(s.getId(), s.getName(), s.getGrade(), s.getLetter());
      }
      
      s=(Student)input.readObject(); //Get next record.
    }
    //Close all files that have been opened to save.
    input.close();
    output.close();
    report.close();
    
  }; // constructor
  
  
  // methods
  
  /** This method sets up the report, adding all fields.                      */
  
  private void setUpReport ( ) {
    
    report.setTitle("Student Grades");
    report.addField("ID","StudentID",9); //(id, label, spacing)
    report.addField("NAME","Name",6);
    report.addField("GRADE","Score",5);
    report.addField("LETTER","Grade",5);
    
  };  // setUpReport
  
  /** This method generates a report detail line.
      * 
      * @param  ID      student id
      * @param  NAME    name
      * @param  GRADE   grade
      * @param  LETTER  letter                                           */
    
    private void writeDetail ( String ID, String NAME, int GRADE, String LETTER ) {
        
        report.writeString("ID", ID);
        report.writeString("NAME", NAME);
        report.writeInt("GRADE", GRADE);
        report.writeString("LETTER", LETTER);
        
    };  // writeDetail
  
  public static void main ( String[] args ) { new HonourList(); };
  
  
} // HonourList
