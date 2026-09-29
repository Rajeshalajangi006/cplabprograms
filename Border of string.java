import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        String answer = "";

        for (int i = 1; i < n; i++) {

            String prefix = s.substring(0, i);
            String suffix = s.substring(n - i);

            if (prefix.equals(suffix)) {
                answer = prefix;
            }
        }

        if (answer.equals("")) {
            System.out.println("No border");
        } else {
            System.out.println(answer);
        }
    }
}
