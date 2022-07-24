import java.util.Scanner;

public class ACW4 {
    static int N = 110, V = 110;
    static int n, m;
    static int[] f = new int[V];
    static int[] v = new int[N], w = new int[N], s = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }
        scan.close();
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s[i]; k++) {
                    if (j - k * v[i] > 0)
                        f[j] = Math.max(f[j], f[j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(f[m]);
    }
}
