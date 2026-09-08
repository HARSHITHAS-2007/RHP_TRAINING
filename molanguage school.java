import java.util.*;

public class Harshitha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        while (a-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();

            int ans = 0;

            for (int i = 0; i < n; i += k) {

                boolean allOnes = true;

                for (int j = i; j < i + k; j++) {

                    if (s.charAt(j) == '0') {
                        allOnes = false;
                        break;
                    }
                }

                if (allOnes) {
                    ans++;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
