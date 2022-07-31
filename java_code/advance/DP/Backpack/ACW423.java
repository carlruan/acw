import java.util.Scanner;

public class ACW423 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        int[] f = new int[m + 1];
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = scan.nextInt();
            v[i] = scan.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= w[i]; j--) {
                f[j] = Math.max(f[j], f[j - w[i]] + v[i]);
            }
        }
        System.out.println(f[m]);
    }
}
