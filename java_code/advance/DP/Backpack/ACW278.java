import java.util.Scanner;

public class ACW278 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] f = new int[m + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = scan.nextInt();
            for (int j = m; j >= cur; j--) {
                f[j] += f[j - cur];
            }
        }
        System.out.println(f[m]);
    }
}
