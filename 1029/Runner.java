import java.util.*;
public class Runner{
  public static void main(String[] args){
    Queue<Customer> customers = new LinkedList<>();
    customers.add(new Customer("John", 123123123));
    customers.add(new Customer("Joe", 321321321));
    customers.add(new Customer("Al", 555555555));

    while(!customers.isEmpty()){
      System.out.println(customers.poll());
    }
  }
}
