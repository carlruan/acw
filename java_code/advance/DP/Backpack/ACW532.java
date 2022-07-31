import java.util.Arrays;
import java.util.Scanner;

public class ACW532 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        while (k-- > 0) {
            int n = scan.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++)
                w[i] = scan.nextInt();
            Arrays.sort(w);
            int m = w[n - 1];
            int res = 0;
            boolean[] f = new boolean[m + 1];
            for (int i = 0; i < n; i++) {
                int cur = w[i];
                if (f[cur])
                    continue;
                res++;
                f[cur] = true;
                for (int j = cur + 1; j <= m; j++) {
                    if (f[j - cur])
                        f[j] = true;
                }
            }
            System.out.println(res);
        }
    }
}
