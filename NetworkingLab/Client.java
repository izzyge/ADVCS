import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Client extends JPanel implements ActionListener, Serializable{


    int[][] current;
    Game game;
    private Socket conn;
  	private ObjectOutputStream out;
  	private ObjectInputStream in;
    private int wins;
    private JButton reset;


    public Client(){
      this.setLayout(null);

      current = new int[3][3];
      game = new Game();

      wins = 0;

      reset = new JButton("Reset");
      reset.setBounds(640,550,100,30);
      reset.addActionListener(e->{
        game.resettable();
        repaint();
      });
      this.add(reset);

      addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          int x = e.getX();
          int y = e.getY();

          if (x > 20 && x < 620 && y > 20 && y < 620 && game.isMyTurn("client")) {
            int r = (y - 20) / 200;
            int c = (x - 20) / 200;
            if (game.makeMove(r, c)) {
              repaint();
              sendGame();
            }
          }
        }
      });


      this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGameBoard(g);

        int res = checkWin();
        if(res!=0){
    			if (res == -1 ) {
            g.setColor(new Color(247, 163, 163));
            g.fillRect(140, 200, 270,150);
            g.setColor(Color.black);
    				g.drawString("You won!", 150, 300);

    			} else if (res == 1) {
            g.setColor(new Color(157, 204, 235));
            g.fillRect(140, 200, 270,150);
            g.setColor(Color.black);
    				g.drawString("You lost!", 150, 300);

    			} else if (res == 2) {
            g.setColor(new Color(247, 218, 186));
            g.fillRect(140, 200, 250,150);
            g.setColor(Color.black);
    				g.drawString("Draw!", 150, 300);

    			}
        }
        g.drawString("P2: " + wins, 640, 100);

    }

    private void drawGameBoard(Graphics g) {
		// width 600, height 600

  		g.setFont(new Font("Arial", Font.PLAIN, 60));
  		g.setColor(Color.black);
  		for (int r = 0; r < 3; r++) {
  			for (int c = 0; c < 3; c++) {
  				int val = game.getBoardAt(r, c);
  				g.drawRect((200 * c) + 20, (200 * r) + 20, 200, 200);

  				if (val == 1) {
  					g.drawString("X", (200 * c) + 90, (200 * r) + 140);
  				} else if (val == -1) {
  					g.drawString("O", (200 * c) + 90, (200 * r) + 140);
  				}
  			}
  		}
  	}

    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    private void sendGame() {
  		try {
  			out.reset();
  			out.writeObject(game);
  		} catch (Exception err) {
  			System.out.println(err);
  		}
  	}

    public int checkWin(){
      if(game.checkTicTacToe() == -1){
        wins++;
      }
      return game.checkTicTacToe();
    }


    public void poll() throws Exception{

      conn = new Socket("localhost", 8080);

      out = new ObjectOutputStream(conn.getOutputStream());
      in = new ObjectInputStream(conn.getInputStream());

      while (true) {
        game = (Game) in.readObject();
        repaint();
      }
    }

    public void actionPerformed(ActionEvent e) {
    }

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
