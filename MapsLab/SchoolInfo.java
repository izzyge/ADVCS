import java.util.*;
public class SchoolInfo{
  private String schoolname;
  private String classes;

  public SchoolInfo(String schoolname, String classes){
    this.schoolname = schoolname;
    this.classes = classes;
  }

  public String toString(){
    return schoolname + " " + classes;
  }

  public String getSchool(){
    return schoolname;
  }

  public void changeSchool(String school){
    schoolname = school;
  }

  public void addClass(String course){
    classes += "  " + course;
  }

  public void removeClass(String course){
    int startIndex = classes.indexOf(course.charAt(0));
    int endIndex = classes.indexOf(course.charAt(course.length()-1));
    String replacement = "";
    String toBeReplaced = classes.substring(startIndex, endIndex);
    classes.replace(toBeReplaced, replacement);
  }

  public String getClasses(){
    return classes;
  }
}
