package inventoryCheckOut;

public class Consumer extends CheckOutSystem {
	
	private String name;
	private String lateMark; 
	private String comments;

	public Consumer(String theName, String theLateMark, String theComments) {
		
		name= theName;
		lateMark = theLateMark;
		comments = theComments;
	}
	
	public String getName() {
		return name;
		
	}
	
	
	public boolean lateMark() {
		if (lateMark!=null) {
			return true;
		}
		return false;
	}
	
	public String getOtherData() {
		return comments;
		
	}
	
	
}
