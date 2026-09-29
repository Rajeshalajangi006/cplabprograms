import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        boolean hasFraction = false;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
            if (arr[i] % 1 != 0) hasFraction = true; 
        }
        bucketSort(arr);
        for (int i = 0; i < n; i++) {
            if (hasFraction)
                System.out.printf("%.2f", arr[i]);
            else
                System.out.print((int) arr[i]);
            if (i != n - 1) System.out.print(" ");
        }
    }
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();
        double min = arr[0], max = arr[0];
        for (double num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        for (double num : arr) {
            int index = (int)((num - min) / (max - min + 1e-9) * n);
            if (index >= n) index = n - 1;
            buckets[index].add(num);
        }

        for (List<Double> bucket : buckets) Collections.sort(bucket);

        int idx = 0;
        for (List<Double> bucket : buckets)
            for (double num : bucket)
                arr[idx++] = num;
    }
}
