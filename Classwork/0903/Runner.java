import java.util.ArrayList;
public class Runner{
  public static void main(String[] args){
    ArrayList<People> list = new ArrayList<People>();
    list.add(new People("Jeff", 15));
    list.add(new People("Jen", 40));
    list.add(new People("Jared", 58));
    list.add(new Employee("Maya", 43, 30000.00));
    list.add(new Employee("Max", 24, 1000000.00));
    list.add(new Employee("May", 63, 44400.00));
    list.add(new Student("Mountain View HS", "Alex", 13));
    list.add(new Student("Los Altos HS","Alan", 16));
    list.add(new Student("Los Altos HS","Al", 17));
    list.add(new CollegeStudent("Aaron", 18, "Stanford", "CS"));
    list.add(new CollegeStudent("Aaron", 20, "Harvard", "Business"));
    list.add(new CollegeStudent("Aaron", 21, "Stanford", "CS"));

    for(People each: list){
      System.out.println(each);
    }
  }
}
