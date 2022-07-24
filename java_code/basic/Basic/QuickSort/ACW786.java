import java.util.Random;
import java.util.Scanner;

public class ACW786 {

    private final static int N = (int) 1e5;
    private static int[] arr = new int[N];
    private static int n, k;
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        k--;
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        System.out.println(quickSelect());
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]);
    }

    private static int quickSelect() {
        int l = 0, r = n - 1;
        while (l <= r) {
            int j = partition(l, r);
            if (j == k)
                return arr[j];
            else if (j > k) {
                r = j - 1;
            } else
                l = j + 1;
        }
        return -1;
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
