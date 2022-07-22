package java_code.basic.ch1;

import java.util.Scanner;

public class TargetSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), x = scan.nextInt();
        int l = 0, r = m - 1;
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        for (int j = 0; j < m; j++)
            b[j] = scan.nextInt();
        while (true) {
            int cur = a[l] + b[r];
            if (cur == x) {
                System.out.println(l + " " + r);
                return;
            } else if (cur > x)
                r--;
            else
                l++;
        }
    }

}
