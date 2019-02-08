/* Question 

Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 

*/

// SOLUTION 

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            StringBuilder sb = new StringBuilder();
            for(char c: email.toCharArray()) {
                if (c == '.') continue;
                if (c == '+') break;
                sb.append(c);
            }
            String cur = sb.toString() + email.substring(email.indexOf('@'));
            set.add(cur);
        }
        return set.size();
    }
}


// MINE

import java.lang.*;

public Class{

	public static void main(String[] args){

	}

	public static int num_unique_emails(String[] emails){

        HashSet<String> ans = new HashSet<>();
        
        for(int i = 0; i < emails.length; i++){
            char[] letters = emails[i].toCharArray();
            String newStr = "";
            int localEnd = 0;
            int at = 0;
            int flag = 0;
            
            for(int j = 0; j < letters.length; j++){
                if(letters[j] == '@'){
                    newStr = newStr + emails[i].substring(j, letters.length);
                    break;
                }
                else if(flag == 0 && letters[j] == '.'){
                    continue;
                }
                else if(letters[j] == '+'){
                    flag = 1;
                }
                else if (flag == 0){
                    newStr = newStr + String.valueOf(letters[j]);
                }
            }
            
            ans.add(newStr);
            
            
        }
        
        return ans.size();
    }
}



