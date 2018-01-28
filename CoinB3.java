/*
A group of people go camping together, and end up buying a lot of stuff for each other. We need to write code to figure out how much people owe each other, and the most efficient way to pay each other back.
Sarah rents a car for the trip - she pays $400 for the car, which is used by Alice, John, Bob and herself. Later in the trip, John went out and bought groceries for $100, which was used only by Alice and Bob.

Now, the trip is over and everyone wants to get paid back what they are owed - print out the list of transactions that would settle everyone's debts.

Alice = -100 - 50 = -150 
John = -100 + 100 = 0
Bob = -100 - 50 = -150
Sarah = +400 - 100 = +300

alice and bob owes sarah 150 each. 

*/

import java.util.*;

class CoinB3 {
	private static HashMap<String, Integer> ledger = new HashMap<>();

	public static void main(String[] args){
		// ArrayList<String> users = new ArrayList<>(Arrays.asList("Alice", "John", "Bob", "Sarah"));
		// transcation("Sarah", 400, users);

		// ArrayList<String> users1 = new ArrayList<>(Arrays.asList("Alice", "Bob"));
		// transcation("John", 100, users1);

		ledger.put("sarah", 125);
		ledger.put("John", 50);
		ledger.put("Katie", 15);
		ledger.put("sam", -7);
		ledger.put("joseph", -6);
		ledger.put("Ben", -9);
		ledger.put("Charlie", -43);
		ledger.put("Fred", -125);

		settleDebt1();
	}

	public static void populated(String name){
		if(!ledger.containsKey(name)){
			ledger.put(name, 0);
		}
		return;
	}

	public static void transcation(String payer, int amount, ArrayList<String> users){
		int usedAmount = amount/ users.size();
		populated(payer);

		for(String user: users){
			populated(user);
			ledger.put(user, ledger.get(user) - usedAmount);
		}

		ledger.put(payer, ledger.get(payer) + amount);

		printLedger();
	}

	public static void settleDebt() {
		ArrayList<String> receiving = new ArrayList<>();
		ArrayList<String> paying = new ArrayList<>();

		for(Map.Entry<String, Integer> entry: ledger.entrySet()){
			if(entry.getValue() > 0){
				receiving.add(entry.getKey());
			}
			else{
				paying.add(entry.getKey());
			}
		}

		while(!paying.isEmpty() && !receiving.isEmpty()){
			String payer = paying.get(0);
			String receiver = receiving.get(0);

			if(ledger.get(payer) * (-1) >= ledger.get(receiver)){
				System.out.println(payer + " pays " + receiver + " " + ledger.get(receiver));

				ledger.put(payer, ledger.get(payer) + ledger.get(receiver));
				ledger.put(receiver, 0);
			}

			else if(ledger.get(payer) * (-1) < ledger.get(receiver)){
				System.out.println(payer + " pays " + receiver + " " + ledger.get(payer) * (-1));

				ledger.put(receiver, ledger.get(receiver) + ledger.get(payer));
				ledger.put(payer, 0);
			}

			if (ledger.get(payer) == 0){
				paying.remove(0);
			}
			if(ledger.get(receiver) == 0){
				receiving.remove(0);
			}
		}

		printLedger();

	}

	public static void settleDebt1() {
		// List<Map.Entry<String, Integer>> list = sortLedger();

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(ledger.entrySet());
		list = sortLedger(list);

		while(!list.isEmpty()){

			String payer = list.get(0).getKey();
			String receiver = list.get(list.size() - 1).getKey();

			if(ledger.get(payer) * (-1) >= ledger.get(receiver)){
				System.out.println(payer + " pays " + receiver + " " + ledger.get(receiver));

				ledger.put(payer, ledger.get(payer) + ledger.get(receiver));
				ledger.put(receiver, 0);
			}

			else if(ledger.get(payer) * (-1) < ledger.get(receiver)){
				System.out.println(payer + " pays " + receiver + " " + ledger.get(payer) * (-1));

				ledger.put(receiver, ledger.get(receiver) + ledger.get(payer));
				ledger.put(payer, 0);
			}

			if (ledger.get(payer) == 0){
				list.remove(0);
			}
			if(ledger.get(receiver) == 0){
				list.remove(list.size() - 1);
			}

			if(!list.isEmpty())
				list = sortLedger(list);

		}

		printLedger();
	}

	public static void printLedger(){
		for(Map.Entry<String, Integer> entry : ledger.entrySet()){
			System.out.println(entry.getKey() + " has a balance of " + entry.getValue());
		}
		System.out.println();
	}


	//ascending order (negative to postive) https://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
	 public static List<Map.Entry<String, Integer>> sortLedger(List<Map.Entry<String, Integer>> list) {

        // List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(ledger.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        List<Map.Entry<String, Integer>> list1 = new LinkedList<Map.Entry<String, Integer>>();


        //remove zero balance value entries. 
        for(Map.Entry<String, Integer> entry : list1){
        	if(entry.getValue() == 0){
        		list.remove(entry);
        	}
        }

        return list;
    }
}
