package it.chefcostcalculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.chefcostcalculator.core.Ingredient;
import it.chefcostcalculator.db.FileDB;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainGui {

	private JFrame frame;
	private JTextField textFieldIngredient;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
//	private JPanel panelMain;
//	private JPanel panelAddIngredient;
//	private JPanel panelIngredientAddedToFile;
//	private JPanel panelIngredientAlreadyPresent;

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
		frame.setBounds(100, 100, 450, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelMain = new JPanel();
		frame.getContentPane().add(panelMain, "name_1529133498428");
		panelMain.setLayout(null);
		
		JPanel panelAddIngredient = new JPanel();
		frame.getContentPane().add(panelAddIngredient, "name_1136411250386");
		panelAddIngredient.setLayout(null);
		
		JPanel panelIngredientAddedToFile = new JPanel();
		frame.getContentPane().add(panelIngredientAddedToFile, "name_2376758943563");
		panelIngredientAddedToFile.setLayout(null);

		JPanel panelIngredientAlreadyPresent = new JPanel();
		frame.getContentPane().add(panelIngredientAlreadyPresent, "name_4788555646788");
		panelIngredientAlreadyPresent.setLayout(null);
		
		JButton btnInserisciIngrediente = new JButton("INSERISCI INGREDIENTE");
		btnInserisciIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAddIngredient.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnInserisciIngrediente.setBounds(98, 49, 235, 25);
		panelMain.add(btnInserisciIngrediente);
		
		JButton btnMostraIngredienti = new JButton("MOSTRA INGREDIENTI");
		btnMostraIngredienti.setBounds(98, 127, 235, 25);
		panelMain.add(btnMostraIngredienti);
		
		JButton btnModificaIngrediente = new JButton("MODIFICA INGREDIENTE");
		btnModificaIngrediente.setBounds(98, 209, 235, 25);
		panelMain.add(btnModificaIngrediente);
		
		JButton btnCalcolaCostoRicetta = new JButton("CALCOLA COSTO RICETTA");
		btnCalcolaCostoRicetta.setBounds(98, 293, 235, 25);
		panelMain.add(btnCalcolaCostoRicetta);
		
		JLabel lblNewLabel = new JLabel("INGREDIENTE");
		lblNewLabel.setBounds(56, 47, 88, 16);
		panelAddIngredient.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PREZZO");
		lblNewLabel_1.setBounds(56, 89, 88, 16);
		panelAddIngredient.add(lblNewLabel_1);
		
		textFieldIngredient = new JTextField();
		textFieldIngredient.setBounds(186, 44, 234, 22);
		panelAddIngredient.add(textFieldIngredient);
		textFieldIngredient.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(186, 86, 73, 22);
		panelAddIngredient.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		String[] measures = {"g", "Kg"};
		JComboBox comboBoxMeasure = new JComboBox(measures);
		comboBoxMeasure.setEditable(true);
		comboBoxMeasure.setBounds(186, 141, 73, 22);
		panelAddIngredient.add(comboBoxMeasure);
		
		JLabel lblNewLabel_2 = new JLabel("UNITA' DI MISURA");
		lblNewLabel_2.setBounds(56, 144, 110, 16);
		panelAddIngredient.add(lblNewLabel_2);
		
		JLabel lblQuantita = new JLabel("QUANTITA'");
		lblQuantita.setBounds(56, 200, 88, 16);
		panelAddIngredient.add(lblQuantita);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(186, 197, 73, 22);
		panelAddIngredient.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JButton btnAnnulla = new JButton("ANNULLA");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelAddIngredient.setVisible(false);
			}
		});
		btnAnnulla.setBounds(56, 265, 97, 25);
		panelAddIngredient.add(btnAnnulla);
		
		JButton btnSalva = new JButton("SALVA");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double price = new Double(0);
				if(comboBoxMeasure.getSelectedItem() == "g"){
					price = (100 / Double.parseDouble(textFieldQuantity.getText())) * Double.parseDouble(textFieldPrice.getText());
				}
				if(comboBoxMeasure.getSelectedItem() == "Kg"){
					price = (Double.parseDouble(textFieldQuantity.getText()) / 10) * Double.parseDouble(textFieldPrice.getText());
				}
				Ingredient toFile = new Ingredient(textFieldIngredient.getText(), price);
				try {
					FileDB.ingredientToFile("CostDB.txt", toFile);
					panelIngredientAddedToFile.setVisible(true);
					panelAddIngredient.setVisible(false);
//				} catch (IOException e1) {
//					System.out.println(e1.getMessage());
//					panelIngredientAlreadyPresent.setVisible(true);
//					panelAddIngredient.setVisible(false);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					panelIngredientAlreadyPresent.setVisible(true);
					panelAddIngredient.setVisible(false);
				}
			}
		});
		btnSalva.setBounds(241, 265, 97, 25);
		panelAddIngredient.add(btnSalva);
		
		JLabel lblIngredienteInseritoCorrettamente = new JLabel("INGREDIENTE INSERITO CORRETTAMENTE");
		lblIngredienteInseritoCorrettamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredienteInseritoCorrettamente.setBounds(12, 135, 408, 16);
		panelIngredientAddedToFile.add(lblIngredienteInseritoCorrettamente);
		
		JButton btnTornaAlMenu = new JButton("TORNA AL MENU PRINCIPALE");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelIngredientAddedToFile.setVisible(false);
			}
		});
		btnTornaAlMenu.setBounds(12, 177, 408, 25);
		panelIngredientAddedToFile.add(btnTornaAlMenu);
		
		JLabel lblIngredienteGiaPresente = new JLabel("INGREDIENTE GIA' PRESENTE");
		lblIngredienteGiaPresente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredienteGiaPresente.setBounds(12, 99, 408, 16);
		panelIngredientAlreadyPresent.add(lblIngredienteGiaPresente);
		
		JButton btnBackToMenu = new JButton("TORNA AL MENU PRINCIPALE");
		btnBackToMenu.setBounds(12, 169, 408, 25);
		panelIngredientAlreadyPresent.add(btnBackToMenu);
	}
}
