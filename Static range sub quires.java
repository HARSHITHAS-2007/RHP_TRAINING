import java.io.*;
import java.util.*;

public class Main {

    static int[] tree;
    static int n;

    // Build segment tree
    static void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    // Range minimum query
    static int query(int node, int start, int end, int l, int r) {

        // Completely outside the range
        if (r < start || end < l) {
            return Integer.MAX_VALUE;
        }

        // Completely inside the range
        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);

        return Math.min(left, right);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int answer = query(1, 0, n - 1, a, b);

            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }
}
