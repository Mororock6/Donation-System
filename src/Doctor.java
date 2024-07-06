
import java.util.Scanner;

public class Doctor {
	Scanner in=new Scanner(System.in);

	private Donor donor;
	private doctorSpec Specialization;
	public Doctor(Donor donor) {
		this.donor=donor;
	}
	
	public doctorSpec getSpecialization() {
		return Specialization;
	}

	@Override
	public String toString() {
		return donor.toString()+ " Specialization=" + Specialization;
	}

	public void setSpecialization(doctorSpec specialization) {
		Specialization = specialization;
	}

	public void ChooseSpecialization(int c) {
		if(c==1)
		{
			setSpecialization(doctorSpec.Surgeon);
			DonationsLists.addsurg(donor);
		}
		if(c==2)
		{
			setSpecialization(doctorSpec.Neorologist);
			DonationsLists.addneor(donor);
		}
		if(c==3)
		{
			setSpecialization(doctorSpec.Cardiologist);
			DonationsLists.addcardiologist(donor);
		}
	}
	
}