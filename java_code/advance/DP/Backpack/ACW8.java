import java.util.Scanner;

public class Main {
    public static void ACW8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), V = scan.nextInt(), M = scan.nextInt();
        int[][] f = new int[V + 1][M + 1];
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt(), m = scan.nextInt(), w = scan.nextInt();
            for (int j = V; j >= v; j--) {
                for (int k = M; k >= m; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - v][k - m] + w);
                }
            }
        }
        System.out.println(f[V][M]);
    }
}
