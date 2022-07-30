import java.util.Scanner;

public class ACW187 {
    static int N = 55, n, depth;
    static int[] up = new int[N], down = new int[N], a = new int[N];

    static boolean dfs(int d, int u, int su, int sd) {
        if (su + sd > d)
            return false;
        if (u == n)
            return true;

        boolean flag = false;
        for (int i = 1; i <= su; i++) {
            if (a[u] > up[i]) {
                flag = true;
                int old = up[i];
                up[i] = a[u];
                if (dfs(d, u + 1, su, sd))
                    return true;
                up[i] = old;
                break;
            }
        }
        if (!flag) {
            up[su + 1] = a[u];
            if (dfs(d, u + 1, su + 1, sd))
                return true;
        }

        flag = false;
        for (int i = 1; i <= sd; i++) {
            if (a[u] < down[i]) {
                flag = true;
                int old = down[i];
                down[i] = a[u];
                if (dfs(d, u + 1, su, sd))
                    return true;
                down[i] = old;
                break;
            }
        }
        if (!flag) {
            down[sd + 1] = a[u];
            if (dfs(d, u + 1, su, sd + 1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            n = scan.nextInt();
            if (n == 0)
                break;
            for (int i = 0; i < n; i++)
                a[i] = scan.nextInt();
            depth = 0;
            while (!dfs(depth, 0, 0, 0))
                depth++;
            System.out.println(depth);
        }
    }
}
