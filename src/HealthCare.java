

import java.util.ArrayList;
import java.util.Scanner;

public class HealthCare extends Donation {
Scanner in=new Scanner(System.in);
    private ArrayList<Medicine> medicine=new ArrayList<Medicine>();
    private Doctor doctor;
    public HealthCare(Donor donor) {
        super(donor);
        donor.AddDonation(this);
        DonationsLists.addMedical(this);
    }
    protected void mooneychoosen(double money) {
		super.MoneyInsertion(money);
	}

    void medicineChosen(){
        String name;
        MedicineType type = null;
       int c=0;
       do {
    	   System.out.print("If the medicine you are going to donate is Antibiotics press 1\nIf the medicine you are going to donate is Cream press 2\nIf the medicine you are going to donate is Inhalers press 3\nIf the medicine you are going to donate is Drops press 4\nIf the medicine you are going to donate is Injections press 5\nIf the medicine you are going to donate is Patches press 6\nIf the medicine you are going to donate is Tablets press 7\n");
    	   int x=in.nextInt();
    	   switch(x){
    		   case 1:type=MedicineType.Antibiotics;break;
    		   case 2:type=MedicineType.Cream;break;
    		   case 3:type=MedicineType.Drops;break;
    		   case 4:type=MedicineType.Inhalers;break;
    		   case 5:type=MedicineType.Injections;break;
    		   case 6:type=MedicineType.Patches;break;
    		   case 7:type=MedicineType.Tablets;break;
    		   default:System.out.print("Invalid option");
    	   }
    	   System.out.print("Enter name of medicine: ");
    	   name=in.nextLine();
    	   medicine.add(new Medicine(type,name));
    	   System.out.print("If you want to donate with other medicine press 0: ");
    	   c=in.nextInt();
       }while(c==0);
       
    }
    StringBuilder MedicineDonated()
	{
		StringBuilder str=new StringBuilder();
		for(Medicine e:medicine)
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
		else if(getDon()==WayOfDonation.medicine)
		{
			return super.toString()+donor.getName()+" donated with "+this.MedicineDonated()+"\n";
			
		}
		else if(getDon()==WayOfDonation.VolunteerDoctor)
		{
			return super.toString()+donor.getName()+" specilizes as a "+doctor.getSpecialization()+"\n";
		}
		return null;
		
	
	}

	public int getMedicineQuantity() {
		return medicine.size();
	}

	@Override
	protected void chooseWayOfDonationfile(int c) {
		 if(c==1) {
	            setDon(WayOfDonation.money);
	            System.out.print("Enter how much you are going do donate: ");
	            super.MoneyInsertion(in.nextDouble());
	        }
	        else if(c==2) {
	            setDon(WayOfDonation.medicine);
	        }
	        else if(c==3)
	        {
	        	setDon(WayOfDonation.VolunteerDoctor);
	        }
	}
	public void medicineChosen(int c,String name) {
		MedicineType type=null;
		switch(c) {
			case 1:type=MedicineType.Antibiotics;break;
			case 2:type=MedicineType.Cream;break;
			case 3:type=MedicineType.Drops;break;
			case 4:type=MedicineType.Inhalers;break;
			case 5:type=MedicineType.Injections;break;
			case 6:type=MedicineType.Patches;break;
			case 7:type=MedicineType.Tablets;break;
			default:System.out.print("Invalid option");
		
		}
		name=in.nextLine();
		medicine.add(new Medicine(type,name));
	}
	public void DoctorSpecialization(int c) {
		doctor=new Doctor(donor);
    	doctor.ChooseSpecialization(c);
	}
}
