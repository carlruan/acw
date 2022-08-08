import java.util.Arrays;
import java.util.Scanner;

public class ACW1081 {
    static int l, r, k, b;
    static int[][] f = new int[32][22];
    static int[] a = new int[32];

    static int dp(int pos, int cnt, boolean limit) {
        if (pos == 0)
            return cnt == k ? 1 : 0;
        int res = 0, up = limit ? a[pos] : b - 1;
        for (int i = 0; i <= up; i++) {
            res += dp(pos - 1, cnt + i, limit && i == up);
        }
        if (limit)
            return res;
        return f[pos][cnt] = res;
    }

    static int cal(int x) {
        int len = 0;
        for (int i = 0; i < 32; i++)
            Arrays.fill(f[i], -1);
        while (x > 0) {
            a[++len] = x % b;
            x /= b;
        }
        return dp(len, 0, true);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        l = scan.nextInt();
        r = scan.nextInt();
        k = scan.nextInt();
        b = scan.nextInt();
        System.out.println(cal(r) - cal(l - 1));
    }
}
