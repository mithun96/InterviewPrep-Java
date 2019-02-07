import java.io.*;
import java.util.*;

	

class Solution {
	public void main (String[] args){
		isValid("asd{}[]()askldj23[232]");
	}
	
    public boolean isValid(String str){
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