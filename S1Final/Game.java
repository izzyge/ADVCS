import java.util.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Game implements Serializable{
  private HashMap<Location,Item> grid = new HashMap<Location,Item>();
  public Game(){
    grid.put(new Location(0,0), new Item("Computer"));
    grid.put(new Location(5,0), new Item("Computer"));
    grid.put(new Location(7,0), new Item("Computer"));
    grid.put(new Location(0,1), new Item("Computer"));
    grid.put(new Location(3,1), new Item("Computer"));
    grid.put(new Location(5,3), new Item("Computer"));
    grid.put(new Location(1,4), new Item("Computer"));
    grid.put(new Location(6,4), new Item("Computer"));
    grid.put(new Location(5,5), new Item("Computer"));

  }

  public Item getItem(int a, int b){
    return grid.get(new Location(a,b));
  }

  public HashMap<Location,Item> getGrid(){
    return grid;
  }
}
