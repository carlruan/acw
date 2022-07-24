package DFS;

import java.util.Scanner;

public class ACW843 {

    static int n;
    static boolean[] row;
    static boolean[] col;
    static boolean[] dig;
    static boolean[] rdig;
    static boolean[][] m;

    static boolean valid(int i, int j) {
        if (row[i] || col[j] || dig[n + j - i] || rdig[j + i])
            return false;
        return true;
    }

    static void add(int i, int j) {
        row[i] = true;
        col[j] = true;
        dig[n + j - i] = true;
        rdig[i + j] = true;
        m[i][j] = true;
    }

    static void remove(int i, int j) {
        row[i] = false;
        col[j] = false;
        dig[n + j - i] = false;
        rdig[i + j] = false;
        m[i][j] = false;
    }

    static void back(int c) {
        if (c == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (m[i][j])
                        System.out.print("Q");
                    else
                        System.out.print(".");
                }
                System.out.println("");
            }
            System.out.println("");
            return;
        }
        for (int j = 0; j < n; j++) {
            if (valid(c, j)) {
                add(c, j);
                back(c + 1);
                remove(c, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.close();
        row = new boolean[n];
        col = new boolean[n];
        dig = new boolean[2 * n];
        rdig = new boolean[2 * n];
        m = new boolean[n][n];
        back(0);
    }

}