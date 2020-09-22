package inventoryCheckOut;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		CheckOutSystem tester = new CheckOutSystem();
		Scanner in = new Scanner(System.in);
		tester.addUser(in);
		tester.addOrReturnItems("first last", in);
		try {
			tester.removeUser("first last");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tester.printAllUsers();
	}
}
