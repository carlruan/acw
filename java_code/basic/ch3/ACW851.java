import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACW851 {
    static int N = (int) 1e5 + 10, M = 2 * N;
    static int[] h = new int[N], ne = new int[M], e = new int[M], d = new int[M];
    static int m, n, idx;
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

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
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        st[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            st[cur] = false;
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[cur] + d[i]) {
                    dist[j] = dist[cur] + d[i];
                    if (!st[j]) {
                        st[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE)
            System.out.println("impossible");
        else
            System.out.println(dist[n]);
    }
}