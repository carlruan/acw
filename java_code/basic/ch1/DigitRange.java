package java_code.basic.ch1;

import java.util.Scanner;

public class DigitRange {

    private static int[] arr = new int[(int) 1e6 + 10];
    private static int[] query = new int[10010];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < k; i++) {
            query[i] = scan.nextInt();
        }
        int left, right;

        for (int i = 0; i < k; i++) {
            int q = query[i];
            int l = 0, r = n - 1;
            while (l < r) {

                int m = l + r >> 1;

                if (arr[m] < q)
                    l = m + 1;
                else
                    r = m;
            }
            if (arr[l] != q) {
                System.out.println("-1 -1");
                continue;
            }
            left = l;
            l = 0;
            r = n - 1;
            while (l < r) {
                int m = l + r + 1 >> 1;
                if (arr[m] > q)
                    r = m - 1;
                else
                    l = m;
            }
            right = l;
            System.out.print(left + " " + right + "\n");
        }

    }
}
