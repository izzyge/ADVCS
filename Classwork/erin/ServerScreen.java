import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerScreen extends JPanel implements ActionListener {

    private JTextField textInput;
    private JButton sendButton;
    private ArrayList<String> ownChats;
    private ArrayList<String> chats;

    private String chatMessage = "";

    private PrintWriter out;
    private int y;
    private int yy;

    public ServerScreen(){

        ownChats = new ArrayList<String>();
        chats = new ArrayList<String>();
        y = 0;
        yy = 20;

        this.setLayout(null);

        textInput = new JTextField();
        textInput.setBounds(50,300, 200, 30);
        this.add(textInput);
        textInput.addActionListener(this);

        this.setFocusable(true);
    }


    public Dimension getPreferredSize() {

        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         yy = 20;
        for(int i = 0; i<chats.size(); i++){
        	g.drawString( chats.get(i), 100, yy );
        	yy+=40;
        }

		y = 0;
        for(int i = 0;i<ownChats.size();i++){
            g.drawString(ownChats.get(i), 400, y);
            y+= 40;
        }

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == textInput) {
            String sendText = textInput.getText();
            if( out != null ){
                out.println(sendText);
                ownChats.add(sendText);
            }
            textInput.setText("");
        }
        repaint();

    }

    public void poll() throws IOException {
        int portNumber = 1024;
        String hostName = "localhost";

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        chatMessage = in.readLine();
        chats.add(chatMessage);
        repaint();

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



}
