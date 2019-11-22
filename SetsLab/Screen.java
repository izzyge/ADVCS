import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Screen extends JPanel implements ActionListener{
  private JTextArea itemTextArea, scTextArea;
  private JButton addButton, addItem, removeItem;
  private JTextField nameText, priceText, qtyText, nameText2, priceText2, qtyText2;
  private Database db;
  public Screen(){
    this.setLayout(null);
    db = new Database("StoreA.txt");
    itemTextArea = new JTextArea(390, 400);
    scTextArea = new JTextArea(390, 400);

    JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
		itemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		itemScrollPane.setBounds(0, 0, 290, 400);
		this.add(itemScrollPane);
		itemTextArea.setText(db.getItems());

    JScrollPane scScrollPane = new JScrollPane(scTextArea);
    scScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scScrollPane.setBounds(300, 0, 290, 400);
    this.add(scScrollPane);
    scTextArea.setText(db.getCart());

    nameText = new JTextField();
    nameText.setText("Product name");
    nameText.setBounds(25, 450, 150, 30);
    this.add(nameText);

    priceText = new JTextField();
    priceText.setText("Price");
    priceText.setBounds(25, 480, 150, 30);
    this.add(priceText);

    qtyText = new JTextField();
    qtyText.setText("Quantity");
    qtyText.setBounds(25, 510, 150, 30);
    this.add(qtyText);

    addButton = new JButton("Add to Cart");
    addButton.setBounds(25, 540, 150, 30);
    addButton.addActionListener(e -> {

			Item i = new Item(nameText.getText(), Double.parseDouble(priceText.getText()));
			db.addToCart(i, Integer.parseInt(qtyText.getText()));
			nameText.setText("Product name");
			priceText.setText("Price");
			qtyText.setText("Quantity");

			scTextArea.setText(db.cartToString());
		});;
    this.add(addButton);

    nameText2 = new JTextField();
    nameText2.setText("Product name");
    nameText2.setBounds(225, 450, 150, 30);
    this.add(nameText2);

    priceText2 = new JTextField();
    priceText2.setText("Price");
    priceText2.setBounds(225, 480, 150, 30);
    this.add(priceText2);

    addItem = new JButton("Add Item");
    addItem.setBounds(225, 510, 150, 30);
    addItem.addActionListener(e -> {
			Item item = new Item(nameText2.getText(), Double.parseDouble(priceText2.getText()));
			db.addToSet(item);
			itemTextArea.setText(db.getItems());

			nameText2.setText("Product name");
			priceText2.setText("Price");
		});
    this.add(addItem);

    removeItem = new JButton("Remove Item");
    removeItem.setBounds(225, 540, 150, 30);
    removeItem.addActionListener(e -> {
			Item item = new Item(nameText2.getText(), Double.parseDouble(priceText2.getText()));
			db.removeFromSet(item);
			itemTextArea.setText(db.getItems());

			nameText2.setText("Product name");
			priceText2.setText("Price");
		});
    this.add(removeItem);


    this.setFocusable(true);

  }

  public Dimension getPreferredSize(){
      //Sets the size of the panel
    return new Dimension(800,600);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
  }

  public void actionPerformed(ActionEvent e) {}



}
