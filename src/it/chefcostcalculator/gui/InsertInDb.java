package it.chefcostcalculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		frame.setBounds(100, 100, 283, 187);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeIngredientek = new JLabel("NOME INGREDIENTE");
		lblNomeIngredientek.setBounds(12, 33, 124, 16);
		frame.getContentPane().add(lblNomeIngredientek);
		
		ingredientNameField = new JTextField();
		ingredientNameField.setBounds(141, 30, 116, 22);
		frame.getContentPane().add(ingredientNameField);
		ingredientNameField.setColumns(10);
		
		JLabel lblCostoIngrediente = new JLabel("COSTO INGREDIENTE");
		lblCostoIngrediente.setBounds(12, 68, 124, 16);
		frame.getContentPane().add(lblCostoIngrediente);
		
		ingredientCostField = new JTextField();
		ingredientCostField.setColumns(10);
		ingredientCostField.setBounds(141, 65, 116, 22);
		frame.getContentPane().add(ingredientCostField);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(88, 107, 97, 25);
		frame.getContentPane().add(btnSave);
	}
}
