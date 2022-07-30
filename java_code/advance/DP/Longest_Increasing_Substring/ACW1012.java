import java.util.Arrays;
import java.util.Scanner;

public class ACW1012 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }
        Arrays.sort(a, 1, n + 1, (aa, bb) -> aa[0] - bb[0]);
        int[] f = new int[n + 1];
        int res = 0;
        Arrays.fill(f, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i][1] > a[j][1])
                    f[i] = Math.max(f[i], f[j] + 1);
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}
