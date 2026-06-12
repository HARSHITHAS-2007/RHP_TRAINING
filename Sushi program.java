import java.util.*;

public class Sushi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        int ans = 0;

        while (i < n && j < m) {
            if (b[j] <= 2 * a[i]) {
                ans++;
                i++;
                j++;
            } else {
                i++;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
