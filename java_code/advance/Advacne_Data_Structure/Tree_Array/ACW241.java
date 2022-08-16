import java.util.Arrays;
import java.util.Scanner;

public class ACW241 {
    static int N = 200010, n = 0;
    static int[] a = new int[N], tr = new int[N], gt = new int[N], lt = new int[N];

    static void add(int x, int c) {
        for (int i = x; i <= n; i += i & -i) {
            tr[i] += c;
        }
    }

    static int sum(int x) {
        int res = 0;
        for (int i = x; i >= 1; i -= i & -i) {
            res += tr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 1; i <= n; i++)
            a[i] = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            int cur = a[i];
            gt[i] = sum(n) - sum(cur);
            lt[i] = sum(cur - 1);
            add(cur, 1);
        }
        Arrays.fill(tr, 0);
        long r1 = 0, r2 = 0;
        for (int i = n; i >= 1; i--) {
            int cur = a[i];
            r1 += (long) (sum(n) - sum(cur)) * (long) gt[i];
            r2 += (long) sum(cur - 1) * (long) lt[i];
            add(cur, 1);
        }
        System.out.println(r1 + " " + r2);
    }
}