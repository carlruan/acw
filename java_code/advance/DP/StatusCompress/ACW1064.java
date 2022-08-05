import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW1064 {

    static int n, k;

    static int cnt(int x) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (((x >> i) & 1) > 0)
                sum++;
        }
        return sum;
    }

    static boolean check(int x) {
        for (int i = 0; i < n - 1; i++) {
            if (((x >> i) & 1) > 0 && ((x >> (i + 1)) & 1) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        int[] cnt = new int[1 << n];
        List<Integer> valid = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            if (check(i)) {
                valid.add(i);
                cnt[i] = cnt(i);
            }
        }
        List<Integer>[] head = new ArrayList[1 << n];
        for (int i = 0; i < 1 << n; i++)
            head[i] = new ArrayList<>();
        for (int a : valid) {
            for (int b : valid) {
                if ((a & b) == 0 && check(a | b)) {
                    head[a].add(b);
                }
            }
        }
        long[][][] f = new long[n + 1][k + 1][1 << n];
        f[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int a : valid) {
                    for (int b : head[a]) {
                        int c = cnt[a];
                        if (j >= c)
                            f[i][j][a] += f[i - 1][j - c][b];
                    }
                }
            }
        }
        long res = 0;
        for (int a : valid) {
            res += f[n][k][a];
        }
        System.out.println(res);
    }
}
