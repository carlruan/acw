import java.util.Scanner;

public class ACW900 {
    static int N = 1010;
    static int[] f = new int[N];
    static int n, mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] += f[j - i];
                f[j] %= mod;
            }
        }
        System.out.println(f[n]);
    }
}
