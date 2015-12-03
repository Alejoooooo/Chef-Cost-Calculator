package it.chefcostcalculator.core;

import java.util.ArrayList;

public class Recipe {
	private String recipeName;
	private ArrayList<Dose> ingredientList;
	/**
	 * @param recipeName
	 * @param ingredientList
	 */
	public Recipe(String recipeName, ArrayList<Dose> ingredientList) {
		this.recipeName = recipeName;
		this.ingredientList = ingredientList;
	}
	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}
	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	/**
	 * @return the ingredientList
	 */
	public ArrayList<Dose> getIngredientList() {
		return ingredientList;
	}
	/**
	 * @param ingredientList the ingredientList to set
	 */
	public void setIngredientList(ArrayList<Dose> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	

}
