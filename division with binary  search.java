import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.*;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        if (y == 0) {
            System.out.println("Division by zero error");
            return;
        }

        double result = divide(x, y);
        if (Math.abs(result - Math.round(result)) < 1e-9) {
            System.out.println((int)Math.round(result));
        } else {
            System.out.printf("%.6f\n", result);
        }
    }

    public static double divide(double x, double y) {
        double low = 0;
        double high = Math.max(x, y); 
        double eps = 1e-9;
        while (high - low > eps) {
            double mid = (low + high) / 2.0;
            double product = y * mid;

            if (Math.abs(product - x) < eps) {
                return mid;
            } else if (product < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (low + high) / 2.0;
    }
}
