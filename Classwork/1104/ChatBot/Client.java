import java.net.*;
import java.io.*;
import java.util.*;


public class Client {
    public static void main(String[] args)  {

        String hostName = "10.210.16.164";
        int portNumber = 1027;

        try {

            Socket serverSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            int active = 1;

            //First Message received
            String serverMessage = in.readLine();
            System.out.println(serverMessage);
            while(active == 1){
              String chat = sc.nextLine();
              out.println(chat);
              System.out.println(in.readLine());

            }


            in.close();

        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
