package it.chefcostcalculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.chefcostcalculator.core.Ingredient;
import it.chefcostcalculator.db.FileDB;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class InsertInDb {

	private JFrame frame;
	private JTextField ingredientNameField;
	private JTextField ingredientCostField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertInDb window = new InsertInDb();
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
	public InsertInDb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 283, 228);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeIngredientek = new JLabel("NOME INGREDIENTE");
		lblNomeIngredientek.setBounds(12, 58, 124, 16);
		frame.getContentPane().add(lblNomeIngredientek);
		
		ingredientNameField = new JTextField();
		ingredientNameField.setBounds(141, 55, 116, 22);
		frame.getContentPane().add(ingredientNameField);
		ingredientNameField.setColumns(10);
		
		JLabel lblCostoIngrediente = new JLabel("COSTO INGREDIENTE");
		lblCostoIngrediente.setBounds(12, 93, 124, 16);
		frame.getContentPane().add(lblCostoIngrediente);
		
		ingredientCostField = new JTextField();
		ingredientCostField.setColumns(10);
		ingredientCostField.setBounds(141, 90, 116, 22);
		frame.getContentPane().add(ingredientCostField);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileDB.ingredientToFile("CostDB.txt", new Ingredient(ingredientNameField.getText(), Double.parseDouble(ingredientCostField.getText())));
					ingredientNameField.setText("");
					ingredientCostField.setText("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSave.setBounds(88, 132, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JLabel lblInserisciIngredienteIn = new JLabel("INSERISCI INGREDIENTE IN DB");
		lblInserisciIngredienteIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserisciIngredienteIn.setBounds(12, 13, 245, 16);
		frame.getContentPane().add(lblInserisciIngredienteIn);
	}
}
