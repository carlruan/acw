import java.util.Arrays;
import java.util.Scanner;

public class ACW861 {
    static int N = 510, M = 100010;
    static int n1, n2, m, idx;
    static int[] h = new int[M], ne = new int[2 * M], e = new int[2 * M], match = new int[N];
    static boolean[] st = new boolean[N];

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean find(int u) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n1 = scan.nextInt();
        n2 = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            add(a, b);
        }
        scan.close();
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i))
                res++;
        }
        System.out.println(res);
    }
}
