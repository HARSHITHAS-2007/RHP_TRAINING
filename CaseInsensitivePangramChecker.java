import java.util.Scanner;

public class PangramCaseInsensitive {

    public static boolean isPangram(String str) {

        int flag = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                flag |= (1 << (ch - 'a'));
            }
        }

        return flag == ((1 << 26) - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(isPangram(str));
        sc.close();
    }
}
