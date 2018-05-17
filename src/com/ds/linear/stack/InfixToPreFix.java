package com.ds.linear.stack;

import java.util.Stack;

public class InfixToPreFix {

	public static void main(String[] args) {
		InfixToPreFix infixToPreFix = new InfixToPreFix();
		String s1 = infixToPreFix.converToPostfix("(a-b/c)*(a/k-l)");
		System.out.println("s1::"+s1);
		
		String s2 = infixToPreFix.converToPrefix("(a-b/c)*(a/k-l)");
		System.out.println("s1::"+s2);
	}
	public String converToPostfix(String str) { 
        Stack<Character> stack = new Stack<Character>();
        String postfix = "";
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isLetter(c)){
                postfix = postfix + c;
            }
            else if(c == '('){
                continue;
            }
            else if(c == ')'){
                postfix = postfix + ((Character)stack.pop()).toString();
            }
            else{
                stack.push(c);
            }
        }
        return postfix;
 
    }
	
	 public String converToPrefix(String str){
	        Stack<Character> stack = new Stack();
	        String prefix = "";
	        for(int i=str.length()-1;i>=0;i--){
	            char c = str.charAt(i);
	            if(Character.isLetter(c)){
	                prefix = ((Character)c).toString() + prefix;
	            }
	            else if(c == '('){
	                prefix = ((Character)stack.pop()).toString() + prefix;
	            }
	            else if(c == ')'){
	                continue;
	            }
	            else{
	                stack.push(c);
	            }
	        }
	        return prefix;
	 
	    }
}
