public class Account{
  private String name;
  private double balance;
  private int pin;
  private boolean access;
  public Account(String name, double balance, int pin){
    access = false;
    this.name = name;
    this.balance = balance;
    this.pin = pin;
  }

  public String getName(){
    return name;
  }

  public Double getBalance(){
    if(access)
      return balance;
    else
      return 0.0;
  }

  public boolean getAccess(){
    return access;
  }

  public void logOut(){
    access = false;
  }

  public void setAccess(int p, String n){
    if(pin == p && name.equals(n))
      access = true;

  }

  public void withdraw(double amount){
    if(access && amount<= balance)
      balance -= amount;
  }

  public void deposit(double amount){
    if(access)
      balance += amount;
  }
}
