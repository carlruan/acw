import java.util.Scanner;

public class ACW320 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i + n] = scan.nextInt();
        }

        int[][] f = new int[2 * n + 1][2 * n + 1];

        for (int len = 3; len <= n + 1; len++) {
            for (int l = 1; l + len - 1 <= 2 * n; l++) {
                int r = l + len - 1;
                for (int k = l + 1; k < r; k++) {
                    f[l][r] = Math.max(f[l][r], f[l][k] + f[k][r] + arr[l] * arr[k] * arr[r]);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[i][i + n]);
        }
        System.out.println(res);
    }
}
