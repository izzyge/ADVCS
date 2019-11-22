public class BankManager{
	public void enableAccess(Account a, int pin){
		a.setAccess(pin);
  }

  public String toString(Account a){
	   return a.getName() + " " + a.getBalance();
  }

  public void deposit(Account a, double amount){
  	a.setBalance(a.getBalance()+amount);
  }

  public void withdraw(Account a, double amount){
  	a.setBalance(a.getBalance()-amount);
  }
}
