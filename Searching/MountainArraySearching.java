package Searching;

import java.util.Scanner;
import java.util.Set;

public class MountainArraySearching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements present in the array");
        int n = input.nextInt();

        System.out.println("Enter the sorted array elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println("Enter the target key");
        int target = input.nextInt();
        // input.close();

        // int length = lenth(a);
        // int pivot = pivot(length);

    }
}
// public static int mountainSearching(int length){
// int l=0;
// int h = length;
// int m;
// while (l<=h) {
// m = (l+h)/2;

// }
// return -1;
// }

// public static int pivot(int length){
// int l=0;
// int h =length-1;
// int m;
// while(l<=h){
// m= (l+h)/2;
// if()
// if(get(a, m)>)
// }
// }

// public static int lenth(int[] a){
// return a.length;
// }
// public static int get(int[] a, int index){
// if(index>=0 && index<=a.length-1)
// return a[index];
// return -1;
// }
// }
