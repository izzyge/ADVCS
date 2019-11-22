import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {

        int portNumber = 200;

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept(); //wait for a connection
            System.out.println("Connection Successful");//Will print after connection is made

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            int x = 1;
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("hello", "Hello, how are you?");
            map.put("bye", "Goodbye, have a good day!");
            map.put("problem", "Can you elaborate on your problem?");
            map.put("joke", "Why do coders wear glasses, because they can't C sharp");
            map.put("sad", "I hope you feel better!");

            out.println("Welcome!");
            while(x==1){
              String chat = in.readLine();
              for(String s: map.keySet()){
                if(chat.contains(s)){
                  out.println(map.get(s));
                }
              }
            }




            out.close();

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
