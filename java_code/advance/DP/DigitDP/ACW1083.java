import java.util.Arrays;
import java.util.Scanner;

public class ACW1083 {

    static int N = 12;
    static int[] a = new int[N];
    static int[][] f = new int[N][N];

    static int dp(int pos, int pre, boolean lead, boolean limit) {
        if (pos == 0)
            return 1;
        if (!limit && !lead && f[pos][pre] != -1)
            return f[pos][pre];
        int res = 0, up = limit ? a[pos] : 9;
        for (int i = 0; i <= up; i++) {
            if (Math.abs(pre - i) < 2)
                continue;
            if (lead && i == 0)
                res += dp(pos - 1, i, lead, limit && i == up);
            else
                res += dp(pos - 1, i, false, limit && i == up);
        }
        if (limit || lead)
            return res;
        return f[pos][pre] = res;
    }

    static int cal(int x) {
        int len = 0;
        for (int i = 0; i < N; i++)
            Arrays.fill(f[i], -1);
        while (x > 0) {
            a[++len] = x % 10;
            x /= 10;
        }
        return dp(len, -2, true, true);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt(), r = scan.nextInt();
        System.out.println(cal(r) - cal(l - 1));
    }
}
