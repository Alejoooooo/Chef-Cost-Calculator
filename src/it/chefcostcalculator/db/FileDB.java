package it.chefcostcalculator.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import it.chefcostcalculator.core.Ingredient;

public abstract class FileDB {
	public static Ingredient getIngredientByNameFromFile(String filename, String ingredientName) throws IOException{
		FileReader file;
		try {
			file = new FileReader(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IOException("File inesistente");
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
		throw new IOException("Ingrediente non presente");
	}
}
