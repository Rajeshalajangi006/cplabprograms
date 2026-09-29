import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int t=sc.nextInt();
        
        if(t > Math.max(a,b)){
            System.out.print("NO");
        }
        
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        
        if((t%a) == 0){
            System.out.print("YES");
        }
        else{
            System.out.print("NO");
        }
    }
}
