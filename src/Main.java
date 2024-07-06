import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner in= new Scanner(System.in);
		File f=new File("C:\\Users\\Nova\\Desktop\\input.txt");
		String name,ssn,Address,phoneNo,Username,password;
		Donor d1=new Donor();
		int age;
		Scanner sc=new Scanner(f);
		try {
			while(sc.hasNextLine()) {
				String str[]=sc.nextLine().split(",");
				int x=0;
				if(Integer.parseInt(str[x++].trim())==1) {
				name=str[x++].trim();
				ssn=str[x++].trim();
				Address=str[x++].trim();
				age=Integer.parseInt(str[x++].trim());
				phoneNo=str[x++].trim();
				Username=str[x++].trim();
				password=str[x++].trim();
				d1=new Donor(name,ssn,Address,phoneNo,age,password,Username);
				}
				else {
					Username=str[x++].trim();
					password=str[x++].trim();
					d1=DonationsLists.getDon(Donor.checkforSignIn(Username, password));
				}
					int c=Integer.parseInt(str[x++].trim());
					switch(c) {
					case 1: {Poverty p=new Poverty(d1);
					p.chooseWayOfDonationfile(Integer.parseInt(str[x++].trim()));
					if(p.getDon()==WayOfDonation.money) {
					p.mooneychoosen(Double.parseDouble(str[x++].trim()));
					//System.out.println(p.toString());
					}
					else if(p.getDon()==WayOfDonation.Clothes) {
					do {
						p.ClothesChosen(Integer.parseInt(str[x++].trim()), Integer.parseInt(str[x++].trim()));
					}while(Integer.parseInt(str[x++].trim())==0);
					//System.out.println(p.toString());
					}
					break;}
					case 2:	{
						Education e=new Education(d1);
						e.chooseWayOfDonationfile(Integer.parseInt(str[x++].trim()));
						if(e.getDon()==WayOfDonation.book) {
							do {
							e.booksChosenfile(Integer.parseInt(str[x++].trim()),str[x++].trim());
							}while(Integer.parseInt(str[x++].trim())==0);
						//	System.out.print(e.toString());
							}
						else if(e.getDon()==WayOfDonation.VolunteerTeacher) {
							e.ChoseTeach(Integer.parseInt(str[x++].trim()));
							//System.out.print(e.toString());
						}
						else if(e.getDon()==WayOfDonation.money) {
							e.mooneychoosen(Double.parseDouble(str[x++].trim()));
							//System.out.print(e.toString());
						}
						break;}
					case 3:{
						HealthCare h=new HealthCare(d1);
						h.chooseWayOfDonationfile(Integer.parseInt(str[x++].trim()));
						if(h.getDon()==WayOfDonation.medicine) {
							do{
								h.medicineChosen(Integer.parseInt(str[x++].trim()),str[x++].trim());
							}while(Integer.parseInt(str[x++].trim())==0);
							//System.out.print(h.toString());
						}
						else if(h.getDon()==WayOfDonation.VolunteerDoctor) {
							h.DoctorSpecialization(Integer.parseInt(str[x++].trim()));
							//System.out.print(h.toString());
						}
						else if(h.getDon()==WayOfDonation.money) {
							h.mooneychoosen(Double.parseDouble(str[x++].trim()));
							//System.out.print(h.toString());
						}
					}break;
					case 4:{
						Hunger h=new Hunger(d1);
						h.chooseWayOfDonationfile(Integer.parseInt(str[x++].trim()));
						if(h.getDon()==WayOfDonation.food) {
							do{
								h.FoodChosen(Integer.parseInt(str[x++].trim()),(Integer.parseInt(str[x++].trim())));	
							}while(Integer.parseInt(str[x++].trim())==0);
							//System.out.print(h.toString());
						}
						else if(h.getDon()==WayOfDonation.money) {
							h.mooneychoosen(Double.parseDouble(str[x++].trim()));
							//System.out.print(h.toString());
						}
					}break;
					}
			}sc.close();}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		FileWriter w=new FileWriter(f,true);
				
				System.out.println("If you want to sign up press 1\nIf you have an account press 0 to log in: ");
				int u=in.nextInt();
				w.write("\n"+u+",");
				if(u==1) {
				System.out.println("Enter your name: ");
				in.nextLine();
				name=in.nextLine();
				System.out.print("Enter your SSN: ");
				ssn=in.nextLine();
				System.out.print("Enter your Address: ");
				Address=in.nextLine();
				System.out.print("Enter your age: ");
				age=in.nextInt();
				System.out.print("Enter your phoneNumber: ");
				phoneNo=in.next();
				System.out.println("Enter your Username: ");
				in.nextLine();
				 Username=in.nextLine();
				if(!Donor.checkusername(Username)) {
					do {
						System.out.println("Username is taken");
						System.out.println("Enter your Username: ");
						 Username=in.nextLine();
					}while(!Donor.checkusername(Username));
				}
				System.out.print("Enter your password: ");
				 password=in.nextLine();
				 w.write(name+","+ssn+","+Address+","+age+","+phoneNo+","+Username+","+password+",");
			 d1=new Donor(name,ssn,Address,phoneNo,age,password,Username);
				}
				else {
					System.out.println("Enter your Username: ");
					in.nextLine();
					Username=in.nextLine();
					System.out.print("Enter your password: ");
					 password=in.nextLine();
					if(Donor.checkforSignIn(Username, password)!=-1&&Donor.checkforSignIn(Username, password)!=-2) {
						d1=DonationsLists.getDon(Donor.checkforSignIn(Username, password));
						w.write("\n"+Username+","+password+",");
						System.out.println("\t\t\tWelcome back "+d1.getName());
					}
					else if(Donor.checkforSignIn(Username, password)==-1){
						System.out.print("Username not found!");
						}
					else {
						System.out.println("You entered the wrong password");
						System.out.println("If you forgot your password press 1: ");
						if(in.nextInt()==1) {
							System.out.print("Enter your ssn: ");
							String s=in.next();
							if(Donor.forgetpassword(s, Username)!=-1) {
								d1=DonationsLists.getDon(Donor.forgetpassword(s, Username));
								System.out.print("Enter your new password: ");
								d1.setPassword(in.next());
								System.out.println("\t\t\tpassword changed succesfuly ");
								System.out.println("\t\t\tWelcome back "+d1.getName());
							}
						}
					}
						
				}
				System.out.println("Choose what are you going to donate for\n"+"Press 1 for Poverty\n"+"Press 2 for Education\n"+"Press 3 for HealthCare\n"+"Press 4 for Hunger\n"+"If you want to exit press 0");
				int c=in.nextInt();
				w.write(c+",");
				int z;
				switch(c) {
				case 1: {Poverty p=new Poverty(d1);
				System.out.println("For donating money press 1: ");
				System.out.println("For donating Clothes press 2: ");
				int xc=in.nextInt();
				p.chooseWayOfDonationfile(xc);
				if(p.getDon()==WayOfDonation.money) {
				w.write(p.getDon().ordinal()+","+(int)p.getMoneyDonated()+",");
				System.out.println(p.toString());
				}
				else if(p.getDon()==WayOfDonation.Clothes) {
					
					do {
					System.out.println("Press 0 for Shirts\nPress 1 for Pants\nPress 2 for Coats\nPress 3 for Shorts\nPress 4 for Jackets\nPress 5 for Hats");
					int x=in.nextInt();
					System.out.println("Press 0 for Xsmall\nPress 1 for Small\nPress 2 for Medium\nPress 3 for Large\nPress 4 for Xlarge");		
					int y=in.nextInt();
					p.ClothesChosen(x, y);
					System.out.print("If you want to donate more clothes press 0 else press -1: ");
					z=in.nextInt();
					w.write(x+","+y+","+z+",");
					}while(z==0);
				System.out.println(p.toString());
				}
				break;}
				case 2:	{
					Education e=new Education(d1);
					System.out.println("For donating money press 1: ");
					System.out.println("For donating books press 2: ");
					System.out.println("For donating by teaching press 3: ");
					int xc=in.nextInt();
					e.chooseWayOfDonationfile(xc);
					if(e.getDon()==WayOfDonation.book) {
						w.write(2+",");
						do {
						System.out.println("Enter the name of the book: ");
						in.nextLine();
						String namme=in.nextLine();
						System.out.println("If your book is educational press 1: \nIf its Entertaining press 2\n ");
						int x=in.nextInt();
						e.booksChosenfile(x, namme);
						System.out.print("If you want to donate more books press 0 else press -1: ");
						z=in.nextInt();
						w.write(x+","+namme+","+z+",");
						}while(z==0);
						System.out.print(e.toString());
						}
					else if(e.getDon()==WayOfDonation.VolunteerTeacher) {
						System.out.println("For teaching primary stage press 1: ");
						System.out.println("For teaching preparatory stage press 2: ");
						System.out.println("For teaching Secondry stage press 3: ");
						System.out.println("For teaching Universty stage press 4: ");
						int x=in.nextInt();
						w.write(3+","+x+",");
						e.ChoseTeach(x);
						System.out.print(e.toString());
					}
					else if(e.getDon()==WayOfDonation.money) {
						w.write(1+","+(int)e.getMoneyDonated()+",");
						System.out.print(e.toString());
					}
					break;}
				case 3:{
					HealthCare h=new HealthCare(d1);
					 System.out.println("For donating money press 1: ");
				        System.out.println("For donating medicine press 2: ");
				        System.out.println("For being a volunteer Doctor press 3: ");
				        int xc=in.nextInt();
				        h.chooseWayOfDonationfile(xc);
					if(h.getDon()==WayOfDonation.medicine) {
						w.write(2+",");
						do {
						   System.out.print("If the medicine you are going to donate is Antibiotics press 1\nIf the medicine you are going to donate is Cream press 2\nIf the medicine you are going to donate is Inhalers press 3\nIf the medicine you are going to donate is Drops press 4\nIf the medicine you are going to donate is Injections press 5\nIf the medicine you are going to donate is Patches press 6\nIf the medicine you are going to donate is Tablets press 7\n");
				    	   int x=in.nextInt();
				    	   System.out.print("Enter name of medicine: ");
				    	   in.nextLine();
				    	  String medname=in.nextLine();		
						  h.medicineChosen(x, medname);
						  System.out.print("To donate more medicine press 0 else press -1: ");
						  z=in.nextInt();
						  w.write(x+","+medname+","+z+",");
						  }while(z==0);
						
						System.out.print(h.toString());
						}
					else if(h.getDon()==WayOfDonation.VolunteerDoctor) {
						System.out.println("if you are a surgeon press 1: ");
						System.out.println("if you a Neorologist press 2: ");
						System.out.println("If ypu are a Cardiologist press 3: ");
						int x=in.nextInt();
						h.DoctorSpecialization(c);
						w.write(3+","+x+",");
						System.out.print(h.toString());
					}
					else if(h.getDon()==WayOfDonation.money) {
						w.write(1+","+(int)h.getMoneyDonated()+",");
						System.out.print(h.toString());
					}
				}break;
				case 4:{
					Hunger h=new Hunger(d1);
					System.out.println("For donating money press 1: ");
					System.out.println("For donating food press 2: ");
					int xc=in.nextInt();
					h.chooseWayOfDonationfile(xc);
					if(h.getDon()==WayOfDonation.food) {
						w.write(2+",");;
						do {
						System.out.println("If you are going to donate with Rice press 1\n If you are going to donate with Chicken press 2\n If you are going to donate with Meat press 3\n If you are going to donate with Vegetables press 4\n If you are going to donate with Fruit press 5\n If you are going to donate with Dairy Products press 6\n If you are going to donate with Pasta press 7\n ");
						int x=in.nextInt();
						System.out.println("Enter the amount of food in KG: ");
						int amountInKG = in.nextInt();
						h.FoodChosen(x, amountInKG);;
						System.out.print("If you want to donate with more food press 0 else press -1: ");
						z=in.nextInt();
						w.write(x+","+amountInKG+","+z+",");
						}while(z==0);
						System.out.print(h.toString());
					}
					else if(h.getDon()==WayOfDonation.money) {
						w.write(1+","+(int)h.getMoneyDonated()+",");
						System.out.print(h.toString());
				}break;}
				default :break;
			}
					System.out.print("If you want to see your donation history press 1 else press any other number: ");
					int x=in.nextInt();
					w.write(""+x);
					if(x==1) {
						System.out.println(d1.EducationDonations()+"\n"+d1.MedicalDonations()+"\n"+d1.HungerDonations()+"\n"+d1.povertyDonations());
					}
				
			w.close();
			File foutEducation=new File("C:\\Users\\Nova\\Desktop\\Education Donations.txt");
			File foutHunger=new File("C:\\Users\\Nova\\Desktop\\Hunger Donations.txt");
			File foutPoverty=new File("C:\\Users\\Nova\\Desktop\\Poverty Donations.txt");
			File foutHealthcare=new File("C:\\Users\\Nova\\Desktop\\Healthcare Donations.txt");
			File TopDonors=new File("C:\\Users\\Nova\\Desktop\\Top Donors.txt");
			File PrepTeachers=new File("C:\\Users\\Nova\\Desktop\\ PrepTeachers.txt");
			File PrimTeachers=new File("C:\\Users\\Nova\\Desktop\\Prim teachers.txt");
			File UniDoctors=new File("C:\\Users\\Nova\\Desktop\\Sec Teachers.txt");
			File SecTeachers=new File("C:\\Users\\Nova\\Desktop\\Uni Doctors.txt");
			File foutSurgeonDonations=new File("C:\\Users\\Nova\\Desktop\\Surgeon Healthcare Donations.txt");
			File foutNeorologistDonations=new File("C:\\Users\\Nova\\Desktop\\Neorologist Healthcare Donations.txt");
			File foutCardiologistDonations=new File("C:\\Users\\Nova\\Desktop\\Cardiologist Healthcare Donations.txt");
			File foutFood=new File("C:\\Users\\Nova\\Desktop\\Food.txt");
			File foutBook=new File("C:\\Users\\Nova\\Desktop\\Book.txt");
			File foutMeds=new File("C:\\Users\\Nova\\Desktop\\Meds.txt");
			File foutClothes=new File("C:\\Users\\Nova\\Desktop\\Clothes.txt");
			DonationsLists d=new DonationsLists();
			try {
				 w=new FileWriter(foutEducation,false);;
					w.write(""+d.EducationDonations());
					w.write("\nThe total amount of money donated to education is: "+d.MoneyEducationDonations());
				w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(foutHealthcare,false);
					w.write(""+d.MedicalDonations());
					w.write("\nThe total amount of money donated to Healthcare is: "+d.MoneyHealthCareDonations());
				w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(foutHunger,false);
				w.write(""+d.HungerDonations());
				w.write("\nThe total amount of money donated to hunger is: "+d.MoneyHungerDonations());
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(foutPoverty,false);
				w.write(""+d.povertyDonations());
				w.write("\nThe total amount of money donated to poverty is: "+d.MoneyPovertDonations());
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(TopDonors,false);
				w.write(""+d.TopDonors());
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(PrimTeachers,false);
				w.write(""+d.PrimaryDonations());
				w.write("\nAnd there are "+ d.NumPrimDonation()+" primary teachers");
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(PrepTeachers,false);
				w.write(""+d.PrepDonations());
				w.write("\nAnd there are "+ d.NumPrepDonation()+" preparatory teachers");
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(SecTeachers,false);
				w.write(""+d.SecDonations());
				w.write("\nAnd there are "+ d.NumSecDonation()+" Secondry teachers");
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				w= new FileWriter(UniDoctors,false);
				w.write(""+d.UniDonations());
				w.write("\nAnd there are "+ d.NumUniDonation()+" universty doctors");
			w.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
		try {
			w= new FileWriter(foutCardiologistDonations,false);
			w.write(""+d.CardiologistDonations());
			w.write("\nAnd there are "+ d.NumCardiologistDonation()+" cardiologist doctors");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			w= new FileWriter(foutNeorologistDonations,false);
			w.write(""+d.NeurologistDonations());
			w.write("\nAnd there are "+ d.NumNeorologistDonation()+" neurologist doctors");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			w= new FileWriter(foutSurgeonDonations,false);
			w.write(""+d.SurgeonDonations());
			w.write("\nAnd there are "+ d.NumSecDonation()+" surgeon doctors");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			w= new FileWriter(foutClothes,false);
			w.write(""+d.ClothesDonations());
			w.write("\nAnd there are "+ d.clothesPovertDonations()+" pieces of clothe");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			w= new FileWriter(foutFood,false);
			w.write(""+d.FoodDonations());
			w.write("\nAnd there are "+ d.FoodKGHungerDonations()+" kg of food");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			w= new FileWriter(foutBook,false);
			w.write(""+d.bookDonations());
			w.write("\nAnd there are "+ d.BooksEducationDonations()+" books");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			w= new FileWriter(foutMeds,false);
			w.write(""+d.MedsDonations());
			w.write("\nAnd there are "+ d.NumMedsDonation()+" Medicines");
		w.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
}

			


	

