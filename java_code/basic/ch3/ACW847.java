import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACW847 {
    static int M = (int) 1e5 + 10;
    static int N = M;
    static int m, n, idx;
    static int[] h = new int[N + 10], ne = new int[2 * N + 10], e = new int[2 * N + 10];
    static boolean[] st = new boolean[N + 10];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void run() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h, -1);

        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
        }
        st[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int res = 0;

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int cur = q.poll();
                // System.out.println(cur);
                if (cur == n) {
                    System.out.println(res);
                    return;
                }
                for (int j = h[cur]; j != -1; j = ne[j]) {
                    int k = e[j];
                    if (st[k])
                        continue;
                    st[k] = true;
                    q.add(k);
                }
            }
            res++;
        }
        System.out.println(-1);
    }

}