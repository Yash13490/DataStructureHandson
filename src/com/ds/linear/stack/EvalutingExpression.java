package com.ds.linear.stack;

import java.util.Stack;

public class EvalutingExpression {

	public static void main(String[] args) throws Exception {
		// ((4-2)* 5)+(7+5)/2;=> 16
		EvalutingExpression exp = new EvalutingExpression();
		System.out.println(exp.evaluate("((4-2)* 5)+(7+5)/2"));
	}

	public int evaluate(String s) throws Exception {
		char c[] = s.toCharArray(); 
		int len = s.length();
		Stack<Character> charSt = new Stack<Character>();
		Stack<Integer> intSt = new Stack<Integer>();

		for(int i=0 ; i< len ; i++) {
			
			// Add it in char stack....
			if(c[i] == '(') {
				charSt.push(c[i]);
			}
			// Closing brace encountered, solve entire brace
			else if(c[i] == ')') {
				
				while(charSt.peek() != '(') {
					intSt.push(calculate(charSt.pop(), intSt.pop(), intSt.pop()));
				}
					charSt.pop();  // after solving entire brace pop out ( from character stack...
				
			}
			
			 // While top of 'ops' has same or greater precedence to current
            // token, which is an operator. Apply operator on top of 'ops'
            // to top two elements in values stack
			else if(c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
				
				while(!charSt.empty() && hasPrecedence(c[i], charSt.peek()))
					intSt.push(calculate(charSt.pop(),intSt.pop(),intSt.pop()));
				charSt.push(c[i]);
			}
			
			// IF it integer, which may more than 1 digit => add it to integer stack
			else if(c[i] >= '0' && c[i] <= '9') {
				StringBuffer strBuff = new StringBuffer();
				while(i < len && c[i] >= '0'  && c[i] <= '9')
					strBuff.append(c[i++]);
				i--;
				intSt.push(Integer.parseInt(strBuff.toString()));
			}

		}

		while(!charSt.empty()) 
			intSt.push(calculate(charSt.pop(), intSt.pop(), intSt.pop()));
		return intSt.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	
	public int calculate(char c, int j, int i) throws Exception {

		if(c == '+')
			return i + j;
		else if(c == '-')
			return i - j;
		else if(c == '*')
			return i * j;
		else if(c == '/') {
			if(j == 0)
				throw new Exception("Can not divide by Zero");
			return i / j;
		}
		return 0;
	}
}
