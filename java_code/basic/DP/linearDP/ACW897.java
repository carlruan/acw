import java.util.Scanner;

public class ACW897 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l1 = scan.nextInt(), l2 = scan.nextInt();
        String s1 = scan.next(), s2 = scan.next();
        int[][] f = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1; i++) {
            char c1 = s1.charAt(i);
            for (int j = 0; j < l2; j++) {
                char c2 = s2.charAt(j);
                f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                if (c1 == c2)
                    f[i + 1][j + 1] = Math.max(f[i + 1][j + 1], f[i][j] + 1);
            }
        }
        System.out.println(f[l1][l2]);
    }

}
