package it.chefcostcalculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MainGui {

	private JFrame frame;
	private JTextField recipeNameField;
	private JTextField quantityField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCalcolatoreDiCosto = new JLabel("CALCOLATORE DI COSTO DI RICETTE");
		lblCalcolatoreDiCosto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalcolatoreDiCosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcolatoreDiCosto.setBounds(12, 13, 408, 32);
		frame.getContentPane().add(lblCalcolatoreDiCosto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(181, 100, 192, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel ingredientsLbl = new JLabel("INGREDIENTE");
		ingredientsLbl.setBounds(22, 103, 83, 16);
		frame.getContentPane().add(ingredientsLbl);
		
		JLabel recipeNameLbl = new JLabel("NOME RICETTA");
		recipeNameLbl.setBounds(22, 58, 97, 16);
		frame.getContentPane().add(recipeNameLbl);
		
		recipeNameField = new JTextField();
		recipeNameField.setBounds(181, 58, 192, 22);
		frame.getContentPane().add(recipeNameField);
		recipeNameField.setColumns(10);
		
		JTextArea ingredientsLogTextArea = new JTextArea();
		ingredientsLogTextArea.setBounds(181, 196, 192, 188);
		frame.getContentPane().add(ingredientsLogTextArea);
		
		JLabel quantityLbl = new JLabel("QUANTITA'");
		quantityLbl.setBounds(22, 149, 83, 16);
		frame.getContentPane().add(quantityLbl);
		
		quantityField = new JTextField();
		quantityField.setBounds(181, 146, 116, 22);
		frame.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		
		JLabel logLbl = new JLabel("RIEPILOGO");
		logLbl.setBounds(22, 272, 83, 16);
		frame.getContentPane().add(logLbl);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(22, 210, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
