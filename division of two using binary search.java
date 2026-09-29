import java.io.*;
import java.util.*;

public class Solution {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // 2147483647
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE; // -2147483648
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long quotient = 0;
        while (lDividend >= lDivisor) {
            long temp = lDivisor, multiple = 1;
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            lDividend -= temp;
            quotient += multiple;
        }
        quotient = negative ? -quotient : quotient;

        if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) quotient;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        System.out.println(divide(dividend, divisor));
    }
}
