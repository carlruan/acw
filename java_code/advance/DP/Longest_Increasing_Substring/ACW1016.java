import java.util.Scanner;

public class ACW1016 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = scan.nextInt();
        int[] f = a.clone();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                if (a[i] > a[j])
                    max = Math.max(max, f[j]);
            }
            f[i] += max;
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}
