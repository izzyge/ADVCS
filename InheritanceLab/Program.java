import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class Program extends JPanel implements ActionListener{
  private ArrayList<Employee> employees;
  private DrawString ds;
  private JButton sortBanker;
  private JButton sortEngineer;
  private JButton sortTeacher;
  private JButton sortPolice;
  private JButton sortAll;
  private JButton d1, d2, d3, d4, d5, d6, d7, d8;
  private JButton search;
  private JTextField searchInput;

  private int show;
  Employee empty;
  Font font;
  public Program(){
    setLayout(null);
    employees = new ArrayList<Employee>();

    employees.add(new Banker("Alex", "imgs/Alex.png", "JPMorgan"));
    employees.add(new Banker("Allie", "imgs/Allie.png", "Chase"));
    employees.add(new Engineer("Dion", "imgs/Dion.png", "Apple"));
    employees.add(new Engineer("Shawn", "imgs/Shawn.png", "Google"));
    employees.add(new Teacher("Ly", "imgs/Ly.png", "MountainView"));
    employees.add(new Teacher("Clotilde", "imgs/Clotilde.png", "MountainView"));
    employees.add(new Police("John", "imgs/John.png", "LosAltos"));
    employees.add(new Police("Sophie", "imgs/Sophie.png", "PaloAlto"));
    empty = new Government("Deleted","imgs/Empty.png","","");
    show = 0;

    searchInput = new JTextField();
    searchInput.setBounds(50,550,200,30);
    this.add(searchInput);

    search = new JButton("Search");
    search.setBounds(300,550,100,30);
    search.addActionListener(this);
    this.add(search);

    sortBanker = new JButton("Bankers Only");
    sortBanker.setBounds(50,30,120,30);
    sortBanker.addActionListener(this);
    this.add(sortBanker);

    sortEngineer = new JButton("Engineers Only");
    sortEngineer.setBounds(200,30,120,30);
    sortEngineer.addActionListener(this);
    this.add(sortEngineer);

    sortTeacher = new JButton("Teachers Only");
    sortTeacher.setBounds(350,30,120,30);
    sortTeacher.addActionListener(this);
    this.add(sortTeacher);

    sortPolice = new JButton("Police Only");
    sortPolice.setBounds(500,30,120,30);
    sortPolice.addActionListener(this);
    this.add(sortPolice);

    sortAll = new JButton("Show All");
    sortAll.setBounds(650,30,120,30);
    sortAll.addActionListener(this);
    this.add(sortAll);

    d1 = new JButton("X");
    d1.setBounds(20, 100 ,30,30);
    d1.addActionListener(this);
    this.add(d1);

    d2 = new JButton("X");
    d2.setBounds(220, 100 ,30,30);
    d2.addActionListener(this);
    this.add(d2);

    d3 = new JButton("X");
    d3.setBounds(420, 100 ,30,30);
    d3.addActionListener(this);
    this.add(d3);

    d4 = new JButton("X");
    d4.setBounds(620, 100 ,30,30);
    d4.addActionListener(this);
    this.add(d4);

    d5 = new JButton("X");
    d5.setBounds(20, 300 ,30,30);
    d5.addActionListener(this);
    this.add(d5);

    d6 = new JButton("X");
    d6.setBounds(220, 300 ,30,30);
    d6.addActionListener(this);
    this.add(d6);

    d7 = new JButton("X");
    d7.setBounds(420, 300 ,30,30);
    d7.addActionListener(this);
    this.add(d7);

    d8 = new JButton("X");
    d8.setBounds(620, 300 ,30,30);
    d8.addActionListener(this);
    this.add(d8);

    setFocusable(true);
    font = new Font("Arial", Font.PLAIN, 50);
  }

  public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
    if(show!=0){
      d1.setVisible(false);
      d2.setVisible(false);
      d3.setVisible(false);
      d4.setVisible(false);
      d5.setVisible(false);
      d6.setVisible(false);
      d7.setVisible(false);
      d8.setVisible(false);

    }

    if(show == 0){
      d1.setVisible(true);
      d2.setVisible(true);
      d3.setVisible(true);
      d4.setVisible(true);
      d5.setVisible(true);
      d6.setVisible(true);
      d7.setVisible(true);
      d8.setVisible(true);
      for(int i = 0; i<8; i++){
        if(i<4){
          employees.get(i).drawPhoto(g, 50+ (200*i),100);
          ds.drawText(employees.get(i).toString(), font, g, 200, 55+ (200*i), 220);
        } else if(i>=4){
          employees.get(i).drawPhoto(g, 50+ (200*(i-4)),300);
          ds.drawText(employees.get(i).toString(), font, g, 200, 55+ (200*(i-4)), 420);
        }
      }
    } else if(show == 1){
      for(int i = 0; i<2; i++){
        employees.get(i).drawPhoto(g, 50+ (200*i),100);
        ds.drawText(employees.get(i).toString(), font, g, 200, 55+ (200*i), 220);
      }
    } else if(show == 2){
      for(int i = 2; i<4; i++){
        employees.get(i).drawPhoto(g, 50+ (200*(i-2)),100);
        ds.drawText(employees.get(i).toString(), font, g, 200, 55+ (200*(i-2)), 220);
      }
    } else if(show == 3){
      for(int i = 4; i<6; i++){
        employees.get(i).drawPhoto(g, 50+ (200*(i-4)),100);
        ds.drawText(employees.get(i).toString(), font, g, 200, 55+ (200*(i-4)), 220);
      }
    } else if(show == 4){
      for(int i = 6; i<8; i++){
        employees.get(i).drawPhoto(g, 50+ (200*(i-6)),100);
        ds.drawText(employees.get(i).toString(), font, g, 200, 55+ (200*(i-6)), 220);
      }
    } else if(show == 5){
        for(int i=0; i<employees.size(); i++){
          if(employees.get(i).getName().equals(searchInput.getText())){
            employees.get(i).drawPhoto(g, 50,100);
            ds.drawText(employees.get(i).toString(), font, g, 200, 55, 220);
          }
        }
    }



  }


  public void actionPerformed(ActionEvent e){
		if(e.getSource() == sortBanker){
      show = 1;
    } else if(e.getSource() == sortEngineer){
      show = 2;
    } else if(e.getSource() == sortTeacher){
      show = 3;
    } else if(e.getSource() == sortPolice){
      show = 4;
    } else if(e.getSource() == sortAll){
      show = 0;
    } else if(e.getSource() == d1){
      employees.set(0,empty);
    } else if(e.getSource() == d2){
      employees.set(1,empty);
    } else if(e.getSource() == d3){
      employees.set(2,empty);
    } else if(e.getSource() == d4){
      employees.set(3,empty);
    } else if(e.getSource() == d5){
      employees.set(4,empty);
    } else if(e.getSource() == d6){
      employees.set(5,empty);
    } else if(e.getSource() == d7){
      employees.set(6,empty);
    } else if(e.getSource() == d8){
      employees.set(7,empty);
    } else if(e.getSource() == search){
      String nameSearch = searchInput.getText();
      for(int i = 0; i<employees.size(); i++){
        if(employees.get(i).getName().equals(nameSearch)){
          show = 5;
        }
      }
    }

		repaint();
  }
}
