import java.util.Arrays;
import java.util.Scanner;

public class ACW1058 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] f = new int[n + 1][3];
        for (int i = 0; i <= n; i++)
            Arrays.fill(f[i], -(int) 1e9);
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int w = scan.nextInt();
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - w);
            f[i][2] = f[i - 1][1] + w;
        }
        System.out.println(Math.max(f[n][0], f[n][2]));
    }
}
