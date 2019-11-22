import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Runner{
 public static void main(String[] args) {
     Scanner keyBoard = new Scanner(System.in);
     ArrayList<Student> student = new ArrayList<>();
     while(true){
         System.out.println("Enter name of Student or press q to quit: ");
         String name = keyBoard.nextLine();
         if (name.equals("q")){
          break;
          }else{
         System.out.println("Enter grade level: ");
         int grade = keyBoard.nextInt();
         keyBoard.nextLine();
         student.add(new Student(name, grade));

         }
     }
     printList(student);
     System.out.println("What student you would like to delete?");
     String delete = keyBoard.nextLine();
     Iterator<Student> list = student.iterator();
     while(list.hasNext()){
       if (list.next().getName().equals(delete)) {
         list.remove();
         break;
       }
     }
     printList(student);

 }

 private static void printList(ArrayList<Student> studentList) {
     Iterator<Student> list = studentList.iterator();
     while(list.hasNext()){
       System.out.println(list.next());
     }
 }
}
