
public class Medicine {
	private String name;
	private MedicineType Type;
	
	public Medicine(MedicineType type2, String name) {
		this.Type = type2;
		this.name=name;
		DonationsLists.addMeds(this);
	}

	@Override
	public String toString() {
		return "Medicine [name=" + name + ", Type=" + Type + "]\n";
	}


	
	
}
