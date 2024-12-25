package banking.gui;

import banking.domain.*;
import banking.data.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ATMClient {

  private static final String USAGE
    = "USAGE: java banking.gui.ATMClient <dataFilePath>";

  public static void main(String[] args) {

    // Retrieve the dataFilePath command-line argument
    if ( args.length != 1 ) {
      System.out.println(USAGE);
    } else {
      String dataFilePath = args[0];

      try {
	System.out.println("Reading data file: " + dataFilePath);
	// Create the data source and load the Bank data
	DataSource dataSource = new DataSource(dataFilePath);
	dataSource.loadData();

	// Run the ATM GUI
	ATMClient client = new ATMClient();
	client.launchFrame();

      } catch (IOException ioe) {
	System.out.println("Could not load the data file.");
	System.out.println(ioe.getMessage());
	ioe.printStackTrace(System.err);
      }
    }
    ATMClient atm = new ATMClient();
    atm.launchFrame();

  }

  // Colocar a continuación el código de la GUI.
  private JFrame f;
  private JTextArea output;
  private JTextField input1;
  private JTextField input2;
  private JButton Display_account_balance;
  private JButton Make_a_deposit;
  private JButton Make_a_whithdrawal;
  private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
  public ATMClient(){
      f= new JFrame("Bank Ltd");
      output = new JTextArea(50,50);
      input1 = new JTextField(50);
      input2 = new JTextField(50);
      Display_account_balance = new JButton("Display account balance");
      Make_a_deposit = new JButton("Make a deposit");
      Make_a_whithdrawal = new JButton("Make a whithdrawal");
      b1 = new JButton("1");
      b2 = new JButton("2");
      b3 = new JButton("3");
      b4 = new JButton("4");
      b5 = new JButton("5");
      b6 = new JButton("6");
      b7 = new JButton("7");
      b8 = new JButton("8");
      b9 = new JButton("9");
      b10 = new JButton("0");
      b11 = new JButton(".");
      b12 = new JButton("ENTER");
  }
  public void launchFrame(){
      f.setLayout(new BorderLayout());
      f.add(output, BorderLayout.CENTER);
      f.add(input1, BorderLayout.SOUTH);
      Panel pan = new Panel();
      pan.setLayout(new GridLayout(2,1));
      Panel pan1 = new Panel();
      pan1.setLayout(new GridLayout(4,1));
      pan1.add(Display_account_balance);
      pan1.add(Make_a_deposit);
      pan1.add(Make_a_whithdrawal);
      pan1.add(input2, BorderLayout.SOUTH);
      pan.add(pan1);
      Panel pan2 = new Panel();
      pan2.setLayout(new GridLayout(4,3));
      pan2.add(b1);
      pan2.add(b2);
      pan2.add(b3);
      pan2.add(b4);
      pan2.add(b5);
      pan2.add(b6);
      pan2.add(b7);
      pan2.add(b8);
      pan2.add(b9);
      pan2.add(b10);
      pan2.add(b11);
      pan2.add(b12);
      pan.add(pan2);
      f.add(pan, BorderLayout.WEST);
      f.pack();
      f.setVisible(true);
  }
 }
