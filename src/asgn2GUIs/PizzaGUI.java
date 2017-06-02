package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;
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

	//creating pannels for data
	private JPanel pnlDisplay;
	private JPanel pnlTwo;
	private JPanel pnlThree;
	private JPanel pnlFour;
	private JPanel pnlBtn;
	
	//creating buttons
	private JButton btnLoadFile;
	private JButton btnPizzaDisplay;
	private JButton btnCustomerDisplay;
	private JButton btnCalculate;
	private JButton btnReset;
	
	//setup for tables 
	private DefaultTableModel modelCustomer;
	private DefaultTableModel modelOrders;
	private DefaultTableModel modelOrdersAndProfit;
	private JScrollPane jspCustomer;
	private JScrollPane jspOrders;
	private JScrollPane jspOrdersAndProfit;
	private JTable tblCustomers;
	private JTable tblOrders;
	private JTable tblOrdersAndProfit;
	//private contentpane
	

	
	//creating string variables for the log reader
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
	getContentPane().setLayout(new BorderLayout());
	
	pnlDisplay = createPanel(Color.LIGHT_GRAY);
	pnlTwo = createPanel(Color.LIGHT_GRAY);
	pnlThree = createPanel(Color.LIGHT_GRAY);
	pnlFour = createPanel(Color.LIGHT_GRAY);
	pnlBtn = createPanel(Color.LIGHT_GRAY);
	
	btnLoadFile = createButton("Load File");
	btnPizzaDisplay = createButton("Order Details");
	btnPizzaDisplay.setEnabled(false);
	btnCustomerDisplay = createButton("Customer Details");
	btnCustomerDisplay.setEnabled(false);
	btnCalculate = createButton("Calculate Profits and Distance");
	btnCalculate.setEnabled(false);
	btnReset = createButton("Reset");
	btnReset.setEnabled(false);
	
    layoutButtonPanel();
    

    //creating a customer table
    pnlDisplay.setLayout(new BorderLayout());
    tblCustomers = new JTable(modelCustomer = new DefaultTableModel(new Object[]{"Name", "Mobile Number","Customer Type", "X Location", "Y Location", "Distance"}, 0));

    jspCustomer = new JScrollPane(tblCustomers);
	jspCustomer.setBounds(325, 66, 624, 192);
	jspCustomer.setVisible(true);
	pnlDisplay.add(jspCustomer);
	
	//creating the Order table
	pnlThree.setLayout(new BorderLayout());
	tblOrders = new JTable(modelOrders = new DefaultTableModel(new Object[]{"Pizza Type", " Quantity", "Order Price", "Order Cost", "Order Profit"}, 0));
    jspOrders = new JScrollPane(tblOrders);
    jspOrders.setBounds(325, 66, 624, 192);
    jspOrders.setVisible(true);
    pnlThree.add(jspOrders);
	
	//creating a Order and profits table
	pnlFour.setLayout(new BorderLayout());
	tblOrdersAndProfit = new JTable(modelOrdersAndProfit = new DefaultTableModel(new Object[]{ "Total Distance", "Total Profit"}, 0));
    jspOrdersAndProfit = new JScrollPane(tblOrdersAndProfit);
    jspOrdersAndProfit.setBounds(325, 66, 624, 192);
    jspOrdersAndProfit.setVisible(true);
    pnlFour.add(jspOrdersAndProfit);
    
	
	this.getContentPane().add(pnlDisplay,BorderLayout.CENTER);
	this.getContentPane().add(pnlTwo,BorderLayout.SOUTH);
	this.getContentPane().add(pnlBtn,BorderLayout.NORTH);
	this.getContentPane().add(pnlFour,BorderLayout.EAST);
	this.getContentPane().add(pnlThree,BorderLayout.WEST);
	
	
	repaint();
	this.setVisible(true);
	//tblCustomers.setEnabled(false);
	//tblCustomers.setVisible(false);
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
		      
		if (src == btnLoadFile) {
			
			try {
				openFile();
				JOptionPane.showMessageDialog(this,"File Successfully Loaded","Success!",JOptionPane.INFORMATION_MESSAGE);
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
		
		if (src == btnPizzaDisplay){
			JOptionPane.showMessageDialog(this,"Retrieving Order Details","Success!",JOptionPane.INFORMATION_MESSAGE);
			Pizza Pizza = null;
			btnPizzaDisplay.setEnabled(false);
			btnCalculate.setEnabled(true);
			
			for(int i = 0; i < restaurant.getNumPizzaOrders(); i++){
				try {
					Pizza = restaurant.getPizzaByIndex(i);
					modelOrders.addRow(new Object[]{
					Pizza.getPizzaType(),
					Pizza.getQuantity(),
					Pizza.getOrderPrice(),
					Pizza.getOrderCost(),
					Pizza.getOrderProfit()});

				} catch (PizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if (src == btnCustomerDisplay){
			Customer Customer = null;
			btnCustomerDisplay.setEnabled(false);
			JOptionPane.showMessageDialog(this,"Retrieving Customer Details","Success!",JOptionPane.INFORMATION_MESSAGE);
			
			for(int i = 0; i < restaurant.getNumCustomerOrders(); i++){
				try {
					Customer = restaurant.getCustomerByIndex(i);
					modelCustomer.addRow(new Object[]{
							Customer.getName(),
							Customer.getMobileNumber(),
							Customer.getCustomerType(),
							Customer.getLocationX(),
							Customer.getLocationY(),
							Customer.getDeliveryDistance()});

				} catch (CustomerException e) {
					// TODO Auto-generated catch block
					System.out.println("caught the customer block and didn't do anything");
					e.printStackTrace();
				}

			}
		}
		
		if (src == btnCalculate){
			btnCalculate.setEnabled(false);
		
			JOptionPane.showMessageDialog(this,"Calculating Total Distance and Profits","Success!",JOptionPane.INFORMATION_MESSAGE);

			modelOrdersAndProfit.addRow(new Object[]{ restaurant.getTotalDeliveryDistance(), restaurant.getTotalProfit()});

			

		}
		
		if (src == btnReset){
			restaurant.resetDetails();
			
			JOptionPane.showMessageDialog(this,"Reseting All Data","Success!",JOptionPane.INFORMATION_MESSAGE);
			
			modelCustomer.getDataVector().removeAllElements();
			modelCustomer.fireTableDataChanged();
			
			
			modelOrders.getDataVector().removeAllElements();
			modelOrders.fireTableDataChanged();
			
			modelOrdersAndProfit.getDataVector().removeAllElements();
			modelOrdersAndProfit.fireTableDataChanged();
			
			btnLoadFile.setEnabled(true);
			btnPizzaDisplay.setEnabled(false);
			btnCustomerDisplay.setEnabled(false);
			btnCalculate.setEnabled(false);
			btnReset.setEnabled(false);
		}
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
		btnReset.setEnabled(true);
		btnLoadFile.setEnabled(false);
	}
}
