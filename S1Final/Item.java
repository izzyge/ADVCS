import java.awt.*;
import java.io.*;

public class Item implements Serializable{
  private String name;

  public Item(String name){
    this.name = name;
  }

  public Item(){
    name = "";
  }

  public String getName(){
    return name;
  }

  // public void checkCollision(Player t){
	// 		int tX = t.getX();
	// 		int tY = t.getY();
	// 		int tWidth = t.getWidth();
	// 		int tHeight = t.getHeight();
  //
	// 		if(tX+tWidth >= x && tX <= x + width
	// 			&&  tY+tHeight >= y && tY <= y + height){
  //
  //
	//      }
  //
	// }

  public String toString(){
    return name;
  }

}
