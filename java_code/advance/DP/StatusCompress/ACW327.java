import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW327 {
    static int n, m;

    static boolean check(int x) {
        for (int i = 0; i < n - 1; i++) {
            if (((x >> i) & 1) > 0 && ((x >> (i + 1)) & 1) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        int mod = (int) 1e8;
        int[] g = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                int tp = scan.nextInt();
                tp = tp == 1 ? 0 : 1;
                g[i] += (tp << j);
            }
        }
        List<Integer> valid = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            if (check(i))
                valid.add(i);
        }
        List<Integer>[] pre = new ArrayList[1 << n];
        for (int i = 0; i < 1 << n; i++)
            pre[i] = new ArrayList<>();
        for (int a : valid) {
            for (int b : valid) {
                if ((a & b) == 0) {
                    pre[a].add(b);
                }
            }
        }
        long[][] f = new long[m + 1][1 << n];
        f[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int a : valid) {
                for (int b : pre[a]) {
                    if ((a & g[i]) > 0)
                        continue;
                    f[i][a] = (f[i][a] + f[i - 1][b]) % mod;
                }
            }
        }
        long res = 0;
        for (int a : valid) {
            res = (res + f[m][a]) % mod;
        }
        System.out.println(res);
    }
}