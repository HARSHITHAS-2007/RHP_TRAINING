import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long first = sc.nextLong();
            long last = first;

            for (int i = 1; i < n; i++) {
                last = sc.nextLong();
            }

            System.out.println(gcd(first, last));
        }

        sc.close();
    }
}
