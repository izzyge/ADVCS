public class Student extends People{
  private String school;
  public Student(String school, String name, int age){
    super(name,age);
    this.school = school;

  }
  public String toString(){
    return super.toString() + " " + school;
  }
}
