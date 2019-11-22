public class Item
{
   String name;
   double price;
   public Item(String a, double b)
   {
       name = a;
       price = b;
   }
   public String toString()
   {
       return name + " : "+ price;
   }
	public double getPrice()
{
return price;
}

  public String getName(){
    return name;
  }

}
