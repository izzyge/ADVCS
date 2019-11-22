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
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Screen extends JPanel implements ActionListener{

  Account[] accounts;

	private JTextField pinInput;
  private JTextField nameInput;
	private JButton checkPinButton;
	private JButton logOutButton;

	private JTextField amountInput;
	private JButton withdrawButton;
	private JButton depositButton;
  int current;
  private BufferedImage jennifer;
  private BufferedImage jose;
  private BufferedImage ly;
  private BufferedImage alyssa;
  private BufferedImage fred;





	public Screen(){
		setLayout(null);
    accounts = new Account[6];

		accounts[0] = new Account("Jennifer", 999.99, 1234);
    accounts[1] = new Account("Jose", 500.01, 4321);
    accounts[2] = new Account("Ly", 2000.00, 8888);
    accounts[3] = new Account("Alyssa", 225.50, 1224);
    accounts[4] = new Account("Fred", 750.67, 5227);
    accounts[5] = new Account("-", 0.00, 0000);
    current = 5;



		pinInput = new JTextField();
		pinInput.setBounds(150,150,150,60);
		add(pinInput);

    nameInput = new JTextField();
    nameInput.setBounds(150,250,150,60);
    add(nameInput);

		checkPinButton = new JButton("Login");
		checkPinButton.setBounds(150,350,150,60);
		checkPinButton.addActionListener(this);
		add(checkPinButton);

		logOutButton = new JButton("Sign Out");
		logOutButton.setBounds(150,450,150,60);
		logOutButton.addActionListener(this);
		add(logOutButton);


		amountInput = new JTextField();
		amountInput.setBounds(420,150,150,60);
		add(amountInput);

		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(420,250,150,60);
		withdrawButton.addActionListener(this);
		add(withdrawButton);

		depositButton = new JButton("Deposit");
		depositButton.setBounds(420,320,150,60);
		depositButton.addActionListener(this);
		add(depositButton);

    try {
        jennifer = ImageIO.read(new File("imgs/jennifer.png"));
        jose = ImageIO.read(new File("imgs/jose.png"));
        ly = ImageIO.read(new File("imgs/ly.png"));
        alyssa = ImageIO.read(new File("imgs/alyssa.png"));
        fred = ImageIO.read(new File("imgs/fred.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }





		setFocusable(true);

	}

	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

    g.setColor(Color.red);
    g.drawString("Welcome " + accounts[current].getName(), 100, 50);
    g.drawString("Balance $" + accounts[current].getBalance(), 100,100 );

    if(current == 5){
      g.setColor(Color.gray);
      g.fillRect(400,0,400,600);
      depositButton.setVisible(false);
      withdrawButton.setVisible(false);
      amountInput.setVisible(false);
    } else {
      depositButton.setVisible(true);
      withdrawButton.setVisible(true);
      amountInput.setVisible(true);
    }



    g.setColor(Color.black);
		g.drawString("PIN: ",150,140);
		g.drawString("NAME:", 150, 240);
    if(current!=5)
      g.drawString("AMOUNT$:", 420, 140);

    switch(current){
      case 0:
        g.drawImage(jennifer, 700,500,70,70, null);
        break;
      case 1:
        g.drawImage(jose, 700,500,70,70, null);
        break;
      case 2:
        g.drawImage(ly, 700,500,70,70, null);
        break;
      case 3:
        g.drawImage(alyssa, 700,500,70,70, null);
        break;
      case 4:
        g.drawImage(fred, 700,500,70,70, null);
        break;
      default:
        break;
      }





	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == checkPinButton){
			String pinText = pinInput.getText();
			int pin = Integer.parseInt(pinText);
      String name = nameInput.getText();
      for(int i = 0; i<accounts.length; i++){
        accounts[i].setAccess(pin, name);
        if(accounts[i].getAccess()){
          current = i;
        }
      }

		} else if(e.getSource() == withdrawButton){
      String amountText = amountInput.getText();
			int amount = Integer.parseInt(amountText);
      accounts[current].withdraw(amount);

    } else if(e.getSource() == depositButton){
      String amountText = amountInput.getText();
			int amount = Integer.parseInt(amountText);
      accounts[current].deposit(amount);

    } else if(e.getSource() == logOutButton){
      accounts[current].logOut();
      current = 5;

    }





		repaint();

	}


}
