package Assign_6;
import BasicIO.*;
/**Class for generating 'class lists'.
  * Saves in binary format.
  */
public class CreateClassList {
  BasicForm form;
  BinaryOutputFile output;
  
  public CreateClassList() {
    setupForm();
    output=new BinaryOutputFile("allstudents.bin");
    enterStudents();
    form.close();
    output.close();
  }
  
  /**Method for accepting user-inputted student records.
    */
  private void enterStudents() {
    while (true) {
      int choice=form.accept("Enter","Complete");
    if (choice>0) break;
      String id=form.readString("id");
      String name=form.readString("name");
      int grade=form.readInt("grade");
      Student s=new Student(id,name);
      s.setGrade(grade);
      output.writeObject(s);
      form.clearAll();
    }
  }
  
  /**Initializes the student-entry form for use.
    */
  private void setupForm() {
    form=new BasicForm();
    form.addTextField("id","Id");
    form.addTextField("name","Name");
    form.addTextField("grade","Grade");
  }
  
  
  public static void main(String[] args) {new CreateClassList();}
}