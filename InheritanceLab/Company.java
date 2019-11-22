public class Company extends Employee{
  private String companyName;
  public Company(String n, String p, String j, String c){
    super(n,p,j);
    companyName = c;
  }

  public String toString(){
    return super.toString() + " Company:" + companyName;
  }

  public double getSalary(){
    return 150000.0;
  }

}
