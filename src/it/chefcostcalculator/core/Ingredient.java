package it.chefcostcalculator.core;

public class Ingredient {
	private String ingredientName;
	private double ingredientCost;
	/**
	 * @param ingredientName
	 * @param ingredientCost
	 */
	public Ingredient(String ingredientName, double ingredientCost) {
		this.ingredientName = ingredientName;
		this.ingredientCost = ingredientCost;
	}
	/**
	 * @return the ingredientName
	 */
	public String getIngredientName() {
		return ingredientName;
	}
	/**
	 * @param ingredientName the ingredientName to set
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	/**
	 * @return the ingredientCost
	 */
	public double getIngredientCost() {
		return ingredientCost;
	}
	/**
	 * @param ingredientCost the ingredientCost to set
	 */
	public void setIngredientCost(double ingredientCost) {
		this.ingredientCost = ingredientCost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NOME: " + ingredientName + "     COSTO: " + ingredientCost;
	}
	
	

}
