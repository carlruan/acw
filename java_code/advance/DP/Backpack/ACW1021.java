import java.util.Scanner;

public class ACW1021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] f = new int[m + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int v = scan.nextInt();
            for (int j = v; j <= m; j++) {
                f[j] += f[j - v];
            }
        }
        System.out.println(f[m]);
    }

}
