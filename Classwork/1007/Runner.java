import java.util.*;
public class Runner{
	public static void main(String[] args){
		Map<Integer, String> studentList = new HashMap<Integer, String>();
		studentList.put(1234, "John");
		studentList.put(333, "Joe");
		studentList.put(333, "Joe");
		studentList.put(432, "Alex");
studentList.put(422, "Alex");
studentList.put(555, "Sam");
studentList.put(555, "Doug");
Iterator it = studentList.keySet().iterator();
while(it.hasNext()){
  Object i = it.next();
	System.out.println(i + "-" + studentList.get(i));
}
}
}
