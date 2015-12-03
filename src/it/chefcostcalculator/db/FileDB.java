package it.chefcostcalculator.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import it.chefcostcalculator.core.Ingredient;

public abstract class FileDB {
	public static Ingredient getIngredientByNameFromFile(String filename, String ingredientName) throws IOException{
		FileReader file;
		try {
			file = new FileReader(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IOException("FileNotValid");
		}
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		if(line.split(":")[0].equals(ingredientName)){
			reader.close();
			return new Ingredient(line.split(":")[0], Double.parseDouble(line.split(":")[1]));
		}
		
		while(line != null  && !line.split(":")[0].equals(ingredientName)){
//			System.out.println(line);
			line=reader.readLine();
		}
		
		if(line != null){
			reader.close();
			return new Ingredient(line.split(":")[0], Double.parseDouble(line.split(":")[1]));
		}
		
		reader.close();
		throw new IOException("IngredientNotPresent");
	}

	public static void ingredientToFile(String filename, Ingredient ingredient) throws IOException{
		try {
			getIngredientByNameFromFile(filename, ingredient.getIngredientName());
		} catch (Exception e) {
			if(e.getMessage().equals("IngredientNotPresent")){
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("CostDB.txt", true)));
				out.println(ingredient.getIngredientName() + ":" + ingredient.getIngredientCost());
				out.close();
			}
		}
			
	}
}
