import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        System.out.println(binaryGCD(a, b));
    }

    static long binaryGCD(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;

        if ((a & 1) == 0 && (b & 1) == 0) {
            return binaryGCD(a >> 1, b >> 1) << 1;
        }
        else if ((a & 1) == 0) {
            return binaryGCD(a >> 1, b);
        }
        else if ((b & 1) == 0) {
            return binaryGCD(a, b >> 1);
        }
        else {
            if (a >= b) {
                return binaryGCD((a - b) >> 1, b);
            } else {
                return binaryGCD((b - a) >> 1, a);
            }
        }
    }
}
