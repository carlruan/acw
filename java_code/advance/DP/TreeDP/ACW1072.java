import java.util.Arrays;
import java.util.Scanner;

public class ACW1072 {
    static int n, idx = 0, res = 0;
    static int N = 10010, M = 20010;
    static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int dfs(int u, int f) {
        int d1 = 0, d2 = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == f)
                continue;
            int cur = w[i] + dfs(j, u);
            if (cur >= d1) {
                d2 = d1;
                d1 = cur;
            } else if (cur > d2) {
                d2 = cur;
            }
        }
        res = Math.max(res, d1 + d2);
        return d1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        Arrays.fill(h, -1);
        for (int i = 1; i < n; i++) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        dfs(1, -1);
        System.out.println(res);
    }
}
