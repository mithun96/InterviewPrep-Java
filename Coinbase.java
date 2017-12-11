/*
Sarah rents a car for the trip - she pays $400 for the car, which is used by Alice, John, Bob and herself. 
Later in the trip, John went out and bought groceries for $100, which was used only by Alice and Bob.

Now, the trip is over and everyone wants to get paid back what they are owed - print out the list 
of transactions that would settle everyone's debts.



Alice = -100 +50 = -50 
John = - 100 + 100 = 0
Bob = -100 +50  = -50
Sarah = +400 - 300 = 100
*/

import java.util.*;

class Trip {
	static HashMap<String, Integer> people = new HashMap<String, Integer>();

	public static void main (String[] args){
		people.put("Sarah", 0);
		people.put("Alice", 0);
		people.put("Bob", 0);
		people.put("John", 0);

		ArrayList<String> user1 = new ArrayList<String>();
		user1.add("Alice");
		user1.add("John");
		user1.add("Bob");
		user1.add("Sarah");
		ArrayList<String> user2 = new ArrayList<String>();
		user2.add("Alice");
		user2.add("Bob");

		transcation("Sarah", user1, 400);
		transcation("John", user2, 100);
      	
      	Set people2 = people.entrySet();

 		Iterator its = people2.iterator();
      	while(its.hasNext()) {
          	Map.Entry mentry2 = (Map.Entry)its.next();
          	System.out.print(mentry2.getKey() + " owes ");
          	System.out.println(mentry2.getValue());
        }		
       return;
	}

	public static void transcation(String payer, ArrayList<String> user, int amount){
		int split = amount / user.size();

		for(int i = 0; i < user.size(); i++){
				people.put(user.get(i), split + people.get(user.get(i)));
				//System.out.println(user.get(i) + " owns "+ split + " to " + payer);
		}
		people.put(payer, amount * (-1) + people.get(payer));
	}

	public static void paying(){
		Set people2 = people.entrySet();
		
		Iterator its = people2.iterator();
      	while(its.hasNext()) {
          	Map.Entry mentry2 = (Map.Entry)its.next();
          	if(mentry2.getValue() > 0){
          		System.out.print(mentry2.getKey() + " pay " + mentry2.getValue()); 
          		people.put(user.get(i), split + people.get(user.get(i)));

        }		
	}

}






