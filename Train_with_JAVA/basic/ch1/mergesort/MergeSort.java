
import java.util.Scanner;

public class MergeSort {

    private static int N = (int) 1e5, n;
    private static int[] arr = new int[N];
    private static int[] aux = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static void mergeSort(int l, int r) {
        if (l >= r)
            return;
        int m = l + r >> 1;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        // for(int i = l; i <= r; i++) aux[i] = arr[i];
        int i = l, j = m + 1, p = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                aux[p++] = arr[i++];
            } else {
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
