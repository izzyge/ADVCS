public class Animal{
  private String name;
  private int age;

  public Animal(String n, int a){
    name = n;
    age = a;
  }

  public String toString(){
    return "name: " + name + " age: " + age;
  }

  public void setName(String n){
    name = n;
  }

  public void setAge(int a){
    age = a;
  }
}
