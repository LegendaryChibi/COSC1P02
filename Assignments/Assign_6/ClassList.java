package Assign_6;
import BasicIO.*;
/**Class to display the contents of a 'class list'.
  * Uses Binary IO on Student objects.
  */
public class ClassList {
  public ClassList() {
    ASCIIDisplayer display=new ASCIIDisplayer();
    BinaryDataFile input=new BinaryDataFile();
    Student s=(Student)input.readObject();
    while (!input.isEOF()) {
      display.writeLine(s.getId()+":"+s.getName()+":"+s.getGrade()+":"+s.getLetter());
      s=(Student)input.readObject();
    }
    input.close();
    display.close();
  }
  public static void main(String[] args){new ClassList();}
}