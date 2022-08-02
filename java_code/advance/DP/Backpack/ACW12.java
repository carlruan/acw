import java.util.Scanner;

public class ACW12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[][] f = new int[n + 2][m + 2];
        int[] v = new int[n + 1], w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i + 1][j];
                if (j >= v[i])
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - v[i]] + w[i]);
            }
        }
        int j = m;
        for (int i = 1; i <= n; i++) {
            if (j >= v[i] && f[i][j] == f[i + 1][j - v[i]] + w[i]) {
                System.out.print(i + " ");
                j -= v[i];
            }
        }
    }
}
