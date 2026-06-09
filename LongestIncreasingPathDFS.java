import java.util.Arrays;

public class LongestIncreasingPathDFS { 
    private final int[][] diff = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int dfs(int[][] matrix, int[][] dp, int R, int C, int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int adjMax = 0;

        for (int i = 0; i < 4; i++) {
            int ar = row + diff[i][0];
            int ac = col + diff[i][1];

            if (ar >= 0 && ar < R && ac >= 0 && ac < C && matrix[ar][ac] > matrix[row][col]) {
                adjMax = Math.max(adjMax, dfs(matrix, dp, R, C, ar, ac));
            }
        }

        dp[row][col] = 1 + adjMax;
        return dp[row][col];
    }
