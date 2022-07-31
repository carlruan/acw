import java.util.Scanner;

public class ACW1022 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= k; i++) {
            int cw = scan.nextInt(), cv = scan.nextInt();
            for (int j = n; j >= cw; j--) {
                for (int q = m - 1; q >= cv; q--) {
                    f[j][q] = Math.max(f[j][q], f[j - cw][q - cv] + 1);
                }
            }
        }
        int hp = m - 1;
        while (hp > 0 && f[n][m - 1] == f[n][hp - 1])
            hp--;
        hp = m - hp;
        System.out.println(f[n][m - 1] + " " + hp);

    }
}
