import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW291 {
    static int N = 11, M = 11;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int n = scan.nextInt(), m = scan.nextInt();
            if (n == 0 && m == 0)
                return;
            long[][] f = new long[m + 1][1 << n];
            int[] line = new int[1 << n];
            boolean[] st = new boolean[1 << n];
            List<Integer>[] pre = new ArrayList[1 << n];
            for (int i = 0; i < (1 << n); i++) {
                boolean flag = true;
                int cnt = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (((i >> j) & 1) > 0) {
                        if (cnt % 2 == 1) {
                            flag = false;
                            break;
                        } else {
                            cnt = 0;
                        }
                    } else
                        cnt++;
                }
                if (cnt % 2 == 1)
                    flag = false;
                st[i] = flag;
            }
            for (int i = 0; i < 1 << n; i++) {
                pre[i] = new ArrayList<>();
                for (int j = 0; j < 1 << n; j++) {
                    if ((i & j) == 0 && st[i | j])
                        pre[i].add(j);
                }
            }
            f[0][0] = 1;
            for (int j = 1; j <= m; j++) {
                for (int i = 0; i < 1 << n; i++) {
                    for (int e : pre[i]) {
                        f[j][i] += f[j - 1][e];
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }
}
