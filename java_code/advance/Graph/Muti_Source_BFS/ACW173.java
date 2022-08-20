import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ACW173 {
    static int[][] g = new int[1010][1010];
    static int[][] q = new int[1000010][2];

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        int hh = 0, tt = -1;
        for (int i = 0; i < m; i++) {
            char[] s = scan.next().toCharArray();
            Arrays.fill(g[i], -1);
            for (int j = 0; j < n; j++) {
                int cur = s[j] - '0';
                if (cur == 1) {
                    q[++tt] = new int[] { i, j };
                    g[i][j] = 0;
                }
            }
        }
        scan.close();
        int[] dx = new int[] { 0, -1, 0, 1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        while (hh <= tt) {
            int[] cur = q[hh++];
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] != -1)
                    continue;
                g[nx][ny] = g[x][y] + 1;
                q[++tt] = new int[] { nx, ny };
            }

        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out.write(g[i][j] + " ");
            }
            out.write("\n");
        }
        out.flush();
    }
}
