
import java.util.ArrayList;
import java.util.Scanner;

public class Donor implements Comparable<Donor>{

	private ArrayList<Donation> DonationsHistory=new ArrayList<>();
	private static ArrayList<String> Usernames=new ArrayList<>();
	private static ArrayList<String> Password=new ArrayList<>();
	private String name;
	private String SSN;
	private String address;
	private String phoneNumber;
	private String password;
	private String Username;
	private int age;
	Scanner in=new Scanner(System.in);
	public static int forgetpassword(String SSN,String Username) {
		if(DonationsLists.getDon(Usernames.indexOf(Username)).getSSN().compareTo(SSN)==0) {
			return Usernames.indexOf(Username);
		}
		return -1;
	}
	public static int checkforSignIn(String Username,String password) {
		if(Usernames.contains(Username)) {
			if(Password.get(Usernames.indexOf(Username)).compareTo(password)==0){
				return Usernames.indexOf(Username);
			}
			else {
				return -2;
			}
		}
		return -1;
	}

	public static boolean checkusername(String Username) {
		if(Usernames.contains(Username)) {
			return false;
		}
		else return true;
	}
	public Donor(String name,String SSN,String address,String phoneNumber,int age2,String password,String Username) {
		this.address=address;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.SSN=SSN;
		this.age=age2;
		this.setUsername(Username);
		this.password=password;
		Usernames.add(Username);
		Password.add(password);
		DonationsLists.addDonor(this);
	}
	
	public Donor() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void AddDonation(Donation e)
	{
		DonationsHistory.add(e);
	}

	public StringBuilder EducationDonations()
	{
		StringBuilder str=new StringBuilder();
		str.append("EducationDonations: \n");
		if(NumEducationDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donation e:DonationsHistory)
		{
			if(e instanceof Education)
			{
				str.append(e.toString());
			}
		}
		return str;
	}
	public StringBuilder povertyDonations()
	{
		StringBuilder str=new StringBuilder();
		str.append("PovertyDonations: \n");
		if(NumPovDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donation e:DonationsHistory)
		{
			if(e instanceof Poverty)
			{
				str.append(e.toString());
			}
		}
		return str;
	}
	public StringBuilder MedicalDonations()
	{
		
		StringBuilder str=new StringBuilder();
		str.append("MedicalDonations: \n");
		if(NumMedicalCareDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donation e:DonationsHistory)
		{
			if(e instanceof HealthCare)
			{
				str.append(e.toString());
			}
		}
		return str;
	}
	public StringBuilder HungerDonations()
	{
		StringBuilder str = new StringBuilder();
		str.append("HungerDonations: \n");
		if(NumHungerDonations()==0)
		{
			return str.append("No Donations were made");
		}
		for(Donation e:DonationsHistory)
		{
			if(e instanceof Hunger)
			{
				str.append(e.toString());
			}
		}
		return str;
	}
	
	
	public int NumPovDonations()
	{
		int c=0;
		for(Donation e:DonationsHistory)
		{
			if(e instanceof Poverty)
			{
				c++;
			}
		}
		return c;
	}
	public int NumHungerDonations()
	{
		int c=0;
		for(Donation e:DonationsHistory)
		{
			if(e instanceof Hunger)
			{
				c++;
			}
		}
		return c;
	}
	public int NumMedicalCareDonations()
	{
		int c=0;
		for(Donation e:DonationsHistory)
		{
			if(e instanceof HealthCare)
			{
				c++;
			}
		}
		return c;
	}
	public int NumEducationDonations()
	{
		int c=0;
		for(Donation e:DonationsHistory)
		{
			if(e instanceof Education)
			{
				c++;
			}
		}
		return c;
	}
	public int numTotalDonations()
	{
		return DonationsHistory.size();
	}
	public double TotalMoneyDonated() {
		double c=0;
		for(Donation e:DonationsHistory)
		{
			c+=e.getMoneyDonated();
		}
		return c;
	}

	@Override
	public String toString() {
		return "Donor name=" + name + "\n SSN=" + SSN + "\n address=" + address + "\n phoneNumber=" + phoneNumber
				+ "\n age=" + age+"\n";
	}

	@Override
	public int compareTo(Donor o) {
		if(this.TotalMoneyDonated()>o.TotalMoneyDonated()) {
			return 1;
		}
		else if(this.TotalMoneyDonated()<o.TotalMoneyDonated()) {
			return -1;
		}
		else {return 0;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		do {
		System.out.print("Confirm your password: ");
		if(password.compareTo(in.next())==0) {
		this.password = password;
		break;
		}
		else {
			System.out.println("It didn't match\nTo try again press 1 else press 0");
			if(in.nextInt()==0) {
				break;
			}
		}
		}while(true);
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
}

