import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        int j=sc.nextInt();
        if(i>j){
            int temp=j;
            j=i;
            i=temp;
        }
        int max=Integer.MIN_VALUE;
        
        for(int k=i;k<=j;k++){
            int n=k;
            int count=1;
            while(n!=1){
                if((n%2)==0){
                    n=n/2;
                }
                else{
                    n=(3*n)+1;
                }
                count++;
            }
            max=Math.max(max,count);
        }
        System.out.print(i+" "+j+" "+max);
    }
}
