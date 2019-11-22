import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JPanel implements ActionListener{
    public Font font = new Font("Helvetica", Font.PLAIN, 20);
    private Resume resume;

    private JTextField name1, address, email, objectives, skills;
    private JTextField name2, gradYear, gradMonth;
    private JTextField title, company, startMonth, startYear, endMonth, endYear, description;
    private JButton doneButton, addSchoolButton, addJobButton;
    private int currentScreen;
    private String text;
    private JTextArea textArea;
    private JScrollPane scrollPane;


    public Screen(){
      this.setLayout(null);
      resume = new Resume();
      currentScreen = 1;

      scrollPane = new JScrollPane(textArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(0,0,800,500);
      this.add(scrollPane);
      scrollPane.setVisible(false);

      doneButton = new JButton("Done");
  		doneButton.setBounds(650, 550, 100, 30);
  		doneButton.addActionListener(e -> {
        if(currentScreen == 1){
  			  resume.init(name1.getText(), email.getText(), address.getText(), objectives.getText(), skills.getText());
          this.remove(name1);
          this.remove(address);
          this.remove(email);
          this.remove(objectives);
          this.remove(skills);
          this.add(name2);
          this.add(gradYear);
          this.add(gradMonth);
          this.add(addSchoolButton);
          repaint();
        } else if(currentScreen == 2){
          this.remove(name2);
          this.remove(gradYear);
          this.remove(gradMonth);
          this.remove(addSchoolButton);
          this.add(title);
          this.add(company);
          this.add(startMonth);
          this.add(startYear);
          this.add(endMonth);
          this.add(endYear);
          this.add(description);
          this.add(addJobButton);
          this.add(addJobButton);
          repaint();
        } else if(currentScreen == 3){
          this.remove(title);
          this.remove(company);
          this.remove(startMonth);
          this.remove(startYear);
          this.remove(endMonth);
          this.remove(endYear);
          this.remove(description);
          this.remove(addJobButton);
          displayText();
          scrollPane.setVisible(true);
          textArea.setVisible(true);
          repaint();
        }

  			currentScreen++;
  		});
  		this.add(doneButton);

      addSchoolButton = new JButton("Add School");
      addSchoolButton.setBounds(650, 500, 100, 30);
  		addSchoolButton.addActionListener(e -> {
          resume.addEducation(name2.getText(), gradYear.getText(), gradMonth.getText());

  			  name2.setText("School name");
  			  gradYear.setText("Graduation year");
  			  gradMonth.setText("Graduation month");

  			  this.repaint();
  		});

      addJobButton = new JButton("Add Job");
      addJobButton.setBounds(650, 500, 100, 30);
  		addJobButton.addActionListener(e -> {
          resume.addJob(title.getText(), company.getText(), endYear.getText(), endMonth.getText(),
          startYear.getText(), startMonth.getText(),description.getText());

  			  title.setText("Job Title");
          company.setText("Company Name");
          startYear.setText("Start Year");
          startMonth.setText("Start Month");
          endYear.setText("End Year");
        	endMonth.setText("End Month");
          description.setText("Job Description");

  			  this.repaint();
  		});


  		name1 = new JTextField(20);
  		name1.setBounds(125, 100, 200, 30);
  		name1.setText("Name");
  		this.add(name1);

      name2 = new JTextField(20);
  		name2.setBounds(125, 100, 200, 30);
  		name2.setText("School Name");

      gradYear = new JTextField(20);
  		gradYear.setBounds(125, 200, 200, 30);
  		gradYear.setText("Graduation year");

      gradMonth = new JTextField(20);
  		gradMonth.setBounds(125, 300, 200, 30);
  		gradMonth.setText("Graduation month");

      title = new JTextField(20);
  		title.setBounds(125, 100, 200, 30);
  		title.setText("Job Title");

      company = new JTextField(20);
  		company.setBounds(125, 200, 200, 30);
  		company.setText("Company Name");

      startYear = new JTextField(20);
  		startYear.setBounds(125, 300, 200, 30);
  		startYear.setText("Start Year");

      startMonth = new JTextField(20);
  		startMonth.setBounds(450, 300, 200, 30);
  		startMonth.setText("Start Month");

      endYear = new JTextField(20);
  		endYear.setBounds(125, 400, 200, 30);
  		endYear.setText("End Year");

      endMonth = new JTextField(20);
  		endMonth.setBounds(450, 400, 200, 30);
  		endMonth.setText("End Month");

      description = new JTextField(20);
  		description.setBounds(125, 500, 200, 50);
  		description.setText("Job Description");




  		address = new JTextField(20);
  		address.setBounds(125, 200, 200, 30);
  		address.setText("Address");
  		this.add(address);

  		email = new JTextField(20);
  		email.setBounds(125, 300, 200, 30);
  		email.setText("Email");
  		this.add(email);

  		objectives = new JTextField(20);
  		objectives.setBounds(125, 400, 200, 30);
  		objectives.setText("Objectives");
  		this.add(objectives);

  		skills = new JTextField(20);
  		skills.setBounds(125, 500, 200, 30);
  		skills.setText("Skills");
  		this.add(skills);

      textArea = new JTextArea(0,0); //sets the location and size
        textArea.setText(text);

        //JScrollPane









      this.setFocusable(true);


    }

    public Dimension getPreferredSize(){
        //Sets the size of the panel
      return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setFont(font);

      if(currentScreen == 1){
        g.setColor(new Color(138, 202, 255));
        g.fillRect(0,0,200,40);
        g.setColor(Color.black);
        g.drawString("Basic Information", 20,20);
      } else if(currentScreen == 2){
        g.setColor(new Color(202, 138, 255));
        g.fillRect(0,0,200,40);
        g.setColor(Color.black);
        g.drawString("School Information", 20,20);

      } else if(currentScreen == 3){
        g.setColor(new Color(255, 141, 133));
        g.fillRect(0,0,200,40);
        g.setColor(Color.black);
        g.drawString("Job Experience", 20,20);

      }

    }


    private void displayText(){
      text = resume.getName() + "'s Resume\n\n" + "Basic Information\n\n" + resume.basicInfoToString()
            + "\n\n\nEducation\n\n" + resume.educationToString() + "\n\n\nJob Information\n\n" +
            resume.jobsToString();
      textArea.setText(text);

    }









    public void actionPerformed(ActionEvent e) {
    }

}
