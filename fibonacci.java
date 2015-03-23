import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(fib(5));	// 0 1 1 2 3 5
	}

	public static int fib(int n) {
		int first = 0;
		int second = 1;
		
		for (int i = 0; i < n; i++) {
			int next = first + second;
			first = second;
			second = next;
		}
		
		return first;
	}
}
