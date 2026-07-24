import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int N = fs.nextInt();

        long[] X = new long[N];
        long[] prefix = new long[N + 1];

        // Read coordinates
        for (int i = 0; i < N; i++) {
            X[i] = fs.nextLong();
        }

        // Read villagers and create prefix sum
        for (int i = 0; i < N; i++) {
            long P = fs.nextLong();
            prefix[i + 1] = prefix[i] + P;
        }

        int Q = fs.nextInt();

        StringBuilder output = new StringBuilder();

        while (Q-- > 0) {

            long L = fs.nextLong();
            long R = fs.nextLong();

            int left = lowerBound(X, L);
            int right = upperBound(X, R);

            long answer = prefix[right] - prefix[left];

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }

    // First index where X[index] >= target
    static int lowerBound(long[] X, long target) {

        int left = 0;
        int right = X.length;

        while (left < right) {

            int mid = (left + right) / 2;

            if (X[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // First index where X[index] > target
    static int upperBound(long[] X, long target) {

        int left = 0;
        int right = X.length;

        while (left < right) {

            int mid = (left + right) / 2;

            if (X[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static class FastScanner {

        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        long nextLong() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            long sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            long value = 0;

            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
