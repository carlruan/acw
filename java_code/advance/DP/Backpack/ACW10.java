import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW10 {

    static List<Integer>[] e;
    static int[] v, w;
    static int[][] f;
    static int m, n;

    private static void dfs(int u) {
        for (int ne : e[u]) {
            dfs(ne);
            for (int i = m - v[u]; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    f[u][i] = Math.max(f[u][i], f[u][i - j] + f[ne][j]);
                }
            }
        }
        for (int i = m; i >= v[u]; i--)
            f[u][i] = f[u][i - v[u]] + w[u];
        for (int i = 0; i < v[u]; i++)
            f[u][i] = 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int root = -1;
        e = new ArrayList[n + 1];
        v = new int[n + 1];
        w = new int[n + 1];
        f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            e[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            int p = scan.nextInt();
            if (p == -1)
                root = i;
            else
                e[p].add(i);
        }
        dfs(root);
        System.out.println(f[root][m]);
    }
}
