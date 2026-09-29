import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Main {

    static void generateSums(int[] arr, int start, int end,
                             List<Long>[] sums) {
        int len = end - start;
        int total = 1 << len;

        for (int mask = 0; mask < total; mask++) {
            long sum = 0;
            int count = 0;

            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[start + i];
                    count++;
                }
            }

            sums[count].add(sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        int mid = n / 2;

        @SuppressWarnings("unchecked")
        List<Long>[] leftSums = new ArrayList[mid + 1];

        @SuppressWarnings("unchecked")
        List<Long>[] rightSums = new ArrayList[n - mid + 1];

        for (int i = 0; i <= mid; i++) {
            leftSums[i] = new ArrayList<>();
        }

        for (int i = 0; i <= n - mid; i++) {
            rightSums[i] = new ArrayList<>();
        }

        generateSums(arr, 0, mid, leftSums);
        generateSums(arr, mid, n, rightSums);

        for (List<Long> list : rightSums) {
            Collections.sort(list);
        }

        long answer = Long.MAX_VALUE;
        int minK = n / 2;
        int maxK = (n + 1) / 2;

        for (int k = minK; k <= maxK; k++) {

            for (int leftCount = 0; leftCount <= mid; leftCount++) {

                int rightCount = k - leftCount;

                if (rightCount < 0 || rightCount >= rightSums.length) {
                    continue;
                }

                List<Long> rightList = rightSums[rightCount];

                for (long leftSum : leftSums[leftCount]) {

                    long target = totalSum / 2 - leftSum;

                    int index = Collections.binarySearch(rightList, target);

                    if (index < 0) {
                        index = -index - 1;

                        if (index < rightList.size()) {
                            long groupSum = leftSum + rightList.get(index);
                            answer = Math.min(answer,
                                    Math.abs(totalSum - 2 * groupSum));
                        }

                        if (index > 0) {
                            long groupSum = leftSum + rightList.get(index - 1);
                            answer = Math.min(answer,
                                    Math.abs(totalSum - 2 * groupSum));
                        }
                    } else {
                        long groupSum = leftSum + rightList.get(index);
                        answer = Math.min(answer,
                                Math.abs(totalSum - 2 * groupSum));
                    }
                }
            }
        }

        System.out.println(answer);

        sc.close();
    }
}
