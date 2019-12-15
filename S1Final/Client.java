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

public class Client extends JPanel implements ActionListener, Serializable, KeyListener {

    private Game game;
    private ServerSocket app;
  	private Socket server;
  	private ObjectOutputStream out;
  	private ObjectInputStream in;
    private BufferedImage computer, erin, desk, mateen, life, bomb, win, lose;
    private Player p1, p2;
    private int bombs;



    public Client(){
        this.setLayout(null);
        addKeyListener(this);
        game = new Game();
        p1 = game.getP1();
        p2 = game.getP2();
        bombs = 0;

        try {
          computer = ImageIO.read(new File("imgs/Computer.png"));
          erin = ImageIO.read(new File("imgs/erin.png"));
          desk = ImageIO.read(new File("imgs/Desk.png"));
          mateen = ImageIO.read(new File("imgs/mateen.png"));
          life = ImageIO.read(new File("imgs/Life.png"));
          bomb = ImageIO.read(new File("imgs/Bomb.png"));
          win = ImageIO.read(new File("imgs/Win.jpg"));
          lose = ImageIO.read(new File("imgs/Lose.png"));
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
        if(game.win()==2 || game.lose()==1){
          g.drawImage(win,0,0,null);
        } else if(game.win()==1 || game.lose()==2){
          g.drawImage(lose,0,0,null);
        }

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
              g.drawImage(computer, (r) * 100, (c) * 100, null);
            } else if(value.getName().equals("Desk")){
              g.drawImage(desk, (r) * 100 + 6, (c) * 100 + 6, null);
            } else if(value.getName().equals("Bomb")){
              g.drawImage(bomb, (r) * 100, (c) * 100, null);
            }
          }
        }
      }
      g.setColor(Color.white);
      g.drawImage(erin, game.getP1().getX(), game.getP1().getY(), null);
      g.drawString(game.getItems() + " Computers", game.getP1().getX()+10, game.getP1().getY()-10);
      for(int i = 0; i<game.getHealth(); i++){
        g.drawImage(life, game.getP1().getX()+ 10 + (20*i) , game.getP1().getY()-5, null);
      }
      g.drawImage(mateen, game.getP2().getX(), game.getP2().getY(), null);
      g.drawString(game.getItems2() + " Computers", game.getP2().getX()+10, game.getP2().getY()-10);
      for(int i = 0; i<game.getHealth2(); i++){
        g.drawImage(life, game.getP2().getX()+ 10 + (20*i) , game.getP2().getY()-5, null);
      }

  	}

    public void poll() throws Exception {

      Socket serverSocket = new Socket("localhost", 8080);

      try {

        out = new ObjectOutputStream(serverSocket.getOutputStream());
        in = new ObjectInputStream(serverSocket.getInputStream());

        while (true) {
          game = (Game) in.readObject();
          repaint();
        }

      } catch (Exception e) {

      }
    }


  private void sendGame() {
		try {
			out.reset();
			out.writeObject(game);
		} catch (Exception err) {
			System.out.println(err);
		}

    repaint();
	}

  public void check(){
    int x = game.getP2().getX();
    int y = game.getP2().getY();
    Location current = new Location((x/100), (y/100));
    Item item = game.getGrid().get(current);
    if(item!= null){
      if(item.toString().equals("Computer")){
        game.collect2();
        game.removeItem(current);
        playSound("sounds/collect.wav");
      } else if(item.toString().equals("Desk")){
        game.getP2().hitObstacle();
        playSound("sounds/lose.wav");
      } else if(item.toString().equals("Bomb")){
        game.getP1().hitObstacle();
        playSound("sounds/lose.wav");
        game.removeItem(current);
      }
    }
    sendGame();


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
      game.moveUp2();
      check();
    }else if (e.getKeyCode()==40){//Down Arrow
      game.moveDown2();
      check();
    } else if ( e.getKeyCode() == 39 ) { //right
      game.moveRight2();
      check();
    }else if (e.getKeyCode()==37){//left Arrow
      game.moveLeft2();
      check();
    } else if (e.getKeyCode()==32){
      if(bombs<5){
        bombs++;
        int x = game.getP1().getX();
        int y = game.getP1().getY();
        Location current = new Location((x/100), (y/100));
        game.putBomb(current);
      }
    }

    sendGame();
    repaint();
  }


  public void keyReleased(KeyEvent e){  }

  public void keyTyped(KeyEvent e){}



  public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame("Client");
    Client client = new Client();

    frame.add(client);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    client.poll();
  }





}
