package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 2000;
	public static final int HEIGHT = 1000;

	private JPanel pnlDisplay;
	private JPanel pnlTwo;
	private JPanel pnlThree;
	private JPanel pnlFour;
	private JPanel pnlBtn;
	
	private JButton btnLoadFile;
	private JButton btnPizzaDisplay;
	private JButton btnCustomerDisplay;
	private JButton btnCalculate;
	private JButton btnReset;
	
	private JTextField fldPizza;
	//private JTable tblCustomer;
	
	private String filename;
	private String selectedFileName;
	
	private PizzaRestaurant restaurant;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		
	}
	
	private void createGUI() { 
	setSize(WIDTH, HEIGHT); 
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	setLayout(new BorderLayout());
	
	pnlDisplay = createPanel(Color.WHITE);
	pnlTwo = createPanel(Color.LIGHT_GRAY);
	pnlThree = createPanel(Color.LIGHT_GRAY);
	pnlFour = createPanel(Color.LIGHT_GRAY);
	pnlBtn = createPanel(Color.LIGHT_GRAY);
	
	btnLoadFile = createButton("Load File");
	btnPizzaDisplay = createButton("Order Details");
	btnPizzaDisplay.setEnabled(false);
	btnCustomerDisplay = createButton("Customer Details");
	btnCustomerDisplay.setEnabled(false);
	btnCalculate = createButton("Calculate Profits");
	btnCalculate.setEnabled(false);
	btnReset = createButton("Reset");
	btnReset.setEnabled(false);
	
    layoutButtonPanel();
    
    fldPizza = createTextField();
    //tblCustomer = createTable();
    
    pnlDisplay.setLayout(new BorderLayout());
    pnlDisplay.add(fldPizza, BorderLayout.CENTER);
    
	
	this.getContentPane().add(pnlDisplay,BorderLayout.CENTER);
	this.getContentPane().add(pnlTwo,BorderLayout.SOUTH);
	this.getContentPane().add(pnlBtn,BorderLayout.NORTH); 
	this.getContentPane().add(pnlFour,BorderLayout.EAST); 
	this.getContentPane().add(pnlThree,BorderLayout.WEST);
	
	repaint();
	this.setVisible(true);
	//Panel related code will go here
	}
	
	
	private JPanel createPanel(Color c) {
		JPanel jp = new JPanel();
		jp.setBackground(c);
		return jp;
	}
	
	private JButton createButton(String str) {
		JButton jb = new JButton(str); 
		jb.addActionListener(this);
		return jb; 
	}
	
	private JTextField createTextField() {
		JTextField jtf = new JTextField(); 
		jtf.setEditable(false);
		jtf.setFont(new Font("Arial",Font.BOLD,24));
		jtf.setBorder(BorderFactory.createEtchedBorder());
		return jtf;
	}
	
	private void layoutButtonPanel() { 
		GridBagLayout layout = new GridBagLayout();
		pnlBtn.setLayout(layout);
	
	
		//add components to grid 
		GridBagConstraints constraints = new GridBagConstraints();
		//Defaults 
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER; 
		constraints.weightx = 200;
		constraints.weighty = 200;
		//Lots of layout code here
	
		addToPanel(pnlBtn, btnLoadFile,constraints,0,0,2,4); 
		addToPanel(pnlBtn, btnPizzaDisplay,constraints,2,0,2,4); 
		addToPanel(pnlBtn, btnCustomerDisplay,constraints,4,0,2,4); 
		addToPanel(pnlBtn, btnCalculate,constraints,6,0,2,4); 
		addToPanel(pnlBtn, btnReset,constraints,8,0,2,4);
	}
	
	private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints,int x, int y, int w, int h) { 
		constraints.gridx = x; 
		constraints.gridy = y; 
		constraints.gridwidth = w; 
		constraints.gridheight = h; 
		jp.add(c, constraints); 
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Get event source 
		Object src=arg0.getSource(); 
		      
		//Consider the alternatives - not all active at once. 
		if (src== btnLoadFile) {
			JButton btn = ((JButton) src);
			
			try {
				openFile();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LogHandlerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//fldPizza.setText(btn.getText().trim());
			
		      
		}
//		else if (src==btnUnload) {
//			JButton btn = ((JButton) src);
//		      areDisplay.setText(btn.getText().trim());
//		} else if (src==btnSwitch) {
//			JOptionPane.showMessageDialog(this,"A Warning Message","Wiring Class: Warning",JOptionPane.WARNING_MESSAGE);
//		} else if (src==btnFind) {
//			JOptionPane.showMessageDialog(this,"An Error Message","Wiring Class: Error",JOptionPane.ERROR_MESSAGE);
//		}
	}
	
	@Override
	public void run() {
		// TO DO
		createGUI();
	}


	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new PizzaGUI("BorderLayout"));
	}
	

	
	private void openFile() throws CustomerException, PizzaException, LogHandlerException {
		final JFileChooser jfc = new JFileChooser();
		
		int returnValue = jfc.showOpenDialog(this);
		
		if(returnValue == JFileChooser.APPROVE_OPTION){
			File selectedFile = jfc.getSelectedFile();
			selectedFileName = selectedFile.getAbsolutePath();
			System.out.println(selectedFileName);
			restaurant = new PizzaRestaurant();
			restaurant.processLog(selectedFileName);
		}
		else if (returnValue == JFileChooser.CANCEL_OPTION){
			
		}
		btnPizzaDisplay.setEnabled(true);
		btnCustomerDisplay.setEnabled(true);
		btnCalculate.setEnabled(true);
		btnReset.setEnabled(true);
		btnLoadFile.setEnabled(false);
	}
}
