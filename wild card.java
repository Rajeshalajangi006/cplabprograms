import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();;
        String p = sc.nextLine().trim();;

        int i = 0, j = 0;
        int star = -1;
        int match = 0;

        while (i < s.length()) {

            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }

            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }

            // Mismatch: make '*' match one more character
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }

            // No '*' can handle the mismatch
            else {
                System.out.println(0);
                return;
            }
        }

        // Remaining pattern characters must be '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        System.out.println(j == p.length() ? 1 : 0);
    }
}
