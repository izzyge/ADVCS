public class Employee extends People
{
	private double salary;
  public Employee(String a, int b, double c)
  {
    super(a,b);
    salary = c;
	}
  public String toString()
  {
    return super.toString()+" $"+salary;
	}
}
