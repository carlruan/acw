package java_code.basic.ch1;

import java.util.Scanner;

public class Prefix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + arr[i];
        while (m > 0) {
            m--;
            int l, r;
            l = scan.nextInt();
            r = scan.nextInt();
            System.out.println(s[r] - s[l - 1]);
        }
    }

}
