import java.util.Arrays;
import java.util.Scanner;

public class ACW1068 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[2 * n + 1];
        int[] s = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i + n] = scan.nextInt();
        }
        for (int i = 1; i <= 2 * n; i++)
            s[i] += a[i] + s[i - 1];

        int[][] f = new int[2 * n + 1][2 * n + 1];
        int[][] g = new int[2 * n + 1][2 * n + 1];
        for (int i = 0; i <= 2 * n; i++) {
            Arrays.fill(f[i], (int) 1e8);
            Arrays.fill(g[i], -(int) 1e8);
            f[i][i] = g[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= 2 * n; l++) {
                int r = l + len - 1;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                    g[l][r] = Math.max(g[l][r], g[l][k] + g[k + 1][r] + s[r] - s[l - 1]);

                }
            }
        }
        int min = (int) 1e8, max = -(int) 1e8;
        for (int i = 1; i + n - 1 <= 2 * n; i++) {
            min = Math.min(f[i][i + n - 1], min);
            max = Math.max(g[i][i + n - 1], max);
        }
        System.out.println(min);
        System.out.println(max);

    }
}
