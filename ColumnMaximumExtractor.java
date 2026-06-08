import java.util.*;

public class ColumnMaximumExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = a[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], a[i][j]);
            }
        }

        for (int j = 0; j < m; j++) {
            System.out.print(dp[n - 1][j] + " ");
        }

        sc.close();
    }
}
