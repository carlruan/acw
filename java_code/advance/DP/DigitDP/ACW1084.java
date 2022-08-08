import java.util.Arrays;
import java.util.Scanner;

public class ACW1084 {
    static int M, N = 15;
    static int[][] f = new int[N][150];
    static int[] a = new int[N];

    static int dp(int pos, int sum, boolean limit) {
        if (pos == 0) {
            return (sum % M) == 0 ? 1 : 0;
        }
        if (!limit && f[pos][sum] != -1)
            return f[pos][sum];
        int res = 0, up = limit ? a[pos] : 9;
        for (int i = 0; i <= up; i++) {
            res += dp(pos - 1, sum + i, limit && up == i);
        }
        if (limit)
            return res;
        return f[pos][sum] = res;
    }

    static int cal(int x) {
        int len = 0;
        for (int i = 0; i < N; i++)
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
            M = scan.nextInt();
            System.out.println(cal(r) - cal(l - 1));
        }

    }
}
