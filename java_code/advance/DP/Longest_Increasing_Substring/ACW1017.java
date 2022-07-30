import java.util.Arrays;
import java.util.Scanner;

public class ACW1017 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        while (k-- > 0) {
            int n = scan.nextInt();
            int res = 0;
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = scan.nextInt();
            int[] f = new int[n + 1];
            Arrays.fill(f, 1);
            for (int i = n; i >= 1; i--) {
                for (int j = i + 1; j <= n; j++) {
                    if (a[i] > a[j])
                        f[i] = Math.max(f[i], f[j] + 1);
                }
                res = Math.max(res, f[i]);
            }
            Arrays.fill(f, 1);
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = i - 1; j >= 1; j--) {
                    if (a[i] > a[j])
                        f[i] = Math.max(f[i], f[j] + 1);
                }
                res = Math.max(res, f[i]);
            }
            System.out.println(res);
        }
    }
}