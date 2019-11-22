import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


  public class Screen extends JPanel implements MouseListener, ActionListener{
    private Square[][] grid, palette;
    private JButton clear, undo, redo;
    private int red;
    private int green;
    private int blue;
    private Stack<Square[][]> stack, stack2;

    public Screen(){
      this.setLayout(null);
      grid = new Square[16][16];
      palette = new Square[12][3];
      stack = new Stack<>();
      stack2 = new Stack<>();
      this.setFocusable(true);
      addMouseListener(this);

      clear = new JButton("Clear");
  		clear.setBounds(635,480,100,20);
  		clear.addActionListener(this);
  	  add(clear);

      undo = new JButton("Undo");
      undo.setBounds(635, 510, 100, 20);
      undo.addActionListener(this);
      add(undo);

      redo = new JButton("Redo");
      redo.setBounds(635, 540, 100, 20);
      redo.addActionListener(this);
      add(redo);

      for(int r=0; r<grid.length; r++){
        for(int c=0; c<grid[r].length; c++){
          grid[r][c] = new Square(255,255,255);
        }
      }

      for(int r=0; r<palette.length; r++){
        for(int c=0; c<palette[r].length; c++){
          palette[r][c] = new Square(255,255,255);
        }
      }

     addToStack();


    }

    public Dimension getPreferredSize(){
      return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
      super.paintComponent(g);
      int x = 15;
      int y = 15;
      for(int r=0; r<grid.length; r++){
        for(int c=0; c<grid[r].length; c++){
          grid[r][c].drawMe(g,x,y);
          x+=35;
        }
        x=15;
        y+=35;
      }
      //165 by 455


      g.setColor(Color.gray);
      g.fillRect(575,14,210,561);

      x = 630;
      y = 50;
      int count = 1;
      for(int r=0; r<palette.length; r++){
        for(int c=0; c<palette[r].length; c++){

            if(count == 1)
              palette[r][c].changeColor(255, 0, 0);
            else if(count == 2)
              palette[r][c].changeColor(135, 1, 1);
            else if(count == 3)
              palette[r][c].changeColor(255, 114, 114);
            else if(count == 4)
              palette[r][c].changeColor(255, 97, 0);
            else if(count == 5)
              palette[r][c].changeColor(186, 89, 0);
            else if(count ==6)
              palette[r][c].changeColor(249, 205, 134);
            else if(count == 7)
              palette[r][c].changeColor(255, 233, 0);
            else if(count == 8)
              palette[r][c].changeColor(150, 137, 0);
            else if(count == 9)
              palette[r][c].changeColor(255, 245, 142);
            else if(count == 10)
              palette[r][c].changeColor(2, 255, 15);
            else if(count == 11)
              palette[r][c].changeColor(0, 119, 6);
            else if(count == 12)
              palette[r][c].changeColor(183, 255, 187);
            else if(count == 13)
              palette[r][c].changeColor(0, 255, 242);
            else if(count == 14)
              palette[r][c].changeColor(0, 130, 123);
            else if(count == 15)
              palette[r][c].changeColor(135, 255, 248);
            else if(count == 16)
              palette[r][c].changeColor(0, 33, 255);
            else if(count == 17)
              palette[r][c].changeColor(0, 19, 150);
            else if(count == 18)
              palette[r][c].changeColor(132, 148, 255);
            else if(count == 19)
              palette[r][c].changeColor(110, 0, 255);
            else if(count == 20)
              palette[r][c].changeColor(46, 0, 107);
            else if(count == 21)
              palette[r][c].changeColor(186, 135, 255);
            else if(count == 22)
              palette[r][c].changeColor(216, 0, 255);
            else if(count == 23)
              palette[r][c].changeColor(103, 0, 122);
            else if(count == 24)
              palette[r][c].changeColor(235, 132, 255);
            else if(count == 25)
              palette[r][c].changeColor(255, 0, 170);
            else if(count == 26)
              palette[r][c].changeColor(142, 0, 95);
            else if(count == 27)
              palette[r][c].changeColor(255, 153, 221);
            else if(count == 28)
              palette[r][c].changeColor(0, 0, 0);
            else if(count == 29)
              palette[r][c].changeColor(53, 53, 53);
            else if(count == 30)
              palette[r][c].changeColor(89, 89, 89);
            else if(count == 31)
              palette[r][c].changeColor(255, 255, 255);
            else if(count == 32)
              palette[r][c].changeColor(119, 119, 119);
            else if(count == 33)
              palette[r][c].changeColor(196, 196, 196);
            else if(count == 34)
              palette[r][c].changeColor(66, 28, 0);
            else if(count == 35)
              palette[r][c].changeColor(122, 72, 35);
            else if(count == 36)
              palette[r][c].changeColor(204, 153, 116);





          palette[r][c].drawMe(g,x,y);
          x+=35;
          count++;
        }
        x=630;
        y+=35;
      }
    }

    public void actionPerformed(ActionEvent e){
      if(e.getSource() == clear){
        for(int r=0; r<grid.length; r++){
          for(int c=0; c<grid[r].length; c++){
            grid[r][c].changeColor(255,255,255);
          }
        }
        addToStack();
      } else if(e.getSource() == undo){
        if(stack.size() >1){
          stack2.push(stack.pop());
          cloneGrid(stack.peek());
        }
      } else if(e.getSource() == redo){
        if(stack2.size() >0){
          cloneGrid(stack2.peek());
          stack.push(stack2.pop());
        }

      }


      repaint();
    }

    public void mousePressed(MouseEvent e) {

        //Print location of x and y
        System.out.println("X: " + e.getX() + ", Y: " + e.getY());

        if(e.getX()< 620){
          grid[((e.getY()-15)/35)][((e.getX()-15)/35)].changeColor(red,green,blue);
          addToStack();
        } else if(e.getX() > 630 && e.getY() > 50){
          red = palette[((e.getY()-50)/35)][((e.getX()-650)/35)].returnRed();
          green = palette[((e.getY()-50)/35)][((e.getX()-650)/35)].returnGreen();
          blue = palette[((e.getY()-50)/35)][((e.getX()-650)/35)].returnBlue();
        }

        repaint();
    }

    public void addToStack(){
      Square[][] newCopy = new Square[16][16];
      for(int r=0; r<grid.length; r++){
      	for(int c=0; c<grid[r].length; c++){
      		newCopy[r][c] = new Square(grid[r][c].returnRed(), grid[r][c].returnGreen(), grid[r][c].returnBlue());
      	}
      }
      stack.push(newCopy);

    }

    private void cloneGrid(Square[][] squareGrid) {

  		for (int r = 0; r < squareGrid.length; r++) {
  			for (int c = 0; c < squareGrid[0].length; c++) {
  				grid[r][c] = squareGrid[r][c].clone();
  			}
  		}
      repaint();
	  }


    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

  }
