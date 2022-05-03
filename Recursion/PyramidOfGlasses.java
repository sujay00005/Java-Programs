package Recursion;

import java.util.Scanner;

public class PyramidOfGlasses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the height of the pyramid");
        int height = input.nextInt();

        System.out.println("Enter the number of seconds champagne is poured for");
        int time = input.nextInt();

        input.close();
        fillGlasses(time,height,1);
        
    }

    public static void fillGlasses(int time,int height, int level){
        int k = (level*(level+1)/2);
        if(time < level || height<level){
            System.out.println(level*(level-1)/2);
            return;
        }
        fillGlasses(time-k,height, level+1);
    }
}
