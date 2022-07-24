package Floyd;

import java.util.Scanner;

public class ACW854 {
    static int N = 210, M = 20010;
    static int n, m, k;
    static int[][] e = new int[N][N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    e[i][j] = 0;
                else
                    e[i][j] = 1000000000;
            }
        }
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
            e[a][b] = Math.min(e[a][b], c);
        }
        scan.close();
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    e[i][j] = Math.min(e[i][j], e[i][k] + e[k][j]);
                }
            }
        }
        while (k-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            if (e[a][b] >= 500000000)
                System.out.println("impossible");
            else
                System.out.println(e[a][b]);
        }
    }
}
