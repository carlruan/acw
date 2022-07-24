import java.util.Scanner;

public class ACW5 {
    static int N = 2000010, V = 2010;
    static int n, m;
    static int[] f = new int[V];
    static int[] v = new int[N], w = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int idx = 1;
        for (int i = 1; i <= n; i++) {
            int vol = scan.nextInt(), val = scan.nextInt(), cnt = scan.nextInt();
            int k = 1;
            while (k <= cnt) {
                v[idx] = vol * k;
                w[idx] = val * k;
                idx++;
                cnt -= k;
                k *= 2;
            }
            if (cnt > 0) {
                v[idx] = vol * cnt;
                w[idx] = val * cnt;
                idx++;
            }
        }
        scan.close();
        for (int i = 1; i < idx; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);

            }
        }
        System.out.println(f[m]);
    }
}
