package Sorting;

import java.util.Scanner;

public class ClosestPointsToOrigin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points present ");
        int n = input.nextInt();

        int points[][] = new int[n][2];

        System.out.println("Enter the x and y co-ordinates for k points");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the x and y co-ordinates for " + (i + 1) + "th point");
            points[i][0] = input.nextInt();
            points[i][1] = input.nextInt();
        }
        System.out.println("Enter the number of closest points from the origin to be displayed");
        int k = input.nextInt();
        input.close();

        sortPoints(points);

        for (int i = 0; i < k; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }

    }

    public static void sortPoints(int[][] points) {
        int dist[] = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            dist[i] = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
        }
        sortPoints(dist, points);
        for (int i = 0; i < dist.length; i++) {
            System.out.println("------" + dist[i]);
        }
    }

    public static void sortPoints(int[] a, int[][] points) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                swap(a, points, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(int[] a, int[][] points, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        temp = points[i][0];
        points[i][0] = points[j][0];
        points[j][0] = temp;

        temp = points[i][1];
        points[i][1] = points[j][1];
        points[j][1] = temp;
    }
}