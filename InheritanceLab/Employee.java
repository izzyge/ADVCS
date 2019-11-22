import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Employee{
  private String name;
  private String photoFile;
  private String jobTitle;
  private BufferedImage img;

  public Employee(String n, String p, String j){
    name = n;
    photoFile = p;
    jobTitle = j;
    try {
        img = ImageIO.read(new File(photoFile));
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  public abstract double getSalary();

  public void drawPhoto(Graphics g, int x, int y){
    g.drawImage(img, x, y, 100, 100, null);
  }

  public String toString(){
    return "Name:" + name + " Job:" + jobTitle + " Salary:" + getSalary();
  }

  public String getName(){
    return name;
  }

}
