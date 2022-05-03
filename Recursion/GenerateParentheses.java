package Recursion;

import java.util.Scanner;

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of pair of parantheses");
        int n = input.nextInt();

        input.close();

        printParantheses(n,0,0,0,"");
    }

    public static void printParantheses(int n, int l, int r, int i,String s){
        if(i == 2*n){
            System.out.println(s);
            return;
        }

        if(l==r){
            s+= '(';
            printParantheses(n, l+1, r, i+1, s);
        } else if(l>r){
            if(l==n){
                s+= ')';
                printParantheses(n, l, r+1, i+1, s);
            } else{
                s+= '(';
                printParantheses(n, l+1, r, i+1, s);
                s= s.substring(0, i)+')';
                printParantheses(n, l, r+1, i+1, s);
            }

        }
    }
}
