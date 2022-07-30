import java.util.Scanner;

public class ACW275 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        int[][] g = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scan.nextInt();
            }
        }
        int[][][] f = new int[m + n + 1][m + 1][m + 1];
        for (int k = 2; k <= m + n; k++) {
            for (int i1 = 1; i1 <= m; i1++) {
                int j1 = k - i1;
                if (j1 < 1 || j1 > n)
                    continue;
                for (int i2 = 1; i2 <= m; i2++) {
                    int j2 = k - i2;
                    if (j2 < 1 || j2 > n)
                        continue;
                    int cur = g[i1][j1] + g[i2][j2];
                    if (i1 == i2)
                        continue;
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2]);
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2]);
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1]);
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1]);
                    f[k][i1][i2] += cur;
                }
            }
        }
        System.out.println(f[m + n][m][m]);
    }
}
