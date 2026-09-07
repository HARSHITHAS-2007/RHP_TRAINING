import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = 0;

            for (int x = 1; x <= m; x++) {
                int count = 0;

                for (int i = 0; i < n; i++) {
                    if (a[i] == x) {
                        count++;
                    } else if (a[i] > x) {
                        count++;

                        if (a[i] - x == x) {
                            count++;
                        }
                    }
                }

                ans = Math.max(ans, count);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
