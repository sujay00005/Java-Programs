import java.util.*;

public class PermutationOfStringPresent{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the String");
        String s1 = input.nextLine();

        System.out.println("Enter the sub-string to be searched");
        String s2 = input.nextLine();

        System.out.println("--------" + search(s1,s2) );

    }

    public static boolean search( String s1, String s2){
        
        int count = 0;
        int l1 = s1.length();
        int l2 = s2.length();

        System.out.println(l1+ "---------" +l2);

        for(int i=0; i<l2; i++){
            for(int j =0; j< l2; j++){
                if(s2.charAt(i) == s1.charAt(j)){
                    count++;
                }
            }
        }
        if(count == l2) return true;
        System.out.println(count+"=====");

        for(int i=1; i<=l1-l2; i++){
            for(int j =0; j< l2; j++){  
                if(s2.charAt(j) == s1.charAt(i+l2-1)) count++;
                if(s2.charAt(j) == s1.charAt(i-1) ) count--;  
            }
            if(count == l2) return true;
        }
        System.out.println(count+"?????");
        

        return false;
    }
}