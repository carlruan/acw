import java.util.Arrays;
import java.util.Scanner;

public class ACW1073 {
    static int N = 10010, M = 20010, n = 0, idx = 0;
    static int[] h = new int[N], ne = new int[M], e = new int[M], w = new int[M],
            d1 = new int[N], d2 = new int[N], p1 = new int[N], p2 = new int[N], up = new int[N];

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int dfs(int u, int f) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == f)
                continue;
            int cur = w[i] + dfs(j, u);
            if (cur >= d1[u]) {
                d2[u] = d1[u];
                p2[u] = p1[u];
                d1[u] = cur;
                p1[u] = j;
            } else if (cur > d2[u]) {
                d2[u] = cur;
                p2[u] = j;
            }
        }
        return d1[u];
    }

    static void dfsu(int u, int f) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == f)
                continue;
            if (p1[u] == j)
                up[j] = Math.max(up[u], d2[u]) + w[i];
            else
                up[j] = Math.max(up[u], d1[u]) + w[i];
            dfsu(j, u);
        }
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
        dfsu(1, -1);
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = Math.max(res, up[i]);
        System.out.println(res);
    }

}
