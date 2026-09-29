import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();   
        int N = sc.nextInt();   
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = sc.nextInt();

        int result = minCoins(V, coins);
        System.out.println(result);
    }

    static int minCoins(int V, int[] coins) {
        int[] dp = new int[V + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= V; i++) {
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        return dp[V] == Integer.MAX_VALUE ? -1 : dp[V];
    }
}

