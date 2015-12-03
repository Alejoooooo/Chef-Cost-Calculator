package it.chefcostcalculator.core;


public abstract class Utility {
	public static void printRecipe(Recipe recipe){
		for(Dose o : recipe.getIngredientList()){
			System.out.println(o.getIngredient().getIngredientName() + " " + o.getQuantity());
		}
	}


}
