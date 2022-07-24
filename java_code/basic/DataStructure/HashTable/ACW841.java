import java.util.Scanner;

public class ACW841 {

    private static int mod = 13131;
    private static int N = (int) 1e5 + 10;
    private static long[] s = new long[N], p = new long[N];
    private static String str;
    private static int n, m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        str = scan.next();
        str = "!" + str;
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * mod;
            s[i] = s[i - 1] * mod + str.charAt(i);
        }

        while (m-- > 0) {
            int l1 = scan.nextInt(), r1 = scan.nextInt(), l2 = scan.nextInt(), r2 = scan.nextInt();
            if ((s[r1] - s[l1 - 1] * p[r1 - l1 + 1]) == (s[r2] - s[l2 - 1] * p[r2 - l2 + 1])) {
                System.out.println("Yes");
            } else
                System.out.println("No");

        }
    }

}
