import java.util.Scanner;

public class StringCombinationGenerator {

    public static void printCombinations(String str) {

        int n = str.length();

        for (int mask = 1; mask < (1 << n); mask++) {

            StringBuilder comb = new StringBuilder();

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) > 0) {
                    comb.append(str.charAt(i));
                }
            }

            System.out.println(comb);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        printCombinations(str);
        sc.close();
    }
}
