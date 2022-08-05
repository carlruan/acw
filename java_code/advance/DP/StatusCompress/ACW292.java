import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW292 {

    static int n, m;

    static boolean check(int x) {
        if ((x & (x >> 1)) > 0)
            return false;
        if ((x & (x >> 2)) > 0)
            return false;
        return true;
    }

    static int cal(int x) {
        int res = 0;
        while (x > 0) {
            res += x & 1;
            x >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        int[] g = new int[m + 3];
        for (int i = 1; i <= m; i++) {
            char[] c = scan.next().toCharArray();
            for (int j = 0; j < n; j++) {
                int t = c[j] == 'H' ? 1 : 0;
                g[i] += (t << j);
            }
        }
        int[] cnt = new int[1 << n];
        List<Integer> valid = new ArrayList<>();
        List<Integer>[] head = new List[1 << n];
        for (int i = 0; i < 1 << n; i++)
            head[i] = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            if (check(i)) {
                valid.add(i);
                cnt[i] = cal(i);
            }
        }
        for (int a : valid) {
            for (int b : valid) {
                if ((a & b) == 0) {
                    head[a].add(b);
                }
            }
        }
        long[][][] f = new long[2][1 << n][1 << n];
        for (int i = 1; i <= m + 2; i++) {
            for (int a : valid) {
                if ((a & g[i]) > 0)
                    continue;
                for (int b : head[a]) {
                    for (int c : head[b]) {
                        if ((a & c) > 0)
                            continue;
                        f[i & 1][a][b] = Math.max(f[i & 1][a][b], f[(i - 1) & 1][b][c] + cnt[a]);
                    }
                }
            }
        }
        System.out.println(f[m & 1][0][0]);
    }

}
