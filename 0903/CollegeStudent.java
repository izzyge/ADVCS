public class CollegeStudent extends Student{
  private String major;
  public CollegeStudent(String name, int age, String school, String major){
    super(school,name,age);
    this.major = major;
  }
  public String toString(){
    return super.toString() + " " + major;
  }
}
