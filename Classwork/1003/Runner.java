import java.util.*;
public class Runner{
  public static void main(String[] args){
    Set<Car> cars = new HashSet<Car>();
    cars.add(new Car("Focus", "Ford", 2005));
    cars.add(new Car("Accord", "Honda", 2014));
    cars.add(new Car("Camry", "Toyota", 2012));
    cars.add(new Car("Accord", "Honda", 2014));
    Iterator it = cars.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }

  }
}
