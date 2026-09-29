import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] matrix = new long[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }

        int top = 0;
        int bottom = N - 1;
        int left = 0;
        int right = M - 1;

        StringBuilder result = new StringBuilder();

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++) {
                result.append(matrix[top][j]).append(" ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.append(matrix[i][right]).append(" ");
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.append(matrix[bottom][j]).append(" ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.append(matrix[i][left]).append(" ");
                }
                left++;
            }
        }

        System.out.println(result.toString().trim());

        sc.close();
    }
}
