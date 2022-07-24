import java.util.Scanner;

public class ACW798 {

    private static void insert(int[][] s, int x1, int y1, int x2, int y2, int c) {
        s[x1][y1] += c;
        s[x2 + 1][y2 + 1] += c;
        s[x1][y2 + 1] -= c;
        s[x2 + 1][y1] -= c;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt(), n = scan.nextInt(), q = scan.nextInt();

        int[][] arr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        int[][] s = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                insert(s, i, j, i, j, arr[i][j]);
            }
        }

        while (q-- > 0) {
            int x1 = scan.nextInt(), y1 = scan.nextInt(), x2 = scan.nextInt(), y2 = scan.nextInt(), c = scan.nextInt();
            insert(s, x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
                System.out.print(s[i][j] + " ");
            }
            System.out.println("");
        }
    }

}