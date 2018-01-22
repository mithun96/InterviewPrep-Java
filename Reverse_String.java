/*

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

*/


class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i++] = word[j];
            word[j--] = temp;

        }
        return new String(word);
    }
}
  