package inventoryCheckOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class CheckOutSystem extends Throwable {

	private String name;
	private String items;
	private String lateMark;
	private String comments;
	private HashMap<Consumer, Items> allUsers;

	public CheckOutSystem() {
		
		Scanner in = new Scanner(System.in);
		allUsers = new HashMap<Consumer, Items>();
	}

	public void addUser(Scanner in) {
		
		System.out.println("User first and last name: ");
		name = in.nextLine();
		System.out.println("Any comments about this user: ");
		comments = in.nextLine();
		System.out.println("Item(s) which they wish to check out: ");
		items = in.nextLine();
		
		Consumer newUser = new Consumer(name, null, comments);
		Items theItems = new Items(items);
		allUsers.put(newUser, theItems);
		
	}

	public void removeUser(String consumerToRemoveName) throws Exception {

		for (Map.Entry<Consumer, Items> entry : allUsers.entrySet()) {

			if (entry.getKey().getName().equalsIgnoreCase(consumerToRemoveName)) {
				if (entry.getValue() != null) {
					allUsers.remove(entry);
				} else {
					throw new Exception("This user still has items checked out.");

				}

			}
		}
	}
	
	public void removeAllItemsOfUser( String consumerOfItemsToRemove) {
		
		for (Map.Entry<Consumer, Items> entry: allUsers.entrySet()) {
			if (entry.getKey().getName().equalsIgnoreCase(consumerOfItemsToRemove)){
				Consumer updatedConsumer = entry.getKey();
				allUsers.remove(entry);
				allUsers.put(updatedConsumer, null);
			}
		}	
		
	}
	
	
	public void addOrReturnItems(String userToUpdate, Scanner in) {
		for (Map.Entry<Consumer, Items> entry: allUsers.entrySet()) {
			if (entry.getKey().getName().equalsIgnoreCase(userToUpdate)){
				Consumer updatedConsumer = entry.getKey();
				allUsers.remove(entry);
				System.out.println("Items this person owes after current checkout/return: ");
				items = in.nextLine();
				Items theItems = new Items(items);
				allUsers.put(updatedConsumer, theItems);
			}
		}
		
	}

	public Items seeItemsCheckedOut(String consumerToView) {
		for (Map.Entry<Consumer, Items> entry : allUsers.entrySet()) {
			if (entry.getKey().getName().equalsIgnoreCase(consumerToView)) {
				return entry.getValue();
			}

		}
		return null;

	}
	
	
	public List<String> getConsumersWhoHaveItem(HashMap<Consumer, Items> allUsers, String item) {
		List<String> usersWithItems = new ArrayList<String>();
		
		for (Map.Entry<Consumer, Items> entry: allUsers.entrySet()) {
			String theseItems = entry.getValue().toString();
		
			if (theseItems.contains(items)){	
			String consumerName = entry.getKey().getName().toString();
				usersWithItems.add(consumerName);
			}
				
			
		}
		return usersWithItems;
		
	}
	
	public String seeComments(String consumerToSee) {
		for (Map.Entry<Consumer, Items> entry: allUsers.entrySet()) {
			if (entry.getKey().getName().equalsIgnoreCase(consumerToSee)){
				Consumer updatedConsumer = entry.getKey();
				return updatedConsumer.getOtherData();
			}
			 
					
				
			}
		return null;
	}
	
	
	public String hasLateMark(String consumerToSee) {
		for (Map.Entry<Consumer, Items> entry : allUsers.entrySet()) {
			if (entry.getKey().getName().equalsIgnoreCase(consumerToSee)) {
				Consumer updatedConsumer = entry.getKey();
				if (updatedConsumer.lateMark()) {
					return "Has a late mark on record";

				}
			}

		}
		return "no late mark recorded";
	}
    
	public void printAllUsers(){
		for (Map.Entry<Consumer, Items> entry: allUsers.entrySet()) {
			String userName = entry.getKey().getName();
			boolean lateMark = entry.getKey().lateMark();
			String comments = entry.getKey().getOtherData();
			String theItems= entry.getValue().getItems();
			
			StringBuilder builder = new StringBuilder();
			builder.append(userName + ' ');
			builder.append(", Late mark: " +lateMark);
			builder.append(", Other user info: "+ comments);
			builder.append(", Items checked out: " +theItems);
			String toPrint = builder.toString();
			System.out.println(toPrint);
			
			

			
		}
	
	}
}
