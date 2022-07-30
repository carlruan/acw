import java.util.Scanner;

public class ACW1018 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = (int) 1e9;
            f[0][i] = (int) 1e9;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = scan.nextInt();
                if (i == 1 && j == 1)
                    continue;
                f[i][j] += Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }
        System.out.println(f[n][n]);
    }
}
