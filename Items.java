package inventoryCheckOut;

public class Items extends CheckOutSystem{
	
	private String itemsCheckedOut;
	
	public Items(String theItems) {
		
		itemsCheckedOut = theItems;
	}
	
	public String getItems() {
		return itemsCheckedOut;
		
	}
	

}
