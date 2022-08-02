import java.util.Scanner;

public class ACW11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] f = new int[m + 1];
        int[] g = new int[m + 1];
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= m; i++)
            f[i] = -99999999;
        g[0] = 1;
        for (int i = 1; i <= n; i++) {
            int v = scan.nextInt(), w = scan.nextInt();
            for (int j = m; j >= v; j--) {
                int t = Math.max(f[j], f[j - v] + w);
                int s = 0;
                if (t == f[j])
                    s += g[j];
                if (t == f[j - v] + w)
                    s += g[j - v];
                if (s > mod)
                    s -= mod;
                f[j] = t;
                g[j] = s;
            }
        }
        int mv = 0;
        int res = 0;
        for (int i = 0; i <= m; i++)
            mv = Math.max(mv, f[i]);
        for (int i = 0; i <= m; i++)
            if (f[i] == mv)
                res = (res + g[i]) % mod;
        System.out.println(res);
    }
}
