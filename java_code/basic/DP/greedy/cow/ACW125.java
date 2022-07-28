import java.util.Arrays;
import java.util.Scanner;

public class ACW125 {
    static int N = 50010;
    static int[][] a = new int[N][2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int w = scan.nextInt(), s = scan.nextInt();
            a[i][0] = w + s;
            a[i][1] = w;
        }
        Arrays.sort(a, 0, n, (aa, bb) -> aa[0] - bb[0]);
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int w = a[i][1];
            int s = a[i][0] - w;
            res = Math.max(res, sum - s);
            sum += w;
        }
        System.out.println(res);
    }
}
