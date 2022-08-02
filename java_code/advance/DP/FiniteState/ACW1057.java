import java.util.Arrays;
import java.util.Scanner;

public class ACW1057 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[][][] f = new int[n + 1][m + 1][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++)
                Arrays.fill(f[i][j], (int) -1e8);
            f[i][0][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int p = scan.nextInt();
            for (int j = 1; j <= m; j++) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + p);
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - p);
            }
        }
        int res = 0;
        for (int i = 0; i <= m; i++)
            res = Math.max(res, f[n][i][0]);
        System.out.println(res);
    }
}
