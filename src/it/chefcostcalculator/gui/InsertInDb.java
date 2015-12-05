package it.chefcostcalculator.gui;

import java.awt.Color;
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
import javax.swing.JRadioButton;

public class InsertInDb {

	private JFrame frame;
	private JTextField ingredientNameField;
	private JTextField ingredientCostField;
	private JTextField statusField;
	private JTextField weightField;

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
		frame.setBounds(100, 100, 283, 296);
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
					if(!FileDB.isPresentIngredient("CostDB.txt", ingredientNameField.getText().toUpperCase())){
						FileDB.ingredientToFile("CostDB.txt", new Ingredient(ingredientNameField.getText(), Double.parseDouble(ingredientCostField.getText())));
						statusField.setBackground(new Color(0, 255, 0));
						statusField.setText("INGREDIENTE INSERITO");
						ingredientNameField.setText("");
						ingredientCostField.setText("");
					}
					else{
						statusField.setBackground(new Color(255, 0, 0));
						statusField.setText("INGREDIENTE GIA' PRESENTE");
					}
				} catch (IOException e) {
					statusField.setText(e.getMessage());
				}
			}
		});
		btnSave.setBounds(88, 219, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JLabel lblInserisciIngredienteIn = new JLabel("INSERISCI INGREDIENTE IN DB");
		lblInserisciIngredienteIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserisciIngredienteIn.setBounds(12, 13, 245, 16);
		frame.getContentPane().add(lblInserisciIngredienteIn);
		
		statusField = new JTextField();
		statusField.setText("STATUS");
		statusField.setEditable(false);
		statusField.setBounds(29, 184, 201, 22);
		frame.getContentPane().add(statusField);
		statusField.setColumns(10);
		
		JRadioButton rdbtnG = new JRadioButton("g");
		rdbtnG.setBounds(150, 130, 40, 25);
		frame.getContentPane().add(rdbtnG);
		
		JRadioButton rdbtnKg = new JRadioButton("kg");
		rdbtnKg.setBounds(203, 130, 54, 25);
		frame.getContentPane().add(rdbtnKg);
		
		JLabel lblPeso = new JLabel("PESO");
		lblPeso.setBounds(12, 134, 40, 16);
		frame.getContentPane().add(lblPeso);
		
		weightField = new JTextField();
		weightField.setBounds(57, 131, 54, 22);
		frame.getContentPane().add(weightField);
		weightField.setColumns(10);
	}
}
