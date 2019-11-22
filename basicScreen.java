import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Screen extends JPanel implements ActionListener{
  public Screen(){
    this.setLayout(null);


    this.setFocusable(true);

  }

  public Dimension getPreferredSize(){
    return new Dimension(800,600);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
  }

  public void actionPerformed(ActionEvent e) {}



}
