package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class BracketAndParantheses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of pair of parantheses");
        int n = input.nextInt();

        System.out.println("Enter the value of pair of braces");
        int m = input.nextInt();
        input.close();
        Stack<Character> closingBrakcets = new Stack<Character>();
        char[] backetString = new char[(2 * n) + (2 * m)];
        // Since pair so multiplying by 2
        printParantheses(m, n, backetString, closingBrakcets, 0);

    }

    public static void printParantheses(int m, int n,
            char[] bracketString, Stack<Character> closingBracket, int currIndex) {
        if (n == 0 && m == 0 && closingBracket.empty()) {
            System.out.println(bracketString);
            return;
        }

        // when this '(' is pushed
        if (n > 0) {
            closingBracket.push(')');
            bracketString[currIndex] = '(';
            printParantheses(m, n - 1, bracketString, closingBracket, currIndex + 1);
            if (!closingBracket.empty())
                closingBracket.pop();

        }
        // when this '{' is pushed
        if (m > 0) {
            closingBracket.push('}');
            bracketString[currIndex] = '{';
            printParantheses(m - 1, n, bracketString, closingBracket, currIndex + 1);
            if (!closingBracket.empty())
                closingBracket.pop();

        }
        // when this ')' or '}' is pushed
        if (!closingBracket.empty()) {
            char top = closingBracket.pop();
            if (top == ')') {
                bracketString[currIndex] = ')';
                printParantheses(m, n, bracketString, closingBracket, currIndex + 1);
            } else {
                bracketString[currIndex] = '}';
                printParantheses(m, n, bracketString, closingBracket, currIndex + 1);
            }
            closingBracket.push(top);
        }

    }

}