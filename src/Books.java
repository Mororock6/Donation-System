public class Books {
	private String name;
	private BookType type;
	private static int numOfBooks=0; 
	public Books(String name, BookType type) {
		this.name=name;
		this.type=type;
		DonationsLists.addBook(this);
	}
	public Books() {
		// TODO Auto-generated constructor stub
	}
	static int getNumOfbooks()
	{
		return numOfBooks;
	}
	@Override
	public String toString() {
		return "Book name=" + name + ", type=" + type +"]\n";
	}
	
}
