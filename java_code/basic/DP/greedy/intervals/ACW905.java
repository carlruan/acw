import java.util.Arrays;
import java.util.Scanner;

public class ACW905 {
    static int N = 100010;
    static int n;
    static int[][] a = new int[N][2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }
        Arrays.sort(a, 0, n, (aa, bb) -> {
            return aa[0] - bb[0];
        });
        int res = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i][0] > pre) {
                pre = a[i][1];
                res++;
            }
        }
        System.out.println(res);
    }
}