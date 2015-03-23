import java.util.*;


public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String test1 = "  hello  world  ";
		System.out.println(s.reverseWords(test1));
	}
	
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		
		StringBuilder res = new StringBuilder();
		s = s.trim();
		int index = s.length() - 1;
		int next_space = s.length() - 1;
		
		while ((next_space = s.lastIndexOf(' ', index)) != -1) {
			res.append(s.substring(next_space + 1, index + 1)).append(" ");
			index = next_space;
			while (s.charAt(index) == ' ') {
				index--;
			}
		}
		
		res.append(s.substring(0, index + 1));
		
		return res.toString();
        
    }
}
