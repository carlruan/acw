import java.util.Scanner;

public class ACW482 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = scan.nextInt();
        int[] up = new int[n + 1], down = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j])
                    up[i] = Math.max(up[i], up[j] + 1);
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (a[i] > a[j])
                    down[i] = Math.max(down[i], down[j] + 1);
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, up[i] + down[i] + 1);
        }
        System.out.println(n - res);
    }
}
