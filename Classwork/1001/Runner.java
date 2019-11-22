import java.util.*;
public class Runner
{
public static void main(String[] args)
{
	Set<Student> hash = new HashSet<Student>();
	Set<Student> tree = new TreeSet<Student>();

	Scanner sc = new Scanner(System.in);
	for(int i = 0;i<5;i++)
	{
		System.out.println("Name: ");
		String name =  sc.next();
		System.out.println("ID");
		int id = sc.nextInt();
		hash.add(new Student(name,id));
	}
	for(int i = 0;i<5;i++)
	{
		System.out.println("Name: ");
		String name =  sc.next();
		System.out.println("ID");
		int id = sc.nextInt();
		tree.add(new Student(name,id));
	}

	Iterator<Student> hashIt = hash.iterator();
Iterator<Student> treeIt = tree.iterator();
while(hashIt.hasNext()){
	System.out.println(hashIt.next());
}

	while (treeIt.hasNext())
	{
		System.out.println(treeIt.next());
	}


}
}
