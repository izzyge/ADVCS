import java.util.*;
import java.lang.*;

public class Item implements Comparable<Item>{
  private String name;
  private double price;
  public Item(String name, double price){
    this.name = name;
    this.price = price;
  }

  public int hashCode() {

  	int hashCode = 0;
  	char[] array = name.toCharArray();

  	for (int i = array.length - 1; i >= 0; i--) {
  		hashCode += ((int)array[i] - 96) * Math.pow(26, i);
  	}

  	hashCode = hashCode + (int)(price * 100);

		return hashCode;
  }

  public boolean equals(Object o){
    Item i = (Item) o;
    return i.toString().equals(toString());
  }

  public int compareTo(Item item) {
		return this.toString().compareTo(item.toString());
	}

  public String getName() {
    return name;
  }
  
	public double getPrice() {
    return price;
  }

	public String toString() {
		return name + ", $" + price;
	}
}
