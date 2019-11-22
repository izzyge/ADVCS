import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Screen extends JPanel implements ActionListener{
  Database db;
  private JTextArea profileText;
  private JTextField lastText, firstText, yearText, schoolText, lastText2, firstText2, yearText2, schoolText2;
  private JButton schoolButton, viewButton, profileButton, changeSchoolButton, addProfileButton, removeProfileButton;
  private String profileFound, schoolFound, classesFound;
  private int view;

  public Screen(){
    this.setLayout(null);
    db = new Database("names.txt");
    schoolFound = "";
    profileFound = "";
    classesFound = "";
    view = 1;
    profileText = new JTextArea(300,600);
    profileText.setText(db.getProfiles());

    JScrollPane scrollPane = new JScrollPane(profileText);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 300, 600);
		this.add(scrollPane);

    lastText = new JTextField();
    lastText.setText("Last Name");
    lastText.setBounds(325, 25, 150, 30);
    this.add(lastText);

    firstText = new JTextField();
    firstText.setText("First Name");
    firstText.setBounds(325, 75, 150, 30);
    this.add(firstText);

    yearText = new JTextField();
    yearText.setText("Birth year");
    yearText.setBounds(325, 125, 150, 30);
    this.add(yearText);

    schoolText = new JTextField();
    schoolText.setText("New School");
    schoolText.setBounds(600, 120, 150, 30);
    this.add(schoolText);
    schoolText.setVisible(false);

    lastText2 = new JTextField();
    lastText2.setText("Last Name");
    lastText2.setBounds(325, 275, 150, 30);
    this.add(lastText2);
    lastText2.setVisible(false);

    firstText2 = new JTextField();
    firstText2.setText("First Name");
    firstText2.setBounds(325, 325, 150, 30);
    this.add(firstText2);
    firstText2.setVisible(false);

    yearText2 = new JTextField();
    yearText2.setText("Birth year");
    yearText2.setBounds(325, 375, 150, 30);
    this.add(yearText2);
    yearText2.setVisible(false);

    schoolText2 = new JTextField();
    schoolText2.setText("School");
    schoolText2.setBounds(325, 425, 150, 30);
    this.add(schoolText2);
    schoolText2.setVisible(false);

    addProfileButton = new JButton("Add Profile");
    addProfileButton.setBounds(325, 475, 150, 30);
    addProfileButton.addActionListener(e -> {
      Profile p = new Profile(firstText2.getText(), lastText2.getText());
      p.setBirthYear(Integer.parseInt(yearText2.getText()));
      db.addProfile(p, schoolText2.getText());
      profileText.setText(db.getProfiles());
      repaint();
    });
    this.add(addProfileButton);
    addProfileButton.setVisible(false);

    removeProfileButton = new JButton("Remove Profile");
    removeProfileButton.setBounds(325, 525, 150, 30);
    removeProfileButton.addActionListener(e -> {
      Profile p = new Profile(firstText2.getText(), lastText2.getText());
      p.setBirthYear(Integer.parseInt(yearText2.getText()));
      db.removeProfile(p);
      profileText.setText(db.getProfiles());
      repaint();
    });
    this.add(removeProfileButton);
    removeProfileButton.setVisible(false);



    profileButton = new JButton("Select Profile");
    profileButton.setBounds(325, 175, 150, 30);
    profileButton.addActionListener(e -> {
      Profile p = new Profile(firstText.getText(), lastText.getText());
      p.setBirthYear(Integer.parseInt(yearText.getText()));
      profileFound = p.toString();
      schoolFound = db.getSchool(p);
      schoolText.setVisible(true);
      changeSchoolButton.setVisible(true);
      repaint();
    });
    this.add(profileButton);
    profileButton.setVisible(false);

    changeSchoolButton = new JButton("Change School");
    changeSchoolButton.setBounds(600, 175, 150, 30);
    changeSchoolButton.addActionListener(e -> {
      Profile p = new Profile(firstText.getText(), lastText.getText());
      p.setBirthYear(Integer.parseInt(yearText.getText()));
      profileFound = p.toString();
      db.changeSchool(p, schoolText.getText());
      schoolFound = db.getSchool(p);
      repaint();
    });
    this.add(changeSchoolButton);
    changeSchoolButton.setVisible(false);

    schoolButton = new JButton("Find School");
    schoolButton.setBounds(325, 175, 150, 30);
    schoolButton.addActionListener(e -> {
      Profile p = new Profile(firstText.getText(), lastText.getText());
      p.setBirthYear(Integer.parseInt(yearText.getText()));
      profileFound = p.toString();
      schoolFound = db.getSchool(p);
      classesFound = db.getClasses(p);
      repaint();
		});
    this.add(schoolButton);

    viewButton = new JButton("Change View");
    viewButton.setBounds(650, 530, 130, 30);
    viewButton.addActionListener(e -> {
      if(view == 1){
        view = 2;
        schoolFound = "";
        profileFound = "";
        classesFound = "";
        schoolButton.setVisible(false);
        profileButton.setVisible(true);
        yearText2.setVisible(true);
        lastText2.setVisible(true);
        firstText2.setVisible(true);
        addProfileButton.setVisible(true);
        removeProfileButton.setVisible(true);
        schoolText2.setVisible(true);
        // yearText.setVisible(false);
        // firstText.setVisible(false);
        // lastText.setVisible(false);
      } else if(view == 2){
        view = 1;
        schoolFound = "";
        profileFound = "";
        classesFound = "";
        schoolButton.setVisible(true);
        profileButton.setVisible(false);
        yearText2.setVisible(false);
        lastText2.setVisible(false);
        firstText2.setVisible(false);
        schoolText2.setVisible(false);
        addProfileButton.setVisible(false);
        removeProfileButton.setVisible(false);
        schoolText.setVisible(false);
        changeSchoolButton.setVisible(false);
      }
      repaint();
    });
    this.add(viewButton);

    this.setFocusable(true);

  }

  public Dimension getPreferredSize(){
    return new Dimension(800,600);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawString(profileFound, 600,50);
    g.drawString(schoolFound, 600, 80);
    String[] classesParts = classesFound.split("  ");
    for(int i = 0; i<classesParts.length; i++){
      g.drawString(classesParts[i], 600, 110 + (30*i));
    }

  }

  public void actionPerformed(ActionEvent e) {}



}
