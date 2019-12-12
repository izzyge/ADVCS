import java.util.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Game implements Serializable{
  private HashMap<Location,Item> grid = new HashMap<Location,Item>();
  private Player p1, p2;
  public Game(){
    p1 = new Player();
    p2 = new Player();
    grid.put(new Location(0,0), new Item("Computer"));
    grid.put(new Location(5,0), new Item("Computer"));
    grid.put(new Location(7,0), new Item("Computer"));
    grid.put(new Location(0,1), new Item("Computer"));
    grid.put(new Location(3,1), new Item("Computer"));
    grid.put(new Location(5,3), new Item("Computer"));
    grid.put(new Location(1,4), new Item("Computer"));
    grid.put(new Location(6,4), new Item("Computer"));
    grid.put(new Location(5,5), new Item("Computer"));
    grid.put(new Location(7,6), new Item("Computer"));
    grid.put(new Location(4,7), new Item("Computer"));
    grid.put(new Location(2,0), new Item("Desk"));
    grid.put(new Location(4,1), new Item("Desk"));
    grid.put(new Location(7,1), new Item("Desk"));
    grid.put(new Location(2,2), new Item("Desk"));
    grid.put(new Location(5,2), new Item("Desk"));
    grid.put(new Location(0,3), new Item("Desk"));
    grid.put(new Location(3,4), new Item("Desk"));
    grid.put(new Location(6,5), new Item("Desk"));
    grid.put(new Location(1,6), new Item("Desk"));
    grid.put(new Location(5,7), new Item("Desk"));



  }

  public void putBomb(Location l){
    grid.put(l, new Item("Bomb"));
  }

  public Item getItem(int a, int b){
    return grid.get(new Location(a,b));
  }

  public HashMap<Location,Item> getGrid(){
    return grid;
  }

  public void removeItem(Location location){
    System.out.println();
    grid.put(location, null);
  }

  public Player getP1(){ return p1; }

  public Player getP2(){ return p2; }

  public void moveRight(){ p1.moveRight(); }

  public void moveLeft(){ p1.moveLeft(); }

  public void moveDown(){ p1.moveDown(); }

  public void moveUp(){ p1.moveUp(); }

  public void collect(){ p1.collect(); }

  public void moveRight2(){ p2.moveRight(); }

  public void moveLeft2(){ p2.moveLeft(); }

  public void moveDown2(){ p2.moveDown(); }

  public void moveUp2(){ p2.moveUp(); }

  public void collect2(){ p2.collect(); }

  // public void loseHealth(){ p1.loseHealth(); }
  // public void loseHealth2(){ p2.loseHealth(); }

  public int getHealth(){ return p1.getHealth(); }
  public int getHealth2(){ return p2.getHealth(); }

  public int getItems(){ return p1.getItems(); }
  public int getItems2(){ return p2.getItems(); }
}
