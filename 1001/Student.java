public class Student implements Comparable<Student>{
	private String name;
	private int id;
	public Student(String name, int id){
		this.name = name;
		this.id = id;
}

public int compareTo(Student s){
	if(s.getName() == name && s.getID() == id)
		return 0;
	else
		return name.compareTo(s.getName());
}

public boolean equals(Object o){
	Student s = (Student) o;
	if(name.equals(s.getName())&&s.getID() == id )
		return true;
	return false;
}

public String getName(){
	return name;
}

public int getID(){
	return id;
}

public String toString(){
	return name + ": " + id;
}
}
