import java.io.*;

public class Main {

    static class FastScanner {
        private final InputStream input = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer = 0;
        private int length = 0;

        private int read() throws IOException {
            if (pointer >= length) {
                length = input.read(buffer);
                pointer = 0;

                if (length <= 0) {
                    return -1;
                }
            }

            return buffer[pointer++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int number = 0;

            while (c > ' ') {
                number = number * 10 + (c - '0');
                c = read();
            }

            return number;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[] lastOccurrence = new int[n + 1];

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            int value = fs.nextInt();

            int previousPosition = lastOccurrence[value];

            answer += (long) (i - previousPosition) * (n - i + 1);

            lastOccurrence[value] = i;
        }

        System.out.println(answer);
    }
}
