import java.util.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
public class Player{
  private int x, y, width, height;
  public Player(){
    x = 400;
    y = 400;
    width = 70;
    height = 70;
  }

  public int getX(){ return x; }
	public int getY(){ return y; }
  public int getWidth(){ return width; }
  public int getHeight(){ return height; }

  public void moveRight(){
    if(x<700)
      x+=100;
  }

  public void moveLeft(){
    if(x>50)
      x-=100;
  }

  public void moveDown(){
    if(y<650)
      y+=100;
  }

  public void moveUp(){
    if(y>50)
      y-=100;
  }

}
