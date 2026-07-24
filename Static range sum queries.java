import java.io.*;

public class Main {

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

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int q = fs.nextInt();

        // prefix[i] = sum of first i elements
        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            long value = fs.nextLong();
            prefix[i] = prefix[i - 1] + value;
        }

        StringBuilder answer = new StringBuilder();

        while (q-- > 0) {

            int a = fs.nextInt();
            int b = fs.nextInt();

            long sum = prefix[b] - prefix[a - 1];

            answer.append(sum).append('\n');
        }

        System.out.print(answer);
    }
}
