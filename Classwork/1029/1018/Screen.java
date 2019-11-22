import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Screen extends JPanel implements ActionListener{
  private String[] paragraph;
  HashMap<String, String> hMap;
  TreeMap<String, String> tMap;
  JTextArea textArea;
  String text, translation;
  JButton translateButton;
  JTextArea translateInput;
  public Screen(){
    this.setLayout(null);
    hMap = new HashMap<String, String>();
    tMap = new TreeMap<String, String>();
    translation = "";

    try {
      File file = new File("spantoeng.txt");
			Scanner in = new Scanner(file);

			while (in.hasNextLine()) {

				String[] mapParts = in.nextLine().split(" ");
				hMap.put(mapParts[0], mapParts[1]);
        tMap.put(mapParts[0], mapParts[1]);
			}
		} catch (FileNotFoundException e) {

		}



    translateInput = new JTextArea();
    translateInput.setBounds(20,300,200,200);
    this.add(translateInput);

    translateButton = new JButton("Translate");
    translateButton.setBounds(240, 300, 150, 30);
    translateButton.addActionListener(e -> {
      translation = translate(translateInput.getText());
    });
    this.add(translateButton);


    textArea = new JTextArea(300,300);
    text = "";
    for(String each: tMap.keySet()){
      text = text + " " + each + " " + tMap.get(each) + "\n";
    }
    textArea.setText(text);
    this.add(textArea);

    JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(400, 0, 300, 600);
		this.add(scrollPane);




    this.setFocusable(true);

  }

  public Dimension getPreferredSize(){
    return new Dimension(800,600);
  }

  public String translate(String str) {
    String translation = "";

    for ( String s : str.split(" ")){
      translation += " " + hMap.get(s);
    }
    return translation;
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawString(translation,500,600);
  }

  public void actionPerformed(ActionEvent e) {  }



}
