package java_code.basic.ch1;

import java.util.Scanner;

public class Difference {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = scan.nextInt();
        int[] s = new int[n + 2];
        for (int i = 1; i <= n; i++)
            s[i] = arr[i] - arr[i - 1];
        while (m-- > 0) {
            int l = scan.nextInt(), r = scan.nextInt(), c = scan.nextInt();
            s[r + 1] -= c;
            s[l] += c;
        }
        for (int i = 1; i <= n; i++) {
            s[i] += s[i - 1];
            System.out.print(s[i] + " ");
        }
    }

}
