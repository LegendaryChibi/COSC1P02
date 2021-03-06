package Assign_6;
import java.io.Serializable;
/**
 * Class representing a single student's grades.
 * 
 * */
public class Student implements Serializable {
  public static final long serialVersionUID=1337;
  private String stdId; //Student ID
  private String stdName; //Student's name
  private int grade; //Grades are always whole numbers, from 0 to 100
  
  public Student(String id, String name) {
    stdId=id;
    stdName=name;
    grade=0; //defaults to zero until assigned
  }
  
  /**Accessor for Student ID
    * @return  Student's ID number
    */
  public String getId() {
    return stdId;
  }
  
  /**Accessor for Student's name
    * @return  Student's name
    */
  public String getName() {
    return stdName;
  }
  
  /**Accessor for Student's grade
    * @return  Student's grade
    */
  public int getGrade() {
    return grade;
  }
  
  /**Updater for Student's grade
    * @param  newGrade   Grade to replace old one
    */
  public void setGrade(int newGrade) {
    grade=newGrade;
  }
  
  /**Derives and returns student's grade as a letter
    * 0-49:F; 50-59:D; 60-69:C; 70-79:B; 80-100:A
    * @return  Student's letter grade as a String
    */
  public String getLetter() {
    return grade<50?"F":grade<60?"D":grade<70?"C":grade<80?"B":"A";
  }
}