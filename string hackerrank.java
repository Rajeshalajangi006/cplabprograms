import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
     static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int n = A.length();
        int ans = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.append(A.charAt(i));
                }
            }

            if (isPalindrome(sb.toString())) {
                ans = Math.max(ans, sb.length());
            }
        }

        System.out.println(ans);
    }
}
