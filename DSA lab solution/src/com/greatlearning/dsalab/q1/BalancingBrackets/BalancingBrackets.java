package com.greatlearning.dsalab.q1.BalancingBrackets;

import java.util.*;

public class BalancingBrackets {

	static boolean bracketsbalance(String expr) {
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression to check Balanced brackets: ");
		String expr = sc.nextLine();

		if (bracketsbalance(expr)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
		sc.close();
	}
}