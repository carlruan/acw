import java.util.Arrays;
import java.util.Scanner;

public class ACW859 {
    static int N = (int) 1e5 + 10;
    static int M = 2 * N;
    static int n, m;
    static int[] p = new int[N];

    static class Edge implements Comparable<Edge> {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(ACW859.Edge o) {
            return this.c - o.c;
        }

    }

    static Edge[] e = new Edge[M];

    static int find(int i) {
        if (i != p[i]) {
            p[i] = find(p[i]);
        }
        return p[i];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++)
            p[i] = i;
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            e[i] = new Edge(a, b, c);
        }
        Arrays.sort(e, 0, m);
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int a = e[i].a, b = e[i].b, c = e[i].c;
            int pa = find(a), pb = find(b);
            if (pa == pb)
                continue;
            res += c;
            cnt++;
            p[pa] = pb;
        }
        if (cnt >= n - 1)
            System.out.println(res);
        else
            System.out.println("impossible");
    }
}
