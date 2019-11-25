import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.*;



public class Game implements Serializable{
   private int[][] table;
   private String turn;
   private boolean win1;
   private boolean win2;
   private int wins1, wins2;

   public Game() {
     table = new int[3][3];
     for(int r = 0; r < table.length; r++) {
       for(int c = 0; c < table[r].length; c++) {
         table[r][c] = 0;
       }
     }
     resettable();

     win1 = false;
     win2 = false;
   }

   public boolean checkFull() {
     boolean full = true;
     for(int[] row : table) {
       for(int item : row) {
         if(item == 0) full = false;
       }
     }

     return full;
   }

   public void checkWin(){
     if(checkTicTacToe() == 1){
      wins1++;
      resettable();
    } else if(checkTicTacToe() == -1){
      wins2++;
      resettable();
    }
   }

   public boolean makeMove(int r, int c) {

  		if (table[r][c] != 0)
  			return false;

  		if (turn.equals("server")) {
  			table[r][c] = 1;
  			turn = "client";
  		} else if (turn.equals("client")) {
  			table[r][c] = -1;
  			turn = "server";
  		}

  		return true;

	 }

   public void win(int player){
     // Sound.playSound("sound/win.wav");
     if(player == 1){
       win1 = true;
       wins1++;
     }
     else if (player == 2){
       win2 = true;
       wins2++;
     }

   }

   public void clear(){
     for(int r = 0; r<3; r++){
       for(int c = 0; c<3; c++){
          table[r][c] = 0;
       }
     }
     win1 = false;
     win2 = false;
   }

   public int getBoardAt(int r, int c){
     return table[r][c];
   }

   /*public void drawMe(Graphics g){
     Font font = new Font("Arial", Font.PLAIN, 100);
     g.setFont(font);
     g.setColor(Color.blue);
     g.fillRect(0,0,800,600);
     g.setColor(Color.white);
     g.fillRect(200, 50, 10, 450);
     g.fillRect(350, 50, 10, 450);
     g.fillRect(50, 200, 450, 10);
     g.fillRect(50, 350, 450, 10);
     g.setFont(new Font("Arial", Font.PLAIN, 50));
     g.drawString("P1: " + wins1, 20,550);
     g.drawString("P2: " + wins2, 220,550);
     g.setFont(font);
     for(int r = 0; r<3; r++){
       for(int c = 0; c<3; c++){
         if(table[r][c] == 1){
          g.setColor(Color.white);
          g.drawString("X", 160 * c + 80, 160 * r + 140 );
        } else if(table[r][c] == 2){
         g.setColor(Color.white);
         g.drawString("O", 160 * c + 80, 160 * r + 140 );
       }
       }
     }

     g.setColor(Color.white);
     g.setFont(new Font("Arial", Font.PLAIN, 30));
     if(win1 == true)
      g.drawString("Player 1 Wins", 600,500);
     if(win2 == true)
      g.drawString("Player 2 Wins", 600,500);
     if(checkFull() == true && win1 == false && win2 == false){
      g.drawString("Tie", 600,500);
      Sound.playSound("sound/tie.wav");
     }
   }*/

   public int checkTicTacToe(){

        if(table[0][0] == 1 && table[0][1] == 1 && table[0][2] == 1)
          return 1;
        if(table[1][0] == 1 && table[1][1] == 1 && table[1][2] == 1)
          return 1;
        if(table[2][0] == 1 && table[2][1] == 1 && table[2][2] == 1)
          return 1;
        if(table[0][0] == 1 && table[1][0] == 1 && table[2][0] == 1)
          return 1;
        if(table[0][1] == 1 && table[1][1] == 1 && table[2][1] == 1)
          return 1;
        if(table[0][2] == 1 && table[1][2] == 1 && table[2][2] == 1)
          return 1;
        if(table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1)
          return 1;
        if(table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 1)
          return 1;

        if(table[0][0] == -1 && table[0][1] == -1 && table[0][2] == -1)
          return -1;
        if(table[1][0] == -1 && table[1][1] == -1 && table[1][2] == -1)
          return -1;
        if(table[2][0] == -1 && table[2][1] == -1 && table[2][2] == -1)
          return -1;
        if(table[0][0] == -1 && table[1][0] == -1 && table[2][0] == -1)
          return -1;
        if(table[0][1] == -1 && table[1][1] == -1 && table[2][1] == -1)
          return -1;
        if(table[0][2] == -1 && table[1][2] == -1 && table[2][2] == -1)
          return -1;
        if(table[0][0] == -1 && table[1][1] == -1 && table[2][2] == -1)
          return -1;
        if(table[0][2] == -1 && table[1][1] == -1 && table[2][0] == -1)
          return -1;

        if(checkFull() == true)
          return 2;




      return 0;
   }

   public void resettable() {
  		for (int r = 0; r < table.length; r++) {
  			for (int c = 0; c < table[r].length; c++) {
  				table[r][c] = 0;
  			}
  		}
      turn = "server";
   }

    public boolean isMyTurn(String player){
      return player.equals(turn);
    }

    public int getServerWins() {
		return wins1;
	}

	public int getClientWins() {
		return wins2;
	}
}
