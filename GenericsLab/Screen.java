import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Screen extends JPanel implements ActionListener{
    private ArrayList<Pair<Student, Schedule>> students = new ArrayList<Pair<Student, Schedule>>();
    private JButton search;
    private JTextField input;
    private JButton[] btns;
    private boolean display;
    private int current;
    private Font font;
    private JButton backButton;
  	private JButton deletePeriodButton;
    private JTextField courseInput;
    private JTextField periodInput;
  	private JButton addClass;

    public Screen(){
      this.setLayout(null);

      display = true;
      current = 0;


      input = new JTextField();
      input.setBounds(50, 50, 200, 30);
      this.add(input);

      courseInput = new JTextField();
      courseInput.setBounds(50, 450, 200, 30);
      courseInput.setText("Class Name");
      this.add(courseInput);
      courseInput.setVisible(false);

      periodInput = new JTextField();
      periodInput.setBounds(300, 450, 200, 30);
      periodInput.setText("Period Num");
      this.add(periodInput);
      periodInput.setVisible(false);


      search = new JButton("Search");
      search.setBounds(300, 50, 100, 30);
      search.addActionListener(e -> {
			  for (int i = 0; i < students.size(); i++) {
				  if (students.get(i).getK().getName().equals(input.getText())) {
  					current = i+1;
  					input.setText("");
  					break;
  				}
  			}

  			input.setText("");
  		});
      this.add(search);

      backButton = new JButton("Back");
      backButton.setBounds(50,500,100,30);
      backButton.addActionListener(e -> {
        showAllStudents(true);
        courseInput.setVisible(false);
        periodInput.setVisible(false);
      });
      this.add(backButton);

      deletePeriodButton = new JButton("Delete period");
      deletePeriodButton.setBounds(300,50,130,30);
      deletePeriodButton.addActionListener(e -> {
        students.get(current-1).getV().deletePeriod(Integer.parseInt(input.getText()));
			  input.setText("");
			  this.repaint();
      });
      this.add(deletePeriodButton);

      addClass = new JButton("Add Class");
      addClass.setBounds(520,450,100,30);
      addClass.addActionListener(e -> {
        students.get(current-1).getV().addClass(Integer.parseInt(periodInput.getText()), courseInput.getText());
			  periodInput.setText("");
        courseInput.setText("");
			  this.repaint();
      });
      this.add(addClass);


      Schedule izzyg = new Schedule();
  		izzyg.addClass(1, "Adv Comp Sci");
  		izzyg.addClass(2, "French 5 Honors");
  		izzyg.addClass(3, "AP Calc BC");

  		Schedule erinc = new Schedule();
  		erinc.addClass(1, "Adv Comp Sci");
      erinc.addClass(2, "ASB");
  		erinc.addClass(3, "APUSH");

  		Schedule mateens = new Schedule();
  		mateens.addClass(1, "Adv Comp Sci");
  		mateens.addClass(2, "Am Lit");
  		mateens.addClass(3, "AP Physics 1");

  		students.add(new Pair<Student, Schedule>(new Student("Izzy Ge", "imgs/izzy.png"), izzyg));
  		students.add(new Pair<Student, Schedule>(new Student("Erin Coyne", "imgs/erin.png"), erinc));
  		students.add(new Pair<Student, Schedule>(new Student("Mateen Shagagi", "imgs/mateen.png"), mateens));


      this.btns = new JButton[students.size()];
      for(int i = 0; i<btns.length; i++){
        btns[i] = new JButton("See Schedule");
        btns[i].setBounds(50+(250*i), 350, 100, 20);
        btns[i].addActionListener(this);
        this.add(btns[i]);
      }

      font = new Font("Arial", Font.PLAIN, 50);




      this.showAllStudents(true);
      this.setFocusable(true);


    }

    public Dimension getPreferredSize(){
        //Sets the size of the panel
      return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(new Color(100, 100, 100));
      g.fillRect(0,0,800,600);
      g.setColor(Color.black);
      if(display == true){
        for(int i = 0; i<students.size(); i++){
          students.get(i).getK().drawStudent(g, 50+(250*i), 200);
          g.drawString(students.get(i).getK().getName(), 50+(250*i), 190);

        }
      }



      if(current > 0){
        showAllStudents(false);
        showStudent(current-1,g);

      }



    }

	public void showAllStudents(boolean bool) {
    display = bool;

    for(int i =0; i<btns.length; i++){
      btns[i].setVisible(bool);
    }
    search.setVisible(bool);
    deletePeriodButton.setVisible(false);
    backButton.setVisible(false);

    addClass.setVisible(false);
    if(bool == true)
      current = 0;






	}

  public void showStudent(int i, Graphics g){
    display = false;
    students.get(i).getK().drawStudent(g, 50, 200);
    g.drawString(students.get(i).getK().getName(), 50, 190);
    g.drawString(students.get(i).getV().toString(),50, 310);
    deletePeriodButton.setVisible(true);
    backButton.setVisible(true);
    addClass.setVisible(true);



  }

    public void actionPerformed(ActionEvent e) {
      if( e.getSource() == btns[0]){
        current = 1;
        courseInput.setVisible(true);
        periodInput.setVisible(true);
      } else if( e.getSource() == btns[1]){
        current = 2;
        courseInput.setVisible(true);
        periodInput.setVisible(true);
      } else if( e.getSource() == btns[2]){
        current = 3;
        courseInput.setVisible(true);
        periodInput.setVisible(true);
      }
  }

}
