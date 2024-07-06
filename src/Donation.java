

	import java.util.Date;


	public  class Donation {

		private static int c=0;
	    protected Donor donor;
	    private int id;
	    private Date date; 	
	    private WayOfDonation Don;
	    public WayOfDonation getDon() {
			return Don;
		}

		public void setDon(WayOfDonation don) {
			Don = don;
		}

		private Double MoneyDonated=0.0;
		public Donation(Donor donor) {
			id=++c;
	        this.donor = donor;
	        date=new Date();
		}
		public Donation() {
			
		};
		public int  getId() {
			return id;
		}

		protected Donor getDonor() {
			return donor;
		}


		public void setDonor(Donor donor) {
			this.donor = donor;
		}
		public Date getDate() {
			return date;
		}
		//protected abstract void chooseWayOfDonationfile(int c);
		protected void MoneyInsertion(Double money)
		{
			MoneyDonated+=money;
		}
		protected double getMoneyDonated()
		{
			return MoneyDonated;
		}
		//@Override
		public String toString() {
			return donor.toString()+ "date=" + date + "\n Donation type=" + Don+"\n donation id: "+id+"\n";
		}

		protected void chooseWayOfDonationfile(int c) {
			// TODO Auto-generated method stub
			
		}

			
	}
