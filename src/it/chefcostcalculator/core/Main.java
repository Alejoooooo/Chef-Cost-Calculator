package it.chefcostcalculator.core;

import java.io.IOException;
import java.util.ArrayList;

import it.chefcostcalculator.db.FileDB;

public class Main {

	public static void main(String[] args) {
		Ingredient farina = new Ingredient("Farina", 1.5);
		Ingredient burro = new Ingredient("Burro", 2.1);
		Dose farinaDose = new Dose(farina, 150);
		Dose burroDose = new Dose(burro, 200);
		ArrayList<Dose> dosi = new ArrayList<>();
		dosi.add(farinaDose);
		dosi.add(burroDose);
		
		Recipe dolce = new Recipe("Dolce", dosi);
		try {
			Ingredient r = FileDB.getIngredientByNameFromFile("CostDB.txt", "Burro");
			System.out.println(r);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}

		
	}

}
