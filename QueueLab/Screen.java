import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Screen extends JPanel implements ActionListener{
  private PriorityQueue<Patient> patients;
  private Queue<Patient> dischargedPatients;
  private JTextField nameField, illnessField, searchField, updIllnessField, treatmentField;
  private JComboBox<String> priorityField, ageField, updPriorityField;
  private JButton enter, search, updIllness, updPriority, discharge;
  private String currSearch;
  private Patient currPat = new Patient("");
  private String[] priorities = { "High", "Medium", "Low"};
  private Patient docPat;
  int initTime;
  public Screen(){
    this.setLayout(null);
    patients = new PriorityQueue<Patient>();
    dischargedPatients = new LinkedList<Patient>();
    patients.add(new Patient("Sam","Flu",2,"Adult",1004,""));
    patients.add(new Patient("Owen","Broken Arm",1,"Child",1005,""));
    patients.add(new Patient("Glenda","Fever",3,"Adult",1002,""));
    initTime = 1007;
    currSearch = "";
    docPat = patients.peek();

    nameField = new JTextField();
    nameField.setText("Name");
    nameField.setBounds(50,80,150,30);
    this.add(nameField);


    illnessField = new JTextField();
    illnessField.setText("Illness");
    illnessField.setBounds(50,120,150,30);
    this.add(illnessField);

    priorityField = new JComboBox<String>(priorities);
    priorityField.setBounds(50,160,150,30);
    this.add(priorityField);

    String[] ages = { "Child", "Adult"};
    ageField = new JComboBox<String>(ages);
    ageField.setBounds(50,200,150,30);
    this.add(ageField);

    enter = new JButton("Enter Patient");
    enter.setBounds(50, 240, 150, 30);
    enter.addActionListener(e -> {
      int pri = 0;
      for(int i = 0; i<priorities.length; i++){
        if(priorities[i].equals((String)priorityField.getSelectedItem()))
          pri = i+1;
      }
      Patient p = new Patient(nameField.getText(), illnessField.getText(), pri, (String)ageField.getSelectedItem(), initTime, "");
      patients.add(p);
      initTime += 3;
      repaint();
    });
    this.add(enter);

    searchField = new JTextField();
    searchField.setText("Search by Name");
    searchField.setBounds(250, 40, 150,30);
    this.add(searchField);

    search = new JButton("Search Patient");
    search.setBounds(250,80,150,30);
    search.addActionListener(e -> {
      Iterator it = patients.iterator();
      Patient srch = new Patient(searchField.getText());
      if(patients.contains(srch)){
        while(it.hasNext()){
          Patient nextP = (Patient)it.next();
          if(nextP.equals(srch))
            currPat = nextP;
        }
      }
      currSearch = currPat.toString();
      repaint();
    });
    this.add(search);

    updIllnessField = new JTextField();
    updIllnessField.setText("Illness");
    updIllnessField.setBounds(250, 120, 150,30);
    this.add(updIllnessField);

    updIllness = new JButton("Update Illness");
    updIllness.setBounds(250,160,150,30);
    updIllness.addActionListener(e -> {
      currPat.updIllness(updIllnessField.getText());
      repaint();
    });
    this.add(updIllness);

    updPriorityField = new JComboBox<String>(priorities);
    updPriorityField.setBounds(250,200,150,30);
    this.add(updPriorityField);

    updPriority = new JButton("Update Priority");
    updPriority.setBounds(250,240,150,30);
    updPriority.addActionListener(e -> {
      patients.remove(currPat);
      int pri = 0;
      for(int i = 0; i<priorities.length; i++){
        if(priorities[i].equals((String)updPriorityField.getSelectedItem()))
          pri = i+1;
      }
      currPat.updPriority(pri);
      patients.add(currPat);
      repaint();
    });
    this.add(updPriority);

    treatmentField = new JTextField();
    treatmentField.setText("Treatment");
    treatmentField.setBounds(450, 130, 150,30);
    this.add(treatmentField);

    discharge = new JButton("Discharge Patient");
    discharge.setBounds(450,170,150,30);
    discharge.addActionListener(e -> {
      docPat.updNote(treatmentField.getText());
      patients.poll();
      dischargedPatients.add(docPat);
      if(!patients.isEmpty())
      docPat = patients.peek();
      repaint();
    });
    this.add(discharge);






    this.setFocusable(true);

  }

  public Dimension getPreferredSize(){
    return new Dimension(800,600);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.gray);
    g.fillRect(430,0,370,600);
    g.setColor(Color.black);
    g.drawString("Nurse View", 50, 50);
    g.drawString("Doctor View", 450,50);
    g.drawString("Current Patient", 450, 80);
    g.drawString(docPat.toString(), 450, 100);

    Iterator it = patients.iterator();
    int i = 0;
    while(it.hasNext()){
      g.drawString(it.next().toString(), 50, 300 + (20*i));
      i++;
    }

    g.drawString("Discharged Patients:", 450, 220);
    Iterator qIt = dischargedPatients.iterator();
    i = 0;
    while(qIt.hasNext()){
      Patient q = (Patient)qIt.next();
      g.drawString(q.getName() + ": " + q.getNote(), 450, 250 + (30 * i));
      i++;
    }

    g.drawString(currSearch, 360, 160);
  }

  public void actionPerformed(ActionEvent e) {}



}
