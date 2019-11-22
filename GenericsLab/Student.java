import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Student{
  private String name;
  private String imageFile;
  private BufferedImage img;

  public Student(String name, String imageFile){
    this.name = name;
    this.imageFile = imageFile;
    try {
        img = ImageIO.read(new File(imageFile));
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  public void drawStudent(Graphics g, int x, int y){
    g.drawImage(img, x, y, 100, 100, null);
  }

  public String getName(){
    return name;
  }
}
