import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];    
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        int maxSum=arr[0];
        int currentSum=arr[0];
        for (int i=1;i<arr.length;i++) {
            if (arr[i]>arr[i - 1]) {
                currentSum +=arr[i];
            } else {
                currentSum = arr[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.print(maxSum);
    }
}
