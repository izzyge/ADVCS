import java.util.ArrayList;
import java.util.Iterator;
public class Runner1{
  public static void main(String[] args){
    ArrayList<Animal> list = new ArrayList<Animal>();
    list.add(new Animal("dog", 5));
    list.add(new Animal("cat",4));
    list.add(new Animal("bird", 10));

    Iterator<Animal> it = list.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }
  }
}
