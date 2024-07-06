import java.util.ArrayList;
import java.util.Collections;


public class DonationsLists {
	private static ArrayList<Donor> Surgeon=new ArrayList<>();
	private static ArrayList<Donor> Neorologist=new ArrayList<>();
	private static ArrayList<Donor> Cardiologist=new ArrayList<>();
	private static ArrayList<Education> EduDonations=new ArrayList<>();
	private static ArrayList<Poverty> PovertyDonations=new ArrayList<>();
	private static ArrayList<Hunger> HungerDonations=new ArrayList<>();
	private static ArrayList<HealthCare> Health=new ArrayList<>();
	private static ArrayList<Donor> Donors=new ArrayList<>();
	private static ArrayList<Donor> preparatory=new ArrayList<Donor>();
	private static ArrayList<Donor> primary= new ArrayList<Donor>();
	private static ArrayList<Donor> secondry= new ArrayList<Donor>();
	private static ArrayList<Donor> universty= new ArrayList<Donor>();
	private static ArrayList<Food> foods= new ArrayList<Food>();
	private static ArrayList<Clothes> clothe=new ArrayList<>();
	private static ArrayList<Books> book=new ArrayList<Books>();
	private static ArrayList<Medicine> meds=new ArrayList<>();
	static void addfood(Food e) {
		foods.add(e);
	}
	static void addMeds(Medicine e) {
		meds.add(e);
	}
	static void remove(Food e) {
		if(foods.contains(e)) {
			foods.remove(foods.indexOf(e));
		}
	}
	static void addEdu(Education e){
		EduDonations.add(e);
	}
	static Donor getDon(int index) {
		return Donors.get(index);
	}
	static void addDonor(Donor e) {
		Donors.add(e);
	}
	static void addPov(Poverty e){
		PovertyDonations.add(e);
	}
	static void addHung(Hunger e){
		HungerDonations.add(e);
	}
	static void addMedical(HealthCare e){
		Health.add(e);
	}
	static void removeEdu(Education e){
		if(EduDonations.contains(e)) {
			int i=EduDonations.indexOf(e);
			EduDonations.remove(i);
		}
	}
	static void removeDonor(Donor e) {
		if(Donors.contains(e)) {
			int i=Donors.indexOf(e);
			Donors.remove(i);
		}
	}
	static void removePov(Poverty e){
		if(PovertyDonations.contains(e)) {
			int i=PovertyDonations.indexOf(e);
			PovertyDonations.remove(i);
		}
	}
	static void removeHung(Hunger e){
		if(HungerDonations.contains(e)) {
			int i=HungerDonations.indexOf(e);
			HungerDonations.remove(i);
		}
	}
	static void removeMedical(HealthCare e){
		if(Health.contains(e)) {
			int i=Health.indexOf(e);
			Health.remove(i);
		}
	}
	public StringBuilder EducationDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumEducationDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Education e:EduDonations)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder povertyDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumPovDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Poverty e:PovertyDonations)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder MedicalDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumMedicalCareDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(HealthCare e:Health)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder HungerDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumHungerDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Hunger e:HungerDonations)
		{
			str.append(e.toString());
		}
		return str;
	}
	
	
	public int NumPovDonations()
	{
		return PovertyDonations.size();
	}
	public int NumHungerDonations()
	{
		return HungerDonations.size();
	}
	public int NumMedicalCareDonations()
	{
		return Health.size();
	}
	public int NumEducationDonations()
	{
		return EduDonations.size();
	}
	public double MoneyEducationDonations()
	{
		double c=0;
		for(Education e:EduDonations)
		{
			c+=e.getMoneyDonated();
		}
		return c;
	}
	public int BooksEducationDonations()
	{
		return book.size();
	}
	public double MoneyPovertDonations()
	{
		double c=0;
		for(Poverty e:PovertyDonations)
		{
			c+=e.getMoneyDonated();
		}
		return c;
	}
	public int clothesPovertDonations()
	{
		return clothe.size();
	}
	public double FoodKGHungerDonations()
	{
		double c=0;
		for(Hunger e:HungerDonations)
		{
			c+=e.FoodKG();
		}
		return c;
	}
	public double MoneyHungerDonations()
	{
		double c=0;
		for(Hunger e:HungerDonations)
		{
			c+=e.getMoneyDonated();
		}
		return c;
	}
	public double MoneyHealthCareDonations()
	{
		double c=0;
		for(HealthCare e:Health)
		{
			c+=e.getMoneyDonated();
		}
		return c;
	}
	public StringBuilder TopDonors() {
		StringBuilder str = new StringBuilder();
		Collections.sort(Donors);
		Collections.reverse(Donors);
		for(Donor e: Donors)
		{
			str.append(e.toString());
		}
		return str;
	}
	public int NumCardiologistDonation(){ return Cardiologist.size();}
	public int NumNeorologistDonation(){ return Neorologist.size();}
	public int NumSurgeonDonation(){ return Surgeon.size();}
	public StringBuilder SurgeonDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumSurgeonDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:Surgeon)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder NeurologistDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumNeorologistDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:Neorologist)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder CardiologistDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumCardiologistDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:Cardiologist)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder PrimaryDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumPrimDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:primary)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder PrepDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumPrepDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:preparatory)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder SecDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumSecDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:secondry)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder UniDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumUniDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donor e:universty)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder MedsDonations()
	{
		StringBuilder str=new StringBuilder();
		if(NumMedsDonation()==0)
		{
			return str.append("No Donations were made");
		}
		for(Medicine e:meds)
		{
			str.append(e.toString());
		}
		return str;
	}
	 public int NumMedsDonation() {
		return meds.size();
	}
	int NumFoods() {
		return foods.size();
	}
	public int NumPrimDonation() {
		return primary.size();
	}
	public int NumPrepDonation() {
		return preparatory.size();
	}
	public int NumSecDonation() {
		return secondry.size();
	}
	public int NumUniDonation() {
		return universty.size();
	}
	static void addprem(Donor e) {
		primary.add(e);
	}
	static void addprep(Donor e) {
		preparatory.add(e);
	}
	static void addsec(Donor e) {
		secondry.add(e);
	}
	static void adduni(Donor e) {
		universty.add(e);
	}
	static void addsurg(Donor e) {
		Surgeon.add(e);
	}
	static void addneor(Donor e) {
		Neorologist.add(e);
	}
	static void addcardiologist(Donor e) {
		Cardiologist.add(e);
	}
	public StringBuilder ClothesDonations()
	{
		StringBuilder str=new StringBuilder();
		if(clothe.size()==0)
		{
			return str.append("No Donations were made");
		}
		for(Clothes e:clothe)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder FoodDonations()
	{
		StringBuilder str=new StringBuilder();
		if(foods.size()==0)
		{
			return str.append("No Donations were made");
		}
		for(Food e:foods)
		{
			str.append(e.toString());
		}
		return str;
	}
	public StringBuilder bookDonations()
	{
		StringBuilder str=new StringBuilder();
		if(book.size()==0)
		{
			return str.append("No Donations were made");
		}
		for(Books e:book)
		{
			str.append(e.toString());
		}
		return str;
	}
	static void addClothes(Clothes e) {
		clothe.add(e);
	}
	static void removeClothes(Clothes e) {
		clothe.remove(e);
	}
	static void addBook(Books e) {
		book.add(e);
	}
}
