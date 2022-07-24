package spfa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACW852 {
    static int N = (int) 1e5 + 10, M = 2 * N;
    static int[] h = new int[N], ne = new int[M], e = new int[M], d = new int[M];
    static int m, n, idx;
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int[] cnt = new int[N];

    static void add(int a, int b, int c) {
        e[idx] = b;
        d[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        idx = 0;
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            add(a, b, c);
        }
        scan.close();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
            st[i] = true;
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            st[cur] = false;
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[cur] + d[i]) {
                    dist[j] = dist[cur] + d[i];
                    cnt[j] = cnt[cur] + 1;
                    if (cnt[j] >= n) {
                        System.out.println("Yes");
                        return;
                    }
                    if (!st[j]) {
                        st[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        System.out.println("No");
    }
}