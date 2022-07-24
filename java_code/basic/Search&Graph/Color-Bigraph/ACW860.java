import java.util.Arrays;
import java.util.Scanner;

public class ACW860 {
    static int N = (int) 1e5 + 10, M = (int) 1e5 + 10;
    static int n, m, idx;
    static int[] color = new int[N];
    static int[] h = new int[N], ne = new int[2 * M], e = new int[2 * M];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c))
                    return false;
            } else if (color[j] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        idx = 0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
            add(b, a);
        }
        scan.close();

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
