import java.util.Arrays;
import java.util.Scanner;

public class AWC1020 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt(), N = scan.nextInt();
        int n = scan.nextInt();
        int[][] f = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++)
            Arrays.fill(f[i], (int) 1e8);
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            for (int j = M; j >= 0; j--) {
                for (int k = N; k >= 0; k--) {
                    f[j][k] = Math.min(f[j][k], f[Math.max(0, j - a)][Math.max(0, k - b)] + c);
                }
            }
        }
        System.out.println(f[M][N]);
    }
}
