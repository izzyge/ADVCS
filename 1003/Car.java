import java.util.*;
public class Car{
  private String name, make;
  private int year;
  public Car(String name, String make, int year){
    this.name = name;
    this.make = make;
    this.year = year;
  }

  public int hashCode(){
    return name.length() + make.length() * year * 19;
  }

  public boolean equals(Object o){
    Car c = (Car) o;
    if(c.toString().equals(this.toString()))
      return true;
    return false;
  }

  public String toString(){
    return year + " " + name + ", " + make;
  }

}
