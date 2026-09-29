import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        if((n& (1<<k)) != 0){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }   
    }
}
