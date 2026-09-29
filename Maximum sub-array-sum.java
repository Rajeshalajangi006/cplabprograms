import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int[] a=new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }   
      int current=0;
      int max=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
        current+= a[i];
        if(current<0){
            current=0;
        }
        max = Math.max(max,current);
      }
      
      System.out.print(max);
    }
}
