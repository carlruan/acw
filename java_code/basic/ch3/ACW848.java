import java.util.*;

public class ACW848 {
    static int M = (int) 1e5 + 10;
    static int N = M;
    static int m, n;
    static int[] in = new int[N];
    static List<Integer>[] out = new ArrayList[N];

    public static void run() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++)
            out[i] = new ArrayList<>();
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            in[b]++;
            out[a].add(b);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (in[i] == 0)
                q.add(i);
        if (q.isEmpty()) {
            System.out.println(-1);
            return;
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int cur = q.poll();
                res.add(cur);
                for (int ne : out[cur]) {
                    if (--in[ne] == 0)
                        q.add(ne);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] > 0) {
                System.out.println(-1);
                return;
            }
        }
        for (int e : res)
            System.out.print(e + " ");
    }
}
