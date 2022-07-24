import java.util.Scanner;

public class ACW790 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();
        double l = -100, r = 100;
        while (r - l > 1e-8) {
            double m = (l + r) / 2;
            if (Math.pow(m, 3) > n)
                r = m - 1e-7;
            else
                l = m + 1e-7;
        }
        System.out.printf("%.6f", l);
    }
}