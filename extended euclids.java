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

        Result res = extendedGCD(a, b);

        System.out.println(res.x + " " + res.y + " " + res.gcd);
    }

    static class Result {
        long x, y, gcd;
        Result(long x, long y, long gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }
    }
    public static Result extendedGCD(long a, long b) {
        if (b == 0) {
            return new Result(1, 0, a);
        }
        Result next = extendedGCD(b, a % b);
        long x1 = next.y;
        long y1 = next.x - (a / b) * next.y;
        return new Result(x1, y1, next.gcd);
    }
}
