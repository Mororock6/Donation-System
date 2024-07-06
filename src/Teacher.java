
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
	private Donor donor;
	private TeachingStages EduStage;
	Scanner in=new Scanner(System.in);
	
	public TeachingStages getEduStage() {
		return EduStage;
	}
	public void  setEduStage(TeachingStages eduStage) {
		EduStage = eduStage;
	}
	Teacher(Donor donor)
	{
		this.donor=donor;
	}
	
	
	public void ChooseStage(int c) {
	if(c==1)
	{
		setEduStage(TeachingStages.Primary);
		DonationsLists.addprem(donor);
	}
	if(c==2)
	{
		setEduStage(TeachingStages.Primary);
		DonationsLists.addprep(donor);
	}
	if(c==3)
	{
		setEduStage(TeachingStages.Primary);
		DonationsLists.addsec(donor);
	}
	if(c==4)
	{
		setEduStage(TeachingStages.Primary);
		DonationsLists.adduni(donor);
	}
	}
}
	