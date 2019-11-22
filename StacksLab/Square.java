import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;


public class Square{
  int red;
  int green;
  int blue;
  Color color;

  public Square(int red, int green, int blue){
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.color = new Color(red, green, blue);
  }

  public void drawMe(Graphics g, int x,int y){
    g.setColor(new Color(red, green, blue));
    g.fillRect(x,y,35,35);

    g.setColor(Color.black);
    g.drawRect(x,y, 35,35);

  }

  public void changeColor(int red, int green, int blue){
    this.red = red;
    this.green = green;
    this.blue = blue;

  }

  public int returnRed(){
    return red;
  }

  public int returnGreen(){
    return green;
  }

  public int returnBlue(){
    return blue;
  }

  public Square clone() {
		Square temp = new Square(returnRed(), returnGreen(), returnBlue());

		return temp;
	}


}
