public class Account
{
    private String name;
    private double balance;
    private int pin;
    private boolean access;

    public Account(String a, Double b, int c)
    {
    name = a;
    balance = b;
    pin = c;
    access = false;
    }
    public String getName()
    {
    if(access)
    {
    return name;
    }
    else
    return null;
    }
    public double getBalance()
    {
    if(access)
    return balance;
    else
    return 0;
    }
    public int getPin()
    {
        return pin;
    }
    public boolean getAccess()
    {
    return access;
    }
    public void setAccess(int a)
    {
    if(pin == a)
    {
    access = true;
    }
    }
    public void setBalance(double a)
    {
        if(access)
        {
            balance = a;
        }
    }

    public void disableAccess(){
      access = false;
    }
}
