import java.util.Scanner;

public class ACW901 {
    static int N = 310;
    static int[][] a = new int[N][N];
    static int m, n;
    static int[] dx = new int[] { 0, -1, 0, 1 };
    static int[] dy = new int[] { 1, 0, -1, 0 };
    static int[][] f = new int[N][N];

    public static int dfs(int i, int j) {
        if (f[i][j] > 0)
            return f[i][j];
        f[i][j] = 1;
        for (int d = 0; d < 4; d++) {
            int nr = i + dx[d], nc = j + dy[d];
            if (nr < 1 || nc < 1 || nr > m || nc > n || a[nr][nc] >= a[i][j])
                continue;
            f[i][j] = Math.max(f[i][j], dfs(n, nc) + 1);
        }
        return f[i][j];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        System.out.println(res);
    }
}
