import java.util.Scanner;

public class ACW898 {
    static int N = 510;
    static int n;
    static int[][] t = new int[N][N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                t[i][j] = scan.nextInt();
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                t[i][j] += Math.max(t[i + 1][j], t[i + 1][j + 1]);
            }
        }
        System.out.println(t[1][1]);
    }
}
