import java.util.ArrayList;
import java.util.Scanner;

public class Poverty extends Donation{
	Scanner in=new Scanner(System.in);
	private ArrayList<Clothes> clothes=new ArrayList<Clothes>();
	public Poverty(Donor donor) {
		super(donor);
		DonationsLists.addPov(this);
		donor.AddDonation(this);
	}
	public void ClothesChosen(int x,int y) {
		ClotheType clotheType = null;
		ClotheSize clotheSize = null;
		switch(x) {
		case 0:clotheType=ClotheType.Shirt;break;
		case 1:clotheType=ClotheType.Pants;break;
		case 2:clotheType=ClotheType.Coat;break;
		case 3:clotheType=ClotheType.Shorts;break;
		case 4:clotheType=ClotheType.Jacket;break;
		case 5:clotheType=ClotheType.Hats;break;
		}
		switch(y) {
		case 0:clotheSize=ClotheSize.Xsmall;break;
		case 1:clotheSize=ClotheSize.Small;break;
		case 2:clotheSize=ClotheSize.Medium;break;
		case 3:clotheSize=ClotheSize.Large;break;
		case 4:clotheSize=ClotheSize.Xlarge;break;
		
		}
 clothes.add(new Clothes(clotheType,clotheSize)) ;
	}

	StringBuilder ClothesDonated()
	{
		StringBuilder str=new StringBuilder();
		for(Clothes e:clothes)
		{
			str.append(e.toString());
		}
		return str;
	}
	public String toString() {
		if(getDon()==WayOfDonation.money)
		{
			return super.toString()+donor.getName()+" donated with "+super.getMoneyDonated()+"\n";
	    }
		else if(getDon()==WayOfDonation.Clothes)
		{
			return super.toString()+donor.getName()+" donated with "+this.ClothesDonated()+"\n";
			
		}
		
		return null;
	}

	public int getClothesQuantity() {
		return clothes.size();
	}
	@Override
	protected void chooseWayOfDonationfile(int c) {
		if(c==1)
		{
			setDon(WayOfDonation.money);
		}
		if(c==2)
		{
			setDon(WayOfDonation.Clothes);
		}
	}
	protected void mooneychoosen(double money) {
		super.MoneyInsertion(money);
	}
}
