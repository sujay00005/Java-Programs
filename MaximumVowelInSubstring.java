import java.util.*;

public class MaximumVowelInSubstring {
    public static void main (String[] argd){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string");
        String s = input.nextLine();

        System.out.println("Enter the value of substring length to find the occurance");
        int k = input.nextInt();

        System.out.println("--------" + freq(s,k));
    }

    public static int freq(String s, int k){
        int freq = 0;

        for(int i= 0; i<k; i++){
            if(s.charAt(i) == 'a' || s.charAt(i) =='e' ||s.charAt(i) =='i' || s.charAt(i) =='o' || s.charAt(i) =='u' ) {
                freq ++;
            }
        }

        for(int j =k; j<s.length(); j++){
            System.out.println(freq);
            if(s.charAt(j) == 'a' || s.charAt(j) =='e' ||s.charAt(j) =='i' || s.charAt(j) =='o' || s.charAt(j) =='u' ) {
                if(s.charAt(j-k) != 'a' && s.charAt(j-k) != 'e' && s.charAt(j-k) !='i' && s.charAt(j-k) !='o' && s.charAt(j-k) !='u' ) {
                    freq++;
                    System.out.println(s.charAt(j-k)+"  oooooooooooooooo    " +j);
                }
            }
            else{
                if(s.charAt(j-k) == 'a' || s.charAt(j-k) =='e' ||s.charAt(j-k) =='i' || s.charAt(j-k) =='o' || s.charAt(j-k) =='u' ) {
                    freq--;
                    System.out.println("-----------");
                }
            }
        }

        return freq;
    }
}
