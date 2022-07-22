package java_code.basic.ch3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class puzzle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 1, 1 });
        int res = 0;
        int[] dx = new int[] { 0, -1, 0, 1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cur = q.poll();

                if (cur[0] == m && cur[1] == n) {
                    System.out.println(res);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    // System.out.println(nx + " " + ny);
                    if (nx < 1 || nx > m || ny < 1 || ny > n || matrix[nx][ny] == 1)
                        continue;
                    matrix[nx][ny] = 1;
                    q.add(new int[] { nx, ny });

                }
            }
            res++;
        }
    }
}
