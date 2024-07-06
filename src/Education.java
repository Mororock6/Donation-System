
import java.util.ArrayList;
import java.util.Scanner;

public class Education extends Donation{
	Scanner in=new Scanner(System.in);
	private ArrayList<Books>book=new ArrayList<Books>();
	private Teacher teaches;
	public Education( Donor donor) {
		super(donor);
		DonationsLists.addEdu(this);
		donor.AddDonation(this);
	}
	
	public void chooseWayOfDonation()
	{
		System.out.println("For donating money press 1: ");
		System.out.println("For donating books press 2: ");
		System.out.println("For donating by teaching press 3: ");
		int c=in.nextInt();
		if(c==1)
		{
			setDon(WayOfDonation.money);
			System.out.print("Enter how much you are going do donate: ");
			super.MoneyInsertion(in.nextDouble());
		}
		if(c==2)
		{
			setDon(WayOfDonation.book);
		}
		if(c==3)
		{
			setDon(WayOfDonation.VolunteerTeacher);
		}
	}
	
	StringBuilder booksDonated()
	{
		StringBuilder str=new StringBuilder();
		for(Books e:book)
		{
			str.append(e.toString());
		}
		return str;
	}
	void ChoseTeach(int c)
	{
		
		teaches=new Teacher(donor);
		teaches.ChooseStage(c);
	}


	public String toString() {
		if(getDon()==WayOfDonation.money)
		{
			return super.toString()+donor.getName()+" donated with "+this.getMoneyDonated()+"\n";
	    }
		else if(getDon()==WayOfDonation.book)
		{
			return super.toString()+donor.getName()+" donated with "+this.booksDonated()+"\n";
			
		}
		else if(getDon()==WayOfDonation.VolunteerTeacher)
		{
			return super.toString()+"\nAnd the stage teached is the "+teaches.getEduStage()+"\n";
		}
		return null;
		
	
	}
	public int getBooksQuantity() {
		return Books.getNumOfbooks();
	}
	protected void mooneychoosen(double money) {
		super.MoneyInsertion(money);
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
			setDon(WayOfDonation.book);
		}
		if(c==3)
		{
			setDon(WayOfDonation.VolunteerTeacher);
		}
	}
	void booksChosenfile(int x,String bookk) {
		Books b=new Books();
		if(x==1) {
			b=new Books(bookk,BookType.Education);
	    }
	    else if(x==2) {
	    	b=new Books(bookk,BookType.Entertainment);
	    }
		book.add(b);
	}
}
