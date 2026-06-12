import java.util.*;

public class KarenAndCoffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int intervals = sc.nextInt();
        int required = sc.nextInt();
        int queries = sc.nextInt();

        int[] mark = new int[200002];

        for (int idx = 0; idx < intervals; idx++) {
            int startPos = sc.nextInt();
            int endPos = sc.nextInt();

            mark[startPos]++;
            mark[endPos + 1]--;
        }

        int[] coverage = new int[200001];

        for (int pos = 1; pos <= 200000; pos++) {
            coverage[pos] = coverage[pos - 1] + mark[pos];
        }

        int[] qualifiedPrefix = new int[200001];

        for (int pos = 1; pos <= 200000; pos++) {
            qualifiedPrefix[pos] =
                    qualifiedPrefix[pos - 1]
                    + (coverage[pos] >= required ? 1 : 0);
        }

        while (queries-- > 0) {
            int leftBound = sc.nextInt();
            int rightBound = sc.nextInt();

            System.out.println(
                    qualifiedPrefix[rightBound]
                    - qualifiedPrefix[leftBound - 1]
            );
        }

        sc.close();
    }
}
