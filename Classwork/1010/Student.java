import java.util.*;
public class Student implements Comparable<Student>{
  private String name;
  private int id;
  public Student(String name, int id){
    this.name = name;
    this.id = id;
  }

  public int compareTo(Student stu){
    if(stu.getId() == id && stu.getName().equals(name)){
      return 0;
    } else if (name.compareTo(stu.getName())<0){
      return 1;
    } else if (name.compareTo(stu.getName())>0){
      return -1;
    } else {
      if(id<stu.getId()){
        return 1;
      } else if(id>stu.getId()){
        return -1;
      }

    }
    return -1;
  }

  public boolean equals(Object o){
    Student stu = (Student) o;
    return stu.getId() == id && stu.getName() == name;
  }

  public int hashCode(){
    int hash = name.hashCode();
    return hash * id * 29;
  }

  public int getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public String toString(){
    return name + ", " + id;
  }
}
