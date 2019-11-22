import java.util.ArrayList;
public class Runner{
  public static void main(String[] args){
    ArrayList<Animal> list = new ArrayList<Animal>();
    list.add(new Dog("Jack"));
    list.add(new Cat("Luna"));
    list.add(new Bird("Kiwi"));
    for(int i=0; i<list.size(); i++){
      list.get(i).printInfo();
    }
  }
}
