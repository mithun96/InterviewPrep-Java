/* Question
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string 
is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

*/

import java.io.*;
import java.util.*;

	

class Solution {
	public static void main (String[] args){
		boolean sol = isValid("asd{}[](askldj23[232]");
		System.out.println("Answer : " + sol);
	}

    public static boolean isValid(String str){
		Stack<Character> stack = new Stack<Character>();

		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++){
			if (chars[i] == '{' || chars[i] == '(' || chars[i] == '['){
				stack.push(chars[i]);
			}
			else if (chars[i] == '}' ){
				if (stack.empty() || stack.pop() != '{')
					return false;
			}
			else if (chars[i] == ']' ){
				if (stack.empty() || stack.pop() != '[')
					return false;
			}
			else if (chars[i] == ')'){
				if (stack.empty() || stack.pop() != '(')
					return false;
			}
		}

		if (!stack.empty())
			return false;

		return true;
	}
}   