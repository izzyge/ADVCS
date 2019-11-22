import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {

        int portNumber = 1024;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();

            ObjectOutputStream outObj = new ObjectOutputStream(clientSocket.getOutputStream());
            // outObj.writeObject("Connection Successful!");

            ObjectInputStream inObj = new ObjectInputStream(clientSocket.getInputStream());
            int x = 1;

            HashSet<Student> set = new HashSet<Student>();
            set.add(new Student("John",123));
            set.add(new Student("Joe",321));
            set.add(new Student("Alex",432));

            Iterator it = set.iterator();
            while(it.hasNext()){
              outObj.writeObject(it.next());
            }


            while(x==1){
              Student stu = (Student)inObj.readObject();
              if(set.contains((Student)stu)){
                set.remove(stu);
              } else {
                set.add(stu);
              }
            }

            outObj.close();

        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("Class does not exist" + e);
            System.exit(1);
        }
    }
}
