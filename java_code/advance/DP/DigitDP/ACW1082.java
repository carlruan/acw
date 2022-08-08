import java.util.Arrays;
import java.util.Scanner;

public class ACW1082 {

    static int N = 15;
    static int[][] f = new int[N][N];
    static int[] a = new int[N];

    static int dp(int pos, int pre, boolean limit) {
        if (pos == 0)
            return 1;
        if (limit && f[pos][pre] != -1)
            return f[pos][pre];
        int up = limit ? a[pos] : 9, res = 0;
        for (int i = 0; i <= up; i++) {
            if (pre > i)
                continue;
            res += dp(pos - 1, i, limit && (i == up));
        }
        if (limit)
            return res;
        return f[pos][pre] = res;
    }

    static int cal(int x) {
        int len = 0;
        for (int i = 0; i < 15; i++)
            Arrays.fill(f[i], -1);
        while (x > 0) {
            a[++len] = x % 10;
            x /= 10;
        }
        return dp(len, 0, true);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int l = scan.nextInt(), r = scan.nextInt();
            System.out.println(cal(r) - cal(l - 1));
        }
    }
}
