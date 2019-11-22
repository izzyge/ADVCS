public class Customer{
  private String name;
  private int phone;
  public Customer(String name, int phone){
    this.name = name;
    this.phone = phone;
  }

  public String toString(){
    return name + ": " + phone;
  }
}
