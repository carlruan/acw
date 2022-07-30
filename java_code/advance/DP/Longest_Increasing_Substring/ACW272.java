import java.util.Scanner;

public class ACW272 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scan.nextInt();
        }
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int maxv = 1;
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (a[i] == b[j]) {
                    f[i][j] = Math.max(f[i][j], maxv);
                }
                if (a[i] > b[j])
                    maxv = Math.max(maxv, f[i - 1][j] + 1);
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);
    }
}
