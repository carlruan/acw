import java.util.Scanner;

public class ACW1027 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] g = new int[n + 1][n + 1];
        while (true) {
            int r = scan.nextInt(), c = scan.nextInt(), d = scan.nextInt();
            if (r == 0 || c == 0)
                break;
            g[r][c] = d;
        }
        int[][][] f = new int[2 * n + 1][n + 1][n + 1];
        for (int k = 2; k <= 2 * n; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                int j1 = k - i1;
                if (j1 < 1 || j1 > n)
                    continue;
                for (int i2 = 1; i2 <= n; i2++) {
                    int j2 = k - i2;
                    if (j2 < 1 || j2 > n)
                        continue;
                    int cur = g[i1][j1];
                    if (i1 != i2)
                        cur += g[i2][j2];
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2]);
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2]);
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1]);
                    f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1]);
                    f[k][i1][i2] += cur;
                }
            }
        }
        System.out.println(f[2 * n][n][n]);
    }
}
