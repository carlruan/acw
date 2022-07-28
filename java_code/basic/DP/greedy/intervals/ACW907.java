import java.util.Arrays;
import java.util.Scanner;

public class ACW907 {
    static int N = 100010;
    static int n;
    static int[][] a = new int[N][2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int t = scan.nextInt();
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }
        Arrays.sort(a, 0, n, (aa, bb) -> aa[0] - bb[0]);
        int res = 0;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            int j = i, r = Integer.MIN_VALUE;
            while (j < n && a[j][0] <= s) {
                r = Math.max(r, a[j][1]);
                j++;
            }
            if (r < s)
                break;
            res++;
            if (r >= t) {
                find = true;
                break;
            }
            i = j - 1;
            s = r;
        }
        if (find)
            System.out.println(res);
        else
            System.out.println(-1);
    }
}