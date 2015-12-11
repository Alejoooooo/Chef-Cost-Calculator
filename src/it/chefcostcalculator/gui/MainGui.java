package it.chefcostcalculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.chefcostcalculator.core.Ingredient;
import it.chefcostcalculator.db.FileDB;
import jdk.nashorn.internal.runtime.ListAdapter;

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
	private ArrayList<Ingredient> listIngredient = new ArrayList<>();
	private JTextArea textAreaIngredients;
	private JTextArea textAreaPrices ;
	private JTextField textFieldOldCost;
	private JTextField textFieldNewCost;
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
		
		JPanel panelModifyIngredient = new JPanel();
		frame.getContentPane().add(panelModifyIngredient, "name_1752416106886");
		panelModifyIngredient.setLayout(null);
		
		JButton btnInserisciIngrediente = new JButton("INSERISCI INGREDIENTE");
		btnInserisciIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAddIngredient.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnInserisciIngrediente.setBounds(197, 177, 235, 25);
		panelMain.add(btnInserisciIngrediente);
		
		JButton btnMostraIngredienti = new JButton("MOSTRA INGREDIENTI");
		btnMostraIngredienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTextArea();
				panelShowIngredientsInFile.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnMostraIngredienti.setBounds(197, 218, 235, 25);
		panelMain.add(btnMostraIngredienti);
		
		JButton btnModificaIngrediente = new JButton("MODIFICA INGREDIENTE");
		btnModificaIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModifyIngredient.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		btnModificaIngrediente.setBounds(197, 259, 235, 25);
		panelMain.add(btnModificaIngrediente);
		
		JButton btnCalcolaCostoRicetta = new JButton("CALCOLA COSTO RICETTA");
		btnCalcolaCostoRicetta.setBounds(197, 304, 235, 25);
		panelMain.add(btnCalcolaCostoRicetta);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("title2.png"));
		label.setBounds(12, 38, 563, 106);
		panelMain.add(label);
		
//		JButton btnTest = new JButton("TEST");
//		btnTest.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				panel.setVisible(true);
//				panelMain.setVisible(false);
//			}
//		});
//		btnTest.setBounds(465, 217, 97, 25);
//		panelMain.add(btnTest);
		
		JLabel lblNewLabel = new JLabel("INGREDIENTE");
		lblNewLabel.setBounds(152, 47, 88, 16);
		panelAddIngredient.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PREZZO");
		lblNewLabel_1.setBounds(152, 89, 88, 16);
		panelAddIngredient.add(lblNewLabel_1);
		
		textFieldIngredient = new JTextField();
		textFieldIngredient.setBounds(321, 44, 234, 22);
		panelAddIngredient.add(textFieldIngredient);
		textFieldIngredient.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(321, 86, 73, 22);
		panelAddIngredient.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		String[] measures = {"g", "Kg"};
		JComboBox comboBoxMeasure = new JComboBox(measures);
		comboBoxMeasure.setBounds(321, 142, 73, 22);
		panelAddIngredient.add(comboBoxMeasure);
		
		JLabel lblNewLabel_2 = new JLabel("UNITA' DI MISURA");
		lblNewLabel_2.setBounds(152, 144, 110, 16);
		panelAddIngredient.add(lblNewLabel_2);
		
		JLabel lblQuantita = new JLabel("QUANTITA'");
		lblQuantita.setBounds(152, 200, 88, 16);
		panelAddIngredient.add(lblQuantita);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(321, 197, 73, 22);
		panelAddIngredient.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JButton btnAnnulla = new JButton("ANNULLA");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelAddIngredient.setVisible(false);
			}
		});
		btnAnnulla.setBounds(192, 265, 97, 25);
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

				} catch (Exception e1) {
					panelIngredientAlreadyPresent.setVisible(true);
					panelAddIngredient.setVisible(false);
				}
			}
		});
		btnSalva.setBounds(321, 265, 97, 25);
		panelAddIngredient.add(btnSalva);
		
		JLabel lblIngredienteInseritoCorrettamente = new JLabel("INGREDIENTE INSERITO CORRETTAMENTE");
		lblIngredienteInseritoCorrettamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredienteInseritoCorrettamente.setBounds(0, 97, 605, 16);
		panelIngredientAddedToFile.add(lblIngredienteInseritoCorrettamente);
		
		JButton btnTornaAlMenu = new JButton("INDIETRO");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddIngredient.setVisible(true);
				panelIngredientAddedToFile.setVisible(false);
			}
		});
		btnTornaAlMenu.setBounds(224, 213, 163, 25);
		panelIngredientAddedToFile.add(btnTornaAlMenu);
		
		JLabel lblIngredienteGiaPresente = new JLabel("INGREDIENTE GIA' PRESENTE");
		lblIngredienteGiaPresente.setForeground(Color.RED);
		lblIngredienteGiaPresente.setBackground(Color.LIGHT_GRAY);
		lblIngredienteGiaPresente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredienteGiaPresente.setBounds(0, 97, 605, 16);
		panelIngredientAlreadyPresent.add(lblIngredienteGiaPresente);
		
		JButton btnBackToMenu = new JButton("INDIETRO");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddIngredient.setVisible(true);
				panelIngredientAlreadyPresent.setVisible(false);
			}
		});
		btnBackToMenu.setBounds(225, 213, 168, 25);
		panelIngredientAlreadyPresent.add(btnBackToMenu);
		
		textAreaIngredients = new JTextArea();
		textAreaIngredients.setEditable(false);
		textAreaIngredients.setBounds(12, 30, 144, 292);
		panelShowIngredientsInFile.add(textAreaIngredients);
//		updateList();
		
		textAreaPrices = new JTextArea();
		textAreaPrices.setEditable(false);
		textAreaPrices.setBounds(168, 30, 96, 292);
		panelShowIngredientsInFile.add(textAreaPrices);
		updateTextArea();
		
		JButton btnMenu = new JButton("TORNA AL MENU PRINCIPALE");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelShowIngredientsInFile.setVisible(false);
			}
		});
		btnMenu.setBounds(324, 297, 233, 25);
		panelShowIngredientsInFile.add(btnMenu);
		
		JLabel lblIngredienti = new JLabel("INGREDIENTI");
		lblIngredienti.setBounds(44, 13, 87, 16);
		panelShowIngredientsInFile.add(lblIngredienti);
		
		JLabel lblPrezzo = new JLabel("PREZZO");
		lblPrezzo.setBounds(190, 13, 56, 16);
		panelShowIngredientsInFile.add(lblPrezzo);
		
		JButton btnTornaAlMenu_2 = new JButton("TORNA AL MENU PRINCIPALE");
		btnTornaAlMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelModifyIngredient.setVisible(false);
			}
		});
		btnTornaAlMenu_2.setBounds(331, 309, 232, 25);
		panelModifyIngredient.add(btnTornaAlMenu_2);
		
		JLabel lblNomeIngrediente = new JLabel("NOME INGREDIENTE");
		lblNomeIngrediente.setBounds(78, 91, 155, 16);
		panelModifyIngredient.add(lblNomeIngrediente);
		
		String[] listName = FileDB.getIngredientNameArrayFromFile("CostDB.txt");
		JComboBox comboBoxIngredientName = new JComboBox(listName);
		comboBoxIngredientName.setBounds(290, 88, 215, 22);
		panelModifyIngredient.add(comboBoxIngredientName);
				
		JLabel lblPrezzoAttuale = new JLabel("PREZZO ATTUALE");
		lblPrezzoAttuale.setBounds(78, 155, 135, 16);
		panelModifyIngredient.add(lblPrezzoAttuale);
		
		JLabel lblNuovoPrezzo = new JLabel("NUOVO PREZZO");
		lblNuovoPrezzo.setBounds(78, 221, 106, 16);
		panelModifyIngredient.add(lblNuovoPrezzo);
		
		textFieldOldCost = new JTextField();
		textFieldOldCost.setEditable(false);
		textFieldOldCost.setBounds(290, 152, 116, 22);
		panelModifyIngredient.add(textFieldOldCost);
		textFieldOldCost.setColumns(10);
		String nameIngredient = (String) comboBoxIngredientName.getSelectedItem();
		String costIngredient = null;
		
		try {
			costIngredient = String.valueOf(FileDB.getIngredientByNameFromFile("CostDB.txt", nameIngredient).getIngredientCost());
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		textFieldOldCost.setText(costIngredient);
		
		textFieldNewCost = new JTextField();
		textFieldNewCost.setBounds(290, 218, 116, 22);
		panelModifyIngredient.add(textFieldNewCost);
		textFieldNewCost.setColumns(10);
		
		Ingredient[] ingredientArray = null;
		try {
			ArrayList<Ingredient> ingredientArrayList = FileDB.getIngredientListFromFile("CostDB.txt");
			ingredientArray = ingredientArrayList.toArray(new Ingredient[ingredientArrayList.size()]);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

//	private String[] createNameListCombo() {
//		// TODO Auto-generated method stub
//		
//	}

	private void updateTextArea() {
		try {
			listIngredient = FileDB.getIngredientListFromFile("CostDB.txt");

			String ingredientsToShow = "";
			String pricesToShow = "";
			for(int i = 0; i < listIngredient.size();i++){
				ingredientsToShow += listIngredient.get(i).getIngredientName() + "\n";
				pricesToShow += String.valueOf(listIngredient.get(i).getIngredientCost()) + "\n";
			}
			textAreaIngredients.setText(ingredientsToShow);
			textAreaPrices.setText(pricesToShow);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
