import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW285 {
    static int N = 6010;
    static int[] h = new int[N];
    static int[] p = new int[N];
    static List<Integer>[] ne = new ArrayList[N];
    static int[][] f = new int[N][2];
    static int res = 0;
    static boolean[] has = new boolean[N];

    public static void dfs(int u) {
        f[u][1] = h[u];
        for (int e : ne[u]) {
            dfs(e);
            f[u][0] += Math.max(f[e][1], f[e][0]);
            f[u][1] += f[e][0];
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            h[i] = scan.nextInt();
            ne[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            ne[b].add(a);
            has[a] = true;
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (!has[i]) {
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.max(f[root][1], f[root][0]));
    }
}