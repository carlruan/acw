import java.util.Scanner;

public class ACW1015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        while (k-- > 0) {
            int m = scan.nextInt(), n = scan.nextInt();
            int[][] g = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    g[i][j] = scan.nextInt();
                    g[i][j] += Math.max(g[i - 1][j], g[i][j - 1]);
                }
            }
            System.out.println(g[m][n]);
        }
    }
}
