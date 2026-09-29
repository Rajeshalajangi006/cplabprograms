import java.io.*;
import java.util.*;

public class Solution {
    public int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Solution obj=new Solution();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans = obj.fact(n);
        System.out.print(ans);
    }
}
