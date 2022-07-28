import java.util.Arrays;
import java.util.Scanner;

public class ACW104 {
    static int N = 100010;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a, 1, n + 1);
        int m;
        if (n % 2 == 0) {
            m = (a[n / 2] + a[n / 2 + 1]) / 2;
        } else
            m = a[n / 2 + 1];
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += Math.abs(a[i] - m);
        }
        System.out.println(res);
    }
}
