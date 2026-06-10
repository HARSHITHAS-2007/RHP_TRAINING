import java.util.Scanner;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String s2 = sc.nextLine();

        int rows = s1.length();
        int cols = s2.length();

        int[][] dp = new int[rows + 1][cols + 1];
        int maxLength = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println("Length of Longest Common Substring: " + maxLength);

        sc.close();
    }
}
