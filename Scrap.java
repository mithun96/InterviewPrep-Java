

import java.util.*;

class Solution {
	HashMap<String, Integer> age = new HashMap<>();
	HashMap<String, String> birthDate = new HashMap<>();

	public static void main(String[] args){
		foo();
	}

	public static void foo(){
		

		age.put("Mithun", 22);
		age.put("Dhriti", 21);
		age.put("Bob", 2);

		birthDate.put("Mithun", "Jan11");
		birthDate.put("Dhriti", "Nov8");


		if (age.containsKey("Dhriti") && birthDate.get("Dhriti").equals("Nov8")){
			age.put("Dhriti", 22);
		}

		System.out.println(age.get("Dhriti"));


		ArrayList<String> name = new ArrayList<>(Arrays.asList("Mithun", "Dhriti", "Vig", "Minu", "Tanya"));
	}

	public static void populated(String name){
		if(!ledger.containsKey(name)){
			ledger.put(name, 0);
		}
		return;
	}
}