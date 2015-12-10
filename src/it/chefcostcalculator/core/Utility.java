package it.chefcostcalculator.core;

import java.util.ArrayList;

public abstract class Utility {
	public static void printRecipe(Recipe recipe){
		for(Dose o : recipe.getIngredientList()){
			System.out.println(o.getIngredient().getIngredientName() + " " + o.getQuantity());
		}
	}
	
	public static void printIngredientList(ArrayList<Ingredient> list){
		for(Ingredient i : list){
			System.out.println(i.getIngredientName() + "     " + i.getIngredientCost());
		}
	}


}
