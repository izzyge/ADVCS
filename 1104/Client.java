import java.net.*;
import java.io.*;
import java.util.*;


public class Client {
    public static void main(String[] args)  {

        String hostName = "localhost";
        int portNumber = 1024;

        try {

            Socket serverSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            Scanner sc = new Scanner(System.in);

            //First Message received
            String serverMessage = in.readLine();
            System.out.println(serverMessage);
            out.println(sc.next());
            System.out.println(in.readLine());

            serverMessage = in.readLine();
            System.out.println(serverMessage);
            out.println(sc.next());
            System.out.println(in.readLine());

            serverMessage = in.readLine();
            System.out.println(serverMessage);
            out.println(sc.next());
            System.out.println(in.readLine());

            serverMessage = in.readLine();
            System.out.println(serverMessage);
            out.println(sc.next());
            System.out.println(in.readLine());

            serverMessage = in.readLine();
            System.out.println(serverMessage);
            out.println(sc.next());
            System.out.println(in.readLine());


            in.close();

        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
