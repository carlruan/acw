import java.util.Scanner;

public class ACW282 {
    static int N = 310;
    static int n;
    static int[] arr = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
            arr[i] += arr[i - 1];
        }
        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                f[l][r] = (int) 1e8;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][k] + f[k + 1][r] + arr[r] - arr[l - 1], f[l][r]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
