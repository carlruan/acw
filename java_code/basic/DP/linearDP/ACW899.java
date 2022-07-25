import java.util.Scanner;

public class ACW899 {
    static int N = 1010;
    static String[] s = new String[N];
    static int n, m;

    public static int cal(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] f = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++)
            f[i][0] = i;
        for (int j = 1; j <= l2; j++)
            f[0][j] = j;
        for (int i = 1; i <= l1; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                char c2 = s2.charAt(j - 1);
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                f[i][j] = Math.min(f[i - 1][j - 1] + (c1 == c2 ? 0 : 1), f[i][j]);
            }
        }
        return f[l1][l2];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < n; i++)
            s[i] = scan.next();
        while (m-- > 0) {
            String tg = scan.next();
            int max = scan.nextInt();
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (cal(s[i], tg) <= max)
                    res++;
            }
            System.out.println(res);
        }
    }
}
