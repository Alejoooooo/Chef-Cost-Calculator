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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MainGui {

	private JFrame frame;
	private JTextField textFieldIngredient;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textField;
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
		frame.setBounds(100, 100, 605, 394);
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
		
		JPanel panelShowIngredientsInFile = new JPanel();
		frame.getContentPane().add(panelShowIngredientsInFile, "name_11509410566825");
		panelShowIngredientsInFile.setLayout(null);
		
		JPanel panelTest = new JPanel();
		frame.getContentPane().add(panelTest, "name_2278138541588");
		panelTest.setLayout(null);
		
		JButton btnInserisciIngrediente = new JButton("INSERISCI INGREDIENTE");
		btnInserisciIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAddIngredient.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnInserisciIngrediente.setBounds(172, 179, 235, 25);
		panelMain.add(btnInserisciIngrediente);
		
		JButton btnMostraIngredienti = new JButton("MOSTRA INGREDIENTI");
		btnMostraIngredienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelShowIngredientsInFile.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnMostraIngredienti.setBounds(172, 217, 235, 25);
		panelMain.add(btnMostraIngredienti);
		
		JButton btnModificaIngrediente = new JButton("MODIFICA INGREDIENTE");
		btnModificaIngrediente.setBounds(172, 255, 235, 25);
		panelMain.add(btnModificaIngrediente);
		
		JButton btnCalcolaCostoRicetta = new JButton("CALCOLA COSTO RICETTA");
		btnCalcolaCostoRicetta.setBounds(172, 296, 235, 25);
		panelMain.add(btnCalcolaCostoRicetta);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\rapon\\Documents\\GitHub\\Chef-Cost-Calculator\\title2.png"));
		label.setBounds(12, 38, 563, 106);
		panelMain.add(label);
		
		JButton btnTest = new JButton("TEST");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelTest.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnTest.setBounds(465, 217, 97, 25);
		panelMain.add(btnTest);
		
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
				Double price = 0.0;
				if(comboBoxMeasure.getSelectedItem() == "g"){
					price = (100 / Double.parseDouble(textFieldQuantity.getText())) * Double.parseDouble(textFieldPrice.getText());
				}
				if(comboBoxMeasure.getSelectedItem() == "Kg"){
					price = (Double.parseDouble(textFieldQuantity.getText()) / 10) * Double.parseDouble(textFieldPrice.getText());
				}
//				This is for rounding the price at two decimals
				price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
				
				Ingredient toFile = new Ingredient(textFieldIngredient.getText(), price);
				try {
					FileDB.insertIngredientToFile("CostDB.txt", toFile);
					panelIngredientAddedToFile.setVisible(true);
					panelAddIngredient.setVisible(false);
//				} catch (IOException e1) {
//					System.out.println(e1.getMessage());
//					panelIngredientAlreadyPresent.setVisible(true);
//					panelAddIngredient.setVisible(false);
				} catch (Exception e1) {
//					System.out.println(e1.getMessage());
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
		lblIngredienteGiaPresente.setForeground(Color.RED);
		lblIngredienteGiaPresente.setBackground(Color.LIGHT_GRAY);
		lblIngredienteGiaPresente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredienteGiaPresente.setBounds(12, 99, 408, 16);
		panelIngredientAlreadyPresent.add(lblIngredienteGiaPresente);
		
		JButton btnBackToMenu = new JButton("TORNA AL MENU PRINCIPALE");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelIngredientAlreadyPresent.setVisible(false);
			}
		});
		btnBackToMenu.setBounds(12, 169, 408, 25);
		panelIngredientAlreadyPresent.add(btnBackToMenu);
		
		JTextArea textAreaIngredients = new JTextArea();
		textAreaIngredients.setEditable(false);
		textAreaIngredients.setBounds(12, 30, 144, 292);
		panelShowIngredientsInFile.add(textAreaIngredients);
		try {
			ArrayList<Ingredient> listIngredient = FileDB.getIngredientListFromFile("CostDB.txt");
			String ingredientsToShow = "";
			for(Ingredient i : listIngredient){
				ingredientsToShow += i.getIngredientName() + "\n";
			}
			textAreaIngredients.setText(ingredientsToShow);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JTextArea textAreaPrices = new JTextArea();
		textAreaPrices.setEditable(false);
		textAreaPrices.setBounds(168, 30, 96, 292);
		panelShowIngredientsInFile.add(textAreaPrices);
		try {
			ArrayList<Ingredient> listIngredient = FileDB.getIngredientListFromFile("CostDB.txt");
			String pricesToShow = "";
			for(Ingredient i : listIngredient){
				pricesToShow += i.getIngredientCost() + "\n";
			}
			textAreaPrices.setText(pricesToShow);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelShowIngredientsInFile.setVisible(false);
			}
		});
		btnMenu.setBounds(304, 170, 97, 25);
		panelShowIngredientsInFile.add(btnMenu);
		
		JLabel lblIngredienti = new JLabel("INGREDIENTI");
		lblIngredienti.setBounds(44, 13, 87, 16);
		panelShowIngredientsInFile.add(lblIngredienti);
		
		JLabel lblPrezzo = new JLabel("PREZZO");
		lblPrezzo.setBounds(190, 13, 56, 16);
		panelShowIngredientsInFile.add(lblPrezzo);
		
		JPanel panelModifyIngredient = new JPanel();
		frame.getContentPane().add(panelModifyIngredient, "name_1752416106886");
		panelModifyIngredient.setLayout(null);
		
//		ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
//		ingredientList = FileDB.getIngredientListFromFile("CostDB.txt");
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 152, 150, 22);
		panelModifyIngredient.add(comboBox);
		
		JLabel lblIngrediente = new JLabel("INGREDIENTE");
		lblIngrediente.setBounds(111, 127, 130, 16);
		panelTest.add(lblIngrediente);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(225, 124, 181, 22);
		panelTest.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(203, 208, 116, 22);
		panelTest.add(textField);
		textField.setColumns(10);
		
		JButton btnTornaAlMenu_1 = new JButton("TORNA AL MENU PRINCIPALE");
		btnTornaAlMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(true);
				panelTest.setVisible(false);
			}
		});
		btnTornaAlMenu_1.setBounds(111, 284, 208, 25);
		panelTest.add(btnTornaAlMenu_1);
	}
}
