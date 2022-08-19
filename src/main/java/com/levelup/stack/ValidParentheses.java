package com.levelup.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Problem statement
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Input     Output
 * ({[]})     true (its valid parentheses because all braces are closed in order then they have open braces)
 * (})        false(Because closing curly braces does not have opening curly braces)
 * }          false(Because it start with closing braces)
 *
 * Pseudo Code
 *   Data structure  :Stack (FILO)
 *   Iterate through  length of input
 *       check if iterating char is opening braces ( or { or [
 *          push to current char to stack
 *          else  if stack is empty then: return false
 *          else if currchar=')' and stack.peek()=='(' then : stack.pop()
 *          else if currchar='}' and stack.peek()=='{}' then : stack.pop()
 *          if currchar=']' and stack.peek()=='[' then : stack.pop()
 *          else return false
 *    end Char iteration
 *    if stack.isEmpty return true else return false;
 *
 *  Time complexity :O(n)
 *
 * Constraint
 * length of string must be greater than 0 and less than 10^4
 * Must have only bracket, curly braces and square bracket
 *
 * Article :
 * https://redquark.org/leetcode/0020-valid-parentheses/
 * https://github.com/ani03sha/RedQuarkTutorials/blob/master/LeetCode/Java/src/main/java/org/redquark/tutorials/leetcode/ValidParentheses.java
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int size= s.length();

        Stack<Character> parenthesis= new Stack<>();
        for(int i=0;i<size;i++){
            char c=s.charAt(i);
            if(c=='('|| c=='{'||c=='['){
                parenthesis.push(c);
            }else if(parenthesis.empty()) { return false;
            }else if(c==')' && parenthesis.peek()=='('){
                    parenthesis.pop();
            }else if(c=='}' && parenthesis.peek()=='{'){
                    parenthesis.pop();
            }else if(c==']' && parenthesis.peek()=='['){
                    parenthesis.pop();
            }else{
                return false;
            }
        }
        return parenthesis.empty();
    }
    public static void main(String [] args){
        ValidParentheses validParentheses =new ValidParentheses();
        System.out.println("({{}}){}{}"+"isValidParenthesis:"+validParentheses.isValid("({{}}){}{}")); // Return true
        System.out.println("(})"+"isValidParenthesis:"+validParentheses.isValid("(})")); //Return false
        System.out.println("({}{)"+"isValidParenthesis:"+validParentheses.isValid("({}{)")); //Return false
    }
}
