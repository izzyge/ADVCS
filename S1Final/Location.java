import java.util.*;
public class Location{
  private int x,y;
  public Location(int x, int y){
    this.x = x;
    this.y = y;
  }

  public boolean equals(Object o){
    Location l = (Location) o;
    if(l.getX()==x && l.getY()==y){
      return true;
    }
    return false;
  }

  public int hashCode(){
    return (int)(Math.pow(x,2) * 11) + (y*17);
  }

  public int getX(){ return x; }
  public int getY(){ return y; }

  
}
