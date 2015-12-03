/**
 * 
 */
package it.chefcostcalculator.core;

/**
 * @author Alejoooooo
 *
 */
public class Dose {
	private Ingredient ingredient;
	private double quantity;
	/**
	 * @param ingredient
	 * @param quantity
	 */
	public Dose(Ingredient ingredient, double quantity) {
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	/**
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}
	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	

}
