public class Company{
	private String name;
  private double stockPrice;
  public Company(String n, double s){
    name = n;
    stockPrice = s;
  }

  public String toString(){
		return name + " $" + stockPrice;
  }

  public void updateStockPrice(double price){
    stockPrice = price;
	}

  public String getName(){
    return name;
  }
}
