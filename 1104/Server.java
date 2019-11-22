import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {

        int portNumber = 1024;

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept(); //wait for a connection
            System.out.println("Connection Successful");//Will print after connection is made

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("What is the capital of California?");
            String ans1 = in.readLine();
            if(ans1.equals("Sacramento"))
              out.println("Correct!");
            else
              out.println("Incorrect");

            out.println("How many states are in the US?");
            String ans2 = in.readLine();
            if(ans2.equals("50"))
              out.println("Correct!");
            else
              out.println("Incorrect");

            out.println("What is the capital of China?");
            String ans3 = in.readLine();
            if(ans3.equals("Beijing"))
              out.println("Correct!");
            else
              out.println("Incorrect");

            out.println("How many continents are in the world?");
            String ans4 = in.readLine();
            if(ans4.equals("7"))
              out.println("Correct!");
            else
              out.println("Incorrect");

            out.println("What's the capital of the US?");
            String ans5 = in.readLine();
            if(ans5.equals("Washington DC"))
              out.println("Correct!");
            else
              out.println("Incorrect");



            out.close();

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
