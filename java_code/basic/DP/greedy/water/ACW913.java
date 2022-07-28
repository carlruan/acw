import java.util.Arrays;
import java.util.Scanner;

public class ACW913 {
    static int N = 100010;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        Arrays.sort(a, 0, n);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i] * (n - i - 1);
        }
        System.out.println(res);
    }
}
