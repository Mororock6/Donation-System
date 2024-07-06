import java.util.Scanner;

public class Food {
Scanner in=new Scanner(System.in);
	private FoodType foodType;
	private double amountKG;
	
	public Food(FoodType foodType2,double amountInKG) {
		this.setFoodType(foodType2);
		this.setAmountKG(amountInKG);
		DonationsLists.addfood(this);
	}

	public double getAmountKG() {
		return amountKG;
	}

	public void setAmountKG(double amountKG) {
		this.amountKG = amountKG;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType2) {
		this.foodType = foodType2;
	}

	@Override
	public String toString() {
		return "Food [foodType=" + foodType + ", amountKG=" + amountKG + "]";
	}
	
}
