import java.util.Scanner;

public class ACW426 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt(), p = scan.nextInt();
            for (int j = m; j >= v; j--) {
                f[j] = Math.max(f[j], f[j - v] + v * p);
            }
        }
        System.out.println(f[m]);
    }
}
