import java.util.Random;
import java.util.Scanner;

class ACW785 {

    private final static int N = (int) 1e5;
    private static int[] arr = new int[N];
    private static int n;
    private static Random random = new Random();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        quickSort(0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static void quickSort(int l, int r) {
        if (l >= r)
            return;
        int m = partition(l, r);
        quickSort(l, m - 1);
        quickSort(m + 1, r);
    }

    private static int partition(int l, int r) {
        int idx = random.nextInt(r - l + 1) + l;
        swap(l, idx);
        int v = arr[l];
        int i = l, j = r + 1;
        while (true) {
            while (arr[++i] < v) {
                if (i >= r)
                    break;
            }
            while (arr[--j] > v) {
                if (j <= l)
                    break;
            }
            if (i >= j)
                break;

            swap(i, j);
        }
        swap(l, j);
        return j;
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}