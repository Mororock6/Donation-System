
import java.util.ArrayList;
import java.util.Scanner;

public class Hunger extends Donation {
	Scanner in=new Scanner(System.in);
	private ArrayList<Food>food=new ArrayList<>();
	public Hunger(Donor donor) {
		super(donor);
		donor.AddDonation(this);
		DonationsLists.addHung(this);
	}
	
	
	protected void mooneychoosen(double money) {
		super.MoneyInsertion(money);
	}
	
	StringBuilder FoodDonated()
	{
		StringBuilder str=new StringBuilder();
		for(Food e:food)
		{
			str.append(e.toString());
		}
		return str;
	}
	double FoodKG()
	{
		double c=0;
		for(Food e:food)
		{
			c+=e.getAmountKG();
		}
		return c;
	}
	public String toString() {
		if(getDon()==WayOfDonation.money)
		{
			return super.toString()+"he Donated with "+super.getMoneyDonated()+"\n";
	    }
		else if(getDon()==WayOfDonation.food)
		{
			return super.toString()+"he Donated with "+this.FoodDonated()+"\n";
			
		}
		
		return null;
		
	
	}
	public int getFoodQuantity() {
		return food.size();
	}

	@Override
	protected void chooseWayOfDonationfile(int c) {
		if(c==1)
		{
			setDon(WayOfDonation.money);
			System.out.print("Enter how much you are going do donate: ");
			super.MoneyInsertion(in.nextDouble());
		}
		if(c==2)
		{
			setDon(WayOfDonation.food);
		}
	}

	public void FoodChosen(int c,int amountInKG) {
		FoodType foodType=null;
		switch(c){
		case 1:foodType=FoodType.Rice;break;
		case 2:foodType=FoodType.Chicken;break;
		case 3:foodType=FoodType.Meat;break;
		case 4:foodType=FoodType.Fruits;break;
		case 5:foodType=FoodType.Vegetables;break;
		case 6:foodType=FoodType.Dairy;break;
		case 7:foodType=FoodType.Pasta;break;
	}
		food.add(new Food(foodType,amountInKG));
	}
	
}

