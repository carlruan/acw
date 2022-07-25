import java.util.Scanner;

public class ACW902 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        String s1 = scan.next();
        int n = scan.nextInt();
        String s2 = scan.next();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            f[i][0] = i;
        for (int j = 1; j <= n; j++)
            f[0][j] = j;

        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = s2.charAt(j - 1);
                f[i][j] = Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1);
                f[i][j] = Math.min(f[i - 1][j - 1] + (c1 != c2 ? 1 : 0), f[i][j]);
            }
        }
        System.out.println(f[m][n]);
    }
}
