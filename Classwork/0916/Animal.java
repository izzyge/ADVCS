public class Animal{
  private String type;
  private int age;

  public Animal(String type, int age){
    this.type = type;
    this.age = age;
  }

  public String toString(){
    return "I am a " + age + " year old " + type;
  }
}
