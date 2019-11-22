import java.util.ArrayList;
import java.util.Scanner;
public class Runner
{
	public static void main(String[] args)
  {
    int x = 1;
    Company Microsoft = new Company("Microsoft", 110.47);
    Company Google = new Company("Google", 1172.10);
    Company Apple = new Company("Apple", 219.89);
    Scanner sc = new Scanner(System.in);

    Pair<Employee, Company> one = new Pair<Employee, Company>(new Employee("John"), Microsoft);
		Pair<Employee, Company> two = new Pair<Employee, Company>(new Employee("Jose"), Google);
    Pair<Employee, Company> three = new Pair<Employee, Company>(new Employee("Jennifer"), Google);
    Pair<Employee, Company> four = new Pair<Employee, Company>(new Employee("Heather"), Apple);
    Pair<Employee, Company> five = new Pair<Employee, Company>(new Employee("Maria"), Apple);

    ArrayList<Pair<Employee,Company>> people = new ArrayList<Pair<Employee,Company>>();
  	people.add(one);
    people.add(two);
  	people.add(three);
  	people.add(four);
  	people.add(five);
    if(x==1)
      System.out.println("Press 1 to Print, Press 2 to see Company, Press 3 to Quit");
      int option= sc.nextInt();
      if(option == 1){
        for(Pair each: people){
          System.out.println(each);
        }
      } else if(option == 2){
        System.out.println("Which company?");
        String co = sc.next();
        System.out.println("New stock price?");
        double price = sc.nextDouble();
        if(co.equals("Microsoft")){
          Microsoft.updateStockPrice(price);
          System.out.println(Microsoft);
        } else if(co.equals("Apple")){
          Apple.updateStockPrice(price);
          System.out.println(Apple);
        }  else if(co.equals("Google")){

          Google.updateStockPrice(price);
          System.out.println(Google);
        }
        for(int i=0; i<people.size(); i++){
            System.out.println(people.get(i));
        }
      } else if(option == 3){
        x = 0;
      }

  }
}
