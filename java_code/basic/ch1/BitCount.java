package java_code.basic.ch1;

import java.util.Scanner;

public class BitCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int cnt = 0;
            while (x > 0) {
                cnt++;
                x -= x & -x;
            }
            System.out.print(cnt + " ");
        }
    }
}
