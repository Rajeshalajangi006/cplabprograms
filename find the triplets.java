import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        int found=0;
        
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
              
              for(int k=j+1;k<n;k++){
                int sum=a[i]+a[j]+a[k];
                if (sum == tar) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        found = 1;
                }
                }
              }        
        }
        if(found==0){
            System.out.print("No Triplet Found");
        }
    }
}
