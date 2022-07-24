import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ACW850 {
    static int N = 150010, M = 150010;
    static int n, m, idx;

    static class Node implements Comparable<Node> {
        int p, v;

        public Node(int p, int v) {
            this.p = p;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }

    }

    static int[] h = new int[M], e = new int[M], ne = new int[M], d = new int[M], dist = new int[N];
    static boolean[] st = new boolean[N];

    public static void add(int a, int b, int c) {
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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int p = cur.p, v = cur.v;
            if (st[p])
                continue;
            st[p] = true;
            for (int i = h[p]; i != -1; i = ne[i]) {
                int j = e[i];
                if (v + d[i] < dist[j]) {
                    dist[j] = v + d[i];
                    pq.add(new Node(j, dist[j]));
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dist[n]);
    }
}
