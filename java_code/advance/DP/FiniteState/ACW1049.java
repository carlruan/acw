import java.util.Scanner;

public class ACW1049 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        while (k-- > 0) {
            int n = scan.nextInt();
            int[] f = new int[n + 1];
            f[1] = scan.nextInt();
            for (int i = 2; i <= n; i++) {
                int cur = scan.nextInt();
                f[i] = Math.max(f[i - 1], cur + f[i - 2]);
            }
            System.out.println(f[n]);
        }
    }
}
