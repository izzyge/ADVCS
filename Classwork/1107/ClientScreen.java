import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.io.*;
import java.net.*;
public class ClientScreen extends JPanel implements ActionListener{

    private String chatMessage = "";
    private PrintWriter out;
    private ArrayList<String> chats = new ArrayList<String>();
    JTextField textInput;
    public ClientScreen(){
      this.setLayout(null);
      chats = new ArrayList<String>();

      textInput = new JTextField();
      textInput.setBounds(300,550, 200, 30);
      textInput.addActionListener(e ->{
        String sendText = textInput.getText();
        if( out != null ){
            out.println(sendText);
            chats.add(sendText);
            textInput.setText("");
        }
        repaint();
      });
      this.add(textInput);

      this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i<chats.size(); i++){
          g.drawString(chats.get(i), 300, 50 + (i*30));
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }


    public void poll() throws IOException{

        String hostName = "localhost";
        int portNumber = 1024;
        Socket serverSocket = new Socket(hostName, portNumber);

        out = new PrintWriter(serverSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));



        chatMessage = in.readLine() + "\n";

        repaint();

        //listens for inputs
        try {

            while (true) {

                chatMessage = in.readLine();
                chats.add(chatMessage);
                repaint();

            }
        } catch (UnknownHostException e) {
            System.err.println("Host unkown: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }

    public void actionPerformed(ActionEvent e) {
    }
}
