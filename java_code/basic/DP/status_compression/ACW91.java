import java.util.Scanner;

public class ACW91 {
    static int N = 20;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] f = new int[1 << n][n];
        int[][] e = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                e[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = (int) 1e9;
            }
        }
        f[1][0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    for (int k = 0; k < n; k++) {
                        if ((((i - (1 << j)) >> k) & 1) > 0) {
                            f[i][j] = Math.min(f[i][j], f[(i - (1 << j))][k] + e[k][j]);
                        }
                    }
                }
            }
        }
        System.out.println(f[(1 << n) - 1][n - 1]);
    }
}
