import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACW1106 {

    static int n, c1, c2;
    static int[][] g;
    static boolean[][] st;
    static boolean v = false, p = false;
    // (i−1,j−1),(i−1,j),(i−1,j+1),(i,j−1),(i,j+1),(i+1,j−1),(i+1,j),(i+1,j+1)
    static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        g = new int[n][n];
        st = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (st[i][j])
                    continue;
                v = p = true;
                bfs(i, j);
                if (p)
                    c2++;
                if (v)
                    c1++;
            }
        }
        System.out.println(c1 + " " + c2);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        st[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 8; d++) {
                int nr = x + dx[d], nc = y + dy[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;
                if (g[x][y] > g[nr][nc])
                    p = false;
                if (g[x][y] < g[nr][nc])
                    v = false;
                if (g[x][y] != g[nr][nc] || st[nr][nc])
                    continue;
                st[nr][nc] = true;
                q.add(new int[] { nr, nc });
            }
        }
    }
}
