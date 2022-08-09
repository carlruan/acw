import java.util.Scanner;

public class ACW1098 {

    static int m, n, res = 0, cnt = 0, v = 0;
    static int M = 55;
    static int[][] g = new int[M][M];
    static boolean[][] st = new boolean[M][M];
    static int[] dx = new int[] { 0, -1, 0, 1 };
    static int[] dy = new int[] { -1, 0, 1, 0 };

    static int dfs(int i, int j) {
        st[i][j] = true;
        int room = 1;
        for (int d = 0; d < 4; d++) {
            int nr = i + dx[d], nc = j + dy[d];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || st[nr][nc])
                continue;
            if (((g[i][j] >> d) & 1) > 0)
                continue;
            room += dfs(nr, nc);
        }
        return room;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j]) {
                    res = Math.max(res, dfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(res);
    }
}
