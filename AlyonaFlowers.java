import java.util.Scanner;

public class AlyonaFlowers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of number of flowers and number of subarrays suggested");

        int n = input.nextInt();
        int subNum = input.nextInt();

        int[] a = new int[n];
        System.out.println("Enter the mood of each flower");
        for(int i=0; i<n; i++) a[i] = input.nextInt();

        int[] left = new int[subNum];
        int[] right = new int[subNum]; 
        
        for(int i=0; i<subNum; i++) {
            System.out.println("Enter the value of left and right position for "+ (i+1) +"th subarray given postion lies between 1 and " + n);

            left[i] = input.nextInt() -1;
            right[i] = input.nextInt() -1;
        }

        int totalHappiness = 0;
        int count = 0; 

        for(int i=0; i<subNum; i++){
            int temp =subarrayHappiness(left[i], right[i], a);
            if(temp > 0)
            { 
                totalHappiness = totalHappiness+ temp;
                System.out.println("Subarray selected is " + (i+1));
                count++;
            }
        
        }
        if(count==0) System.out.println("0 subarrays selected");
        else System.out.println(count + " subarrays selected");

        System.out.println(totalHappiness + " is total happiness");
    }

    public static int subarrayHappiness(int left, int right, int[] a){
        int happiness = 0;
        for(int i =left; i<= right; i++){
            happiness = happiness+ a[i];
        }
        return happiness;
    }

    // public static int valueOfPosition(int valueOfPosition, int count){
    //     return valueOfPosition * count;
    // }

    // public static int numberOfTimes(int[] left, int[] right, int pos){
    //     int count =0;
    //     for(int i = 0; i< left.length; i++){
    //         if(left[i]<= pos && pos <= right[i]) count++;
    //     }
    //     return count;
    // }
}
