import java.util.Scanner;
public class Runner{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Account a = new Account("Ly", 1000.0, 1234);
        BankManager b = new BankManager();
        int c = 0;
        int x = 0;

        System.out.println("Enter Pin: ");
        a.setAccess(c = s.nextInt());


    while(a.getAccess()){
        System.out.println("Name: " + a.getName() + " Balance: " + a.getBalance());
        System.out.println("Withdraw or Deposit?");
    String d = s.nextLine();

    if(d.equals("Withdraw")){
      System.out.println("How much?");
      int amount = s.nextInt();
      b.withdraw(a,amount);
      System.out.println("Do you want to log out?");
      s.nextLine();
      String log = s.nextLine();
      if(log.equals("yes"))
      {
      a.disableAccess();
      }
    }
    if(d.equals("Deposit")){
      System.out.println("How much?");
      int amount = s.nextInt();
      b.deposit(a,amount);
      System.out.println("Do you want to log out?");
      s.nextLine();
      String log = s.nextLine();
      if(log.equals("yes"))
      {
      a.disableAccess();
      }
    }




    }


  }
}
