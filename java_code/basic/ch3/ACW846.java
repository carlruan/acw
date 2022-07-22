package java_code.basic.ch3;

import java.util.Arrays;
import java.util.Scanner;

public class ACW846 {
    static int N = (int) 1e5 + 10;
    static int M = 2 * N;
    static int n, idx;
    static boolean[] v = new boolean[N];
    static int[] h = new int[N], ne = new int[M], e = new int[M];
    static int ans = N;

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int dfs(int u) {
        v[u] = true;
        int res = 0, sum = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (v[j])
                continue;
            int t = dfs(j);
            sum += t;
            res = Math.max(res, t);
        }
        res = Math.max(n - sum, res);
        ans = Math.min(res, ans);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        idx = 0;
        Arrays.fill(h, -1);
        for(int i = 1; i < n; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(ans);
        return;
    }
}
