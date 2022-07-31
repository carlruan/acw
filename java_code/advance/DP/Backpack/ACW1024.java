import java.util.Scanner;

public class ACW1024 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt(), n = scan.nextInt();
        int[] f = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            int v = scan.nextInt();
            for (int j = V; j >= v; j--)
                f[j] = Math.max(f[j], f[j - v] + v);
        }
        System.out.println(V - f[V]);
    }
}
