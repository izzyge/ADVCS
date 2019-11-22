
import java.util.ArrayList;
import java.util.Scanner;
public class Runner{
public static void main(String[] args){
	int x = 0;
	ArrayList<Task>todo = new ArrayList<Task>();
	Scanner sc = new Scanner(System.in);
  todo.add(new Task("Do Homework", 1));
  todo.add(new Task("Work", 3));
  todo.add(new Task("buy ", 2));
	while(x == 0)
	{
for(int i = 0; i<todo.size(); i++){
	for(int j = i + 1; j<todo.size(); j++){
		if(todo.get(j).getRank()<todo.get(i).getRank()){
			Task temp = todo.get(i);
			todo.set(i, todo.get(j));
				todo.set(j, temp);
}
}
}

for(Task each: todo){
  System.out.println(each);
}
System.out.println("If you want to add a task type ADD. If you want to delete as task type DELETE.");
String action = sc.next();

if(action.equals("ADD")){
	System.out.println("Task Name: ");
	String name = sc.next();
	System.out.println("Task Rank: ");
	int rank = sc.nextInt();
	todo.add(new Task(name,rank));
} else if (action.equals("DELETE")){
	System.out.println("Task Name: ");
	String name = sc.next();
	for(int i=0; i<todo.size();i++){
	if(todo.get(i).getTask().equals(name)){
	todo.remove(i);
}
}
}

System.out.println("If you would like to exit type EXIT else type NO");
String quit = sc.next();
if(quit.equals("EXIT"))
{
	x++;
}
}
}
}
