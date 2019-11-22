import java.util.*;
public class Runner{
	public static void main(String[] args){
		Map<Employee, Double> tMap = new TreeMap<Employee, Double>();
		Map<Employee, Double> hMap = new HashMap<Employee, Double>();
	hMap.put(new Employee("John", 1234),50000.0);
	hMap.put(new Employee("Paula", 4321),60000.0);
	hMap.put(new Employee("Paula", 4321),61000.0);
	hMap.put(new Employee("Jose", 1111),70000.0);
	hMap.put(new Employee("John", 1234),50000.0);
	hMap.put(new Employee("John", 1232),51000.0);
	hMap.put(new Employee("Henry", 1234),50000.0);



	tMap.put(new Employee("Henry", 1234), 55000.0);
tMap.put(new Employee("Henry", 1234), 50000.0);
tMap.put(new Employee("Henry", 1221), 60000.0);
tMap.put(new Employee("Jennifer", 4321), 71000.0);
tMap.put(new Employee("Jose", 1111),70000.0);
tMap.put(new Employee("John", 1234),50000.0);
tMap.put(new Employee("John", 1234),50000.0);

for(Employee e: tMap.keySet()){
	System.out.println(e + " - $" + tMap.get(e));
}

for(Employee e: hMap.keySet()){
	System.out.println(e + " - $" + hMap.get(e));
}

Scanner sc = new Scanner(System.in);
while(true){
System.out.println("Enter an ID");
int id = sc.nextInt();
for(Employee e: hMap.keySet()){
	if(e.getID() == id){
		System.out.println(hMap.get(e));
}
}

}


}
}
