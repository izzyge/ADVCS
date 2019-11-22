import java.io.*;
import java.net.*;
import java.util.*;


public class Client {

    public static void main(String[] args){
        String hostName = "localhost";
        int portNumber = 1024;

        try {
            Socket serverSocket = new Socket(hostName, portNumber);

            ObjectOutputStream outObj = new ObjectOutputStream(serverSocket.getOutputStream());
            ObjectInputStream inObj = new ObjectInputStream(serverSocket.getInputStream());

            Scanner sc = new Scanner(System.in);

            HashSet<Student> set = new HashSet<Student>();

            //Receive connection message
            //Waits for and receives an object
            //readObject() requires a ClassNOtFoundException
            for(int i = 0; i<3; i++){
              Student serverMessage = (Student)inObj.readObject();
              set.add(serverMessage);
            }

            System.out.println(set.toString() + "\n");


            System.out.println("add or remove student");
            String next = sc.next();
            if(next.equals("add")){
              System.out.println("enter name");
              String name = sc.next();
              System.out.println("enter id");
              int id = sc.nextInt();
              Student stu = new Student(name, id);
              outObj.writeObject(stu);

            } else if(next.equals("remove")){
              System.out.println("enter student id");
              int id = sc.nextInt();
              Iterator it = set.iterator();
              while(it.hasNext()){
                Student current = (Student) it.next();
                if(current.getID() == id){
                  Student stu = current;
                  outObj.writeObject(stu);
                }
              }

            }


            inObj.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Class does not exist" + e);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }



    }
}
