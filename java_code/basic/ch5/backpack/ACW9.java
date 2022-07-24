import java.util.Scanner;

public class ACW9 {
    static int N = 110, V = 110, S = 110;
    static int[][] v = new int[S][S], w = new int[S][S];
    static int[] s = new int[110];
    static int n, m;
    static int[] f = new int[110];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = scan.nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = scan.nextInt();
                w[i][j] = scan.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                for (int k = 1; k <= s[i]; k++) {
                    if (j >= v[i][k])
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                }
            }
        }
        System.out.println(f[m]);
    }
}
