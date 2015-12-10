package it.chefcostcalculator.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import it.chefcostcalculator.core.Ingredient;

public abstract class FileDB {
	
	public static Ingredient getIngredientFromString(String ingredient){
		return new Ingredient(ingredient.split(":")[0], Double.parseDouble(ingredient.split(":")[1]));
	}
		
	public static Boolean isPresentIngredient(String filename, String ingredientName) throws IOException{
		FileReader file;
		try {
			file = new FileReader(filename);
		} catch (Exception e) {
			throw new IOException("FileNotValid");
		}
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		while(line != null){
			if(line.split(":")[0].equals(ingredientName.toUpperCase())){
				reader.close();
				return true;
			}
			line=reader.readLine();
		}
		reader.close();
		return false;
	}
	
	public static Ingredient getIngredientByNameFromFile(String filename, String ingredientName) throws IOException{
		FileReader file;
		try {
			file = new FileReader(filename);
		} catch (Exception e) {
			throw new IOException("FileNotValid");
		}
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();

		
		while(line != null){
			if(line.split(":")[0].equals(ingredientName)){
				reader.close();
				return new Ingredient(line.split(":")[0], Double.parseDouble(line.split(":")[1]));
			}	
			line = reader.readLine();
		}
		reader.close();
		
		if(line == null){
			throw new IOException("IngredientNotPresent");
		}
		
		return null;
		
}

	public static void insertIngredientToFile(String filename, Ingredient ingredient) throws IOException, IllegalArgumentException{
//		try {
//			getIngredientByNameFromFile(filename, ingredient.getIngredientName());
//		} catch (Exception e) {
////			if(e.getMessage().equals("IngredientNotPresent")){
		PrintWriter out = new PrintWriter(new FileOutputStream(new File(filename), true));
		if(isPresentIngredient(filename, ingredient.getIngredientName())){
			out.close();
			throw new IllegalArgumentException("alreadyPresent");
		}
		
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
		String toInsert="";
		toInsert+=ingredient.getIngredientName() + ":" + ingredient.getIngredientCost();
		toInsert=toInsert.toUpperCase();
		out.println(toInsert);
		out.close();
//			}
//		}
			
}
	
	public static void removeIngredientFromFile(String filename, String ingredientName) throws IOException{
	  	FileReader fr = new FileReader(filename);
	  	String tempFilename = "temp.txt";
	  	
	  	BufferedReader reader = new BufferedReader(fr);
	  	String line = reader.readLine();
	  	while(line != null){
//	  		System.out.println(line);
//	  		System.out.println(getIngredientFromString(line).getIngredientName());
	  		if(!getIngredientFromString(line).getIngredientName().equals(ingredientName.toUpperCase()))
	  			insertIngredientToFile(tempFilename, getIngredientFromString(line));
	  		line = reader.readLine();
	  	}
	  	reader.close();
	  	File tmp = new File(tempFilename);
	  	File src = new File(filename);
	  	src.delete();
	  	tmp.renameTo(src);
	}
	
	public static ArrayList<Ingredient> getIngredientListFromFile(String filename) throws IOException{
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		FileReader file;
		try {
			file = new FileReader(filename);
		} catch (Exception e) {
			throw new IOException("FileNotValid");
		}
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		while(line != null){
			list.add(getIngredientFromString(line));
			line=reader.readLine();
		}
		reader.close();
		return list;
		
	}
}
