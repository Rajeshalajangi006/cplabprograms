import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[m];
        
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        
        for(int j=0;j<m;j++){
            b[j]=sc.nextInt();
        }
        int p=0,q=0,r=0;
        int[] c=new int[n+m];
        while(p<n && q<m){
            if(a[p] < b[q]){
                c[r++]=a[p++];
            }
            else{
                c[r++]=b[q++];
            }
        }
        while(p<n){
            c[r++]=a[p++];
        }
        while(q<m){
            c[r++]=b[q++];
        }
        
        double ans=0;
        int k=n+m;
        if(k%2==0){
            ans=c[k/2]+c[k/2-1];
            ans=ans/2.0;
        }
        else{
            ans=c[k/2];
        }
        
        System.out.print(ans);
        
    }
}
