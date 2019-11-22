public class Profile
{
String name;
int age;
public Profile(String a, int b)
{
name = a;
age = b;
}
public String getName()
{
	return name;
}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return "name: "+name+" age: "+age;
	}
}
