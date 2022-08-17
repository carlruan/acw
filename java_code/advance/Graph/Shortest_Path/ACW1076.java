import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ACW1076 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] g = new int[n][n];
        int[][][] pre = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scan.nextInt();
            }
        }
        boolean[][] st = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        boolean flag = false;
        q.add(new int[] { 0, 0 });
        st[0][0] = true;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if (x == n - 1 && y == n - 1) {
                    flag = true;
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || g[nx][ny] == 1 || st[nx][ny])
                        continue;
                    st[nx][ny] = true;
                    pre[nx][ny][0] = x;
                    pre[nx][ny][1] = y;
                    q.add(new int[] { nx, ny });
                }
            }
            if (flag)
                break;
        }
        Stack<int[]> stack = new Stack<>();
        int i = n - 1, j = n - 1;
        while (true) {
            stack.push(new int[] { i, j });
            if (i == 0 && j == 0)
                break;
            int x = pre[i][j][0], y = pre[i][j][1];
            i = x;
            j = y;
        }
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            System.out.println(cur[0] + " " + cur[1]);
        }
    }
}
