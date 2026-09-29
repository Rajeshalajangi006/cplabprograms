import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] a=new int[n];
       for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
       }
       int minindex=0,min=Integer.MAX_VALUE;
       int maxindex=0,max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
         if(a[i]<min){
            minindex=i;
            min=a[i];
         }
         
         if(a[i]>max){
            maxindex=i;
            max=a[i];
         }
       }
       int temp=a[minindex];
       a[minindex]=a[maxindex];
       a[maxindex]=temp;
       
       for(int i=0;i<n;i++){
        System.out.print(a[i]+" ");
       }
    }
}
