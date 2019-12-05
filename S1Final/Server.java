import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Server extends JPanel implements ActionListener, Serializable, KeyListener {

    private Game game;
    private ServerSocket app;
  	private Socket client;
  	private ObjectOutputStream out;
  	private ObjectInputStream in;
    private BufferedImage computer, erin;
    private Player p1;



    public Server(){
        this.setLayout(null);
        addKeyListener(this);
        game = new Game();
        p1 = new Player();

        try {
          computer = ImageIO.read(new File("imgs/Computer.png"));
          erin = ImageIO.read(new File("imgs/erin.png"));
        } catch (IOException ex){

        }

        this.setFocusable(true);
    }


    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);

    }

    public void actionPerformed(ActionEvent e) {

    }

    private void drawGrid(Graphics g) {
      g.setColor(Color.gray);


      for(int i = 0; i<8; i++){
        g.fillRect((i+1)*100, 0, 5, 800);
      }

      for(int j = 0; j<8; j++){
        g.fillRect(0, (j+1)*100, 800, 5);
      }

      for(int r = 0; r<8; r++){
        for(int c = 0; c<8; c++){
          Location key = new Location(r,c);
          Item value = game.getGrid().get(key);
          if(value != null){
            if(value.getName().equals("Computer")){
              g.drawImage(computer, (r+1) * 100, (c+1) * 100, null);
            }
          }
        }
      }

      g.drawImage(erin, p1.getX(), p1.getY(), null);
      //iterate through hash and draw based off value
  	}

    public void poll() throws Exception {

      app = new ServerSocket(1024);
      client = app.accept();

      out = new ObjectOutputStream(client.getOutputStream());
      in = new ObjectInputStream(client.getInputStream());

      while (true) {
        game = (Game) in.readObject();
        repaint();
      }
    }


  private void sendGame() {
		try {
			out.reset();
			out.writeObject(game);
		} catch (Exception err) {
			System.out.println(err);
		}
	}

  private void playSound(String filename) {
		try {
			URL url = this.getClass().getClassLoader().getResource(filename);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==38){//Up Arrow
      p1.moveUp();
    }else if (e.getKeyCode()==40){//Down Arrow
      p1.moveDown();
    } else if ( e.getKeyCode() == 39 ) { //right
      p1.moveRight();
    }else if (e.getKeyCode()==37){//left Arrow
      p1.moveLeft();
    }
    repaint();
  }


  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}



  public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame("Server");
    Server server = new Server();

    frame.add(server);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    server.poll();
  }





}
