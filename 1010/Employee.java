public class Employee implements Comparable<Employee>
{
	String name;
	int id;
	public Employee(String a, int b)
	{
		name = a;
		id = b;
	}
	public String toString()
	{
return name + " : "+id;
}
public int compareTo(Employee em)
{
	if(name.compareTo(em.getName())>0)
		return 1;
	else if(name.compareTo(em.getName())<0)
		return -1;
	else {
		if(id > em.getID())
			return -1;
		else if(id < em.getID())
			return 1;
		else
			return 0;
}

}
public boolean equals(Object o){
	Employee e = (Employee) o;
	if(e.getID() == id)
		return true;
		return false;
}
public int hashCode(){
int hashCode = name.hashCode();
return hashCode * id * 31;
}
public int getID(){
	return id;
}
public String getName(){
	return name;
}

}
