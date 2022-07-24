package Prim;

import java.util.Arrays;
import java.util.Scanner;

public class ACW858 {
    static int N = 510, M = 100010;
    static int[][] e = new int[N][N];
    static int n, m;
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(d, INF);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    e[i][j] = INF;
                }
            }
        }
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            e[a][b] = e[b][a] = Math.min(e[a][b], c);
        }
        scan.close();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || d[j] < d[t]))
                    t = j;
            }
            if (i > 0 && d[t] == INF) {
                System.out.println("impossible");
                return;
            }
            if (i > 0)
                res += d[t];
            st[t] = true;
            for (int k = 1; k <= n; k++) {
                d[k] = Math.min(e[t][k], d[k]);
            }
        }
        System.out.println(res);
    }
}