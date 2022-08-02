import java.util.Scanner;

public class ACW1013 {
    static int[] path;
    static int[][] f, w;
    static int idx = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt();
        w = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                w[i][j] = scan.nextInt();
            }
        }
        f = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k] + w[i][k]);
                }
            }
        }
        System.out.println(f[N][M]);
        path = new int[N + 1];
        dfs(N, M);
        for (int i = idx - 1, id = 1; i >= 0; i--, id++) {
            System.out.println(id + " " + path[i]);
        }

    }

    private static void dfs(int i, int j) {
        if (i == 0)
            return;
        for (int a = 0; a <= j; a++) {
            if (f[i][j] == f[i - 1][j - a] + w[i][a]) {
                path[idx++] = a;
                dfs(i - 1, j - a);
                return;
            }
        }
    }
}
