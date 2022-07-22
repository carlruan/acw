// package java_code.basic.ch3;

import java.util.Arrays;
import java.util.Scanner;

public class ACW849 {

    static int N = 510, M = (int) 1e5 + 10;
    static int n, m, idx;

    static int[] dist = new int[N];
    static int[][] e = new int[N][N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++)
            Arrays.fill(e[i], Integer.MAX_VALUE / 2);
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            e[a][b] = Math.min(e[a][b], c);
        }
        dist[1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            st[t] = true;
            for (int ne = 1; ne <= n; ne++) {
                dist[ne] = Math.min(dist[t] + e[t][ne], dist[ne]);
            }
        }
        if (dist[n] == Integer.MAX_VALUE / 2)
            System.out.println(-1);
        else
            System.out.println(dist[n]);
    }
}
