import java.util.*;

public class RowMaximumExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                dp[i] = Math.max(dp[i], a[i][j]);
            }
        }

        for (int x : dp) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
