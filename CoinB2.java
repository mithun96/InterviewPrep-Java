/*
Sarah rents a car for the trip - she pays $400 for the car, which is used by Alice, John, Bob and herself. 
Later in the trip, John went out and bought groceries for $100, which was used only by Alice and Bob.

Now, the trip is over and everyone wants to get paid back what they are owed - print out the list of transactions that would settle everyone's debts.

Alice = +50 +100 = +150
John = -100 +100 = 0
Bob = +50 + 100 = +150
Sarah = -400 + 100 = -300


a = -1000
b = -100
c = +100
d = +1000
*/

import java.util.*;

public class CoinB2 {

	private static HashMap<String, Integer> ledger = new HashMap<>();

	public static void main(String[] args) {
		ledger.put("Sarah", 0);
		ledger.put("John", 0);
		ledger.put("Bob", 0);
		ledger.put("Alice", 0);

		List<String> users = new ArrayList<>(Arrays.asList("Alice", "Bob", "Sarah", "John"));

		List<String> users1 = new ArrayList<>(Arrays.asList("Alice", "Bob"));

		transaction("Sarah", 400, users);
		transaction("John", 100, users1);

		settleDebt();
	}

	public static void transaction(String payer, int amount, List<String> consumers){
		int split = amount / consumers.size();

		for(int i = 0; i < consumers.size(); i++){
			ledger.put(consumers.get(i), split + ledger.get(consumers.get(i)));
		}

		ledger.put(payer, amount * (-1) + ledger.get(payer));

		printLedger();
	}

	public static void settleDebt(){
		List<String> receiving = new ArrayList<>();
		List<String> paying = new ArrayList<>();
		String payer, receiver;

		for(Map.Entry<String, Integer> entry: ledger.entrySet()){
			if (entry.getValue() > 0) {
				paying.add(entry.getKey());
			}
			else if(entry.getValue() < 0){
				receiving.add(entry.getKey());
			}
		}

		while (!paying.isEmpty() && !receiving.isEmpty()){
			
			payer = paying.get(0);
			receiver = receiving.get(0);

			if (ledger.get(receiver) != 0 && ledger.get(payer) >= ledger.get(receiver) * (-1)){
				System.out.println(payer + " pays " + receiver + " " + ledger.get(receiver) * (-1));
				
				//update ledger
				ledger.put(payer, ledger.get(payer) + ledger.get(receiver));
				ledger.put(receiver, 0);
			}

			else if(ledger.get(receiver) != 0 && ledger.get(payer) <= ledger.get(receiver) * (-1)){
				System.out.println(payer + " pays " + receiver + " " + ledger.get(payer));
				
				//update ledger
				ledger.put(receiving.get(0), ledger.get(receiving.get(0)) + ledger.get(payer));
				ledger.put(payer, 0);
			}

			if (ledger.get(payer) == 0){
				paying.remove(0);
			}

			if (ledger.get(receiver) == 0){
				receiving.remove(0);
			}
		}
		System.out.println();

		printLedger();
		
	} 

	public static void printLedger(){
		
		for(Map.Entry<String, Integer> entry: ledger.entrySet()){
			System.out.println(entry.getKey() + " has a balance of :" + entry.getValue());
		}

		System.out.println();
	}


}


