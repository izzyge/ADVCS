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

public class ServerScreen extends JPanel implements ActionListener {

    private String chatMessage = "";

    private JTextField textInput;

    private PrintWriter out;
    private ArrayList<String> chats;

    public ServerScreen(){

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


    public Dimension getPreferredSize() {

        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<chats.size(); i++){
          g.drawString(chats.get(i), 300, 50 + (i*20));
        }

    }

    public void actionPerformed(ActionEvent e) {
    }

    public void poll() throws IOException {
        int portNumber = 1024;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        out.println("You are connected to the server!");
        try {

            while (true) {

                chatMessage = in.readLine();
                chats.add(chatMessage);
                repaint();

            }
        } catch (UnknownHostException e) {
            System.err.println("Host unkown: ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to ");
            System.exit(1);
        }

    }





}
