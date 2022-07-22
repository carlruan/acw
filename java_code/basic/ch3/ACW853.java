import java.util.Arrays;
import java.util.Scanner;

public class ACW853 {
    static int N = 510, M = 10010;
    static int[] d = new int[N], dd = new int[N];

    static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static Edge[] e = new Edge[M];
    static int n, m, k;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        Arrays.fill(d, Integer.MAX_VALUE / 2);
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            e[i] = new Edge(a, b, c);
        }
        d[1] = 0;
        for (int i = 0; i < k; i++) {
            dd = d.clone();
            for (int j = 0; j < m; j++) {
                int a = e[j].a, b = e[j].b, c = e[j].c;
                d[b] = Math.min(d[b], dd[a] + c);
            }
        }
        if (d[n] >= Integer.MAX_VALUE / 4)
            System.out.println("impossible");
        else
            System.out.println(d[n]);
    }

}
