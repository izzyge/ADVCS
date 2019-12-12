import java.util.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
public class Player extends Item implements Serializable{
  private int x, y, width, height, items;
  private Stack<Integer> health;
  private String name;

  public Player(){
    x = 400;
    y = 400;
    width = 70;
    height = 70;
    items = 0;
    health = new Stack<Integer>();
    health.push(1);
    health.push(2);
    health.push(3);
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

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

  public void collect(){
    items++;
  }

  public String getName(){
    return name;
  }

  // public void loseHealth(){
  //   if(health != null && !health.empty())
  //     health.pop();
  //
  // }

  public void hitObstacle(){
    x = 400;
    y = 400;
    if(health != null && !health.empty())
      health.pop();
  }

  public int getHealth(){
    return health.size();
  }

  public int getItems(){
    return items;
  }

}
