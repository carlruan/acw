package java_code.basic.ch1;

import java.util.Scanner;

public class ReversePairs {

    private static int N = (int) 1e5, n;
    private static int[] arr = new int[N];
    private static int[] aux = new int[N];
    private static long res = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        mergeSort(0, n - 1);
        System.out.println(res);
    }

    private static void mergeSort(int l, int r) {
        if (l >= r)
            return;
        int m = l + r >> 1;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        int i = l, j = m + 1, p = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                aux[p++] = arr[i++];
            } else {
                res += m - i + 1;
                aux[p++] = arr[j++];
            }
        }
        while (i <= m)
            aux[p++] = arr[i++];
        while (j <= r)
            aux[p++] = arr[j++];
        for (i = l, j = 0; i <= r; i++, j++)
            arr[i] = aux[j];
    }
}
