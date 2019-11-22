public class Government extends Employee{
  private String cityName;
  public Government(String n, String p, String j, String c){
    super(n,p,j);
    cityName = c;
  }

  public String toString(){
    return super.toString() + " City:" + cityName;
  }

  public double getSalary(){
    return 100000.0;
  }

}
