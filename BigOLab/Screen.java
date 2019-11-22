import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Screen extends JPanel implements ActionListener{
  private ArrayList<Student> students;
  private JTextArea textArea;
  private JTextField searchInput;
  private JButton binaryButton, showAllButton, sequentialButton, scramble, bubbleSort, mergeSort;
  private JScrollPane scrollPane;
  private String text;
  private Search search;
  public Screen(){

    this.setLayout(null);
    students= new ArrayList<Student>();
    search = new Search();

    students = new ArrayList<Student>();

    try {
      Scanner in = new Scanner(new File("names.txt"));

      while (in.hasNextLine()) {

        String line = in.nextLine();
        String[] name = line.split("\\s+");

        ListIterator<Student> it = students.listIterator();
        Student stu = new Student(name[0], name[1], (int)((Math.random() * 4) + 14));


        while (it.hasNext()) {
          if (it.next().toString().compareTo(stu.toString()) > 0) {
            it.previous();
            break;
          }
        }

        it.add(stu);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }


   showList();

   searchInput = new JTextField();
   searchInput.setBounds(50, 500, 200, 30);
   searchInput.setText("Search Last Name");
   this.add(searchInput);

   binaryButton = new JButton("Binary Search");
   binaryButton.setBounds(50, 525, 150, 30);
   binaryButton.addActionListener(e -> {
     int ind = search.binarySearch(students, searchInput.getText(), 0, students.size()-1);
     searchInput.setText("");
     if(ind != -1)
       textArea.setText(ind + ". " + students.get(ind- 1).toString());
     else
       textArea.setText("No Results");
    // System.out.println(searchInput.getText());
    // System.out.println(ind);
     this.repaint();
   });
   this.add(binaryButton);

  sequentialButton = new JButton("Sequential Search");
  sequentialButton.setBounds(250,520,150,30);
  sequentialButton.addActionListener(e -> {
    int ind = search.sequentialSearch(students, searchInput.getText());
    searchInput.setText("");
    if(ind != -1)
      textArea.setText(ind + ". " + students.get(ind- 1).toString());
    else
      textArea.setText("No Results");
    this.repaint();
  });
  this.add(sequentialButton);

  scramble = new JButton("Scramble");
  scramble.setBounds(450,520,150,30);
  scramble.addActionListener(e ->{
    int index;
		Student temp;

		for (int i = 0; i < students.size(); i++) {

			index = (int)(Math.random() * students.size());
			temp = students.get(index);
			students.set(index, students.get(i));
			students.set(i, temp);

		}
    textArea.setText(search.toString(students));
    this.repaint();
  });
  this.add(scramble);

  bubbleSort = new JButton("Bubble Sort");
  bubbleSort.setBounds(450,560,150,30);
  bubbleSort.addActionListener(e ->{
    students = search.bubbleSort(students);
    textArea.setText(search.toString(students));
    this.repaint();
  });
  this.add(bubbleSort);

  mergeSort = new JButton("Merge Sort");
  mergeSort.setBounds(250,560,150,30);
  mergeSort.addActionListener(e ->{
    students = search.mergeSort(students,0, students.size());
    textArea.setText(search.toString(students));
    this.repaint();
  });
  this.add(mergeSort);


   showAllButton = new JButton("Show all");
	 showAllButton.addActionListener(e -> {
		 textArea.setText(search.toString(students));
	 });
	 showAllButton.setBounds(700, 520, 90, 30);
	 this.add(showAllButton);



    textArea = new JTextArea();
    textArea.setText(text);
    scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBounds(0,0,800,500);
    this.add(scrollPane);

    this.setFocusable(true);
  }

  public Dimension getPreferredSize(){
      //Sets the size of the panel
    return new Dimension(800,600);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    if (search.getCalls() > 0) {
			g.drawString("Passes: " + search.getCalls(), 300, 520);
		}
  }

  private void drawString(Graphics g, String text, int x, int y) {
    for (String line : text.split("\n")) {
      g.drawString(line, x, y);
      y += g.getFontMetrics().getHeight();
    }
  }

  private void showList(){
    for(int i = 0; i<students.size(); i++){
      text += (i+1) + ". " + students.get(i).toString() + "\n";

    }
  }

  public void actionPerformed(ActionEvent e) {
    //if( e.getSource() == btns[0]){
  }

}
