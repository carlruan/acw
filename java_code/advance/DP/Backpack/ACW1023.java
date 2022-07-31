import java.util.Scanner;

public class ACW1023 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] f = new int[n + 1];
        int[] m = new int[] { 10, 20, 50, 100 };
        f[0] = 1;
        for (int e : m) {
            for (int i = e; i <= n; i++) {
                f[i] += f[i - e];
            }
        }
        System.out.println(f[n]);
    }
}
