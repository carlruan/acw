import java.util.Scanner;

public class ACW154 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int[] q = new int[n];
        int head = 0, tail = -1;
        for (int i = 0; i < n; i++) {
            while (head <= tail && i - q[head] + 1 > k)
                head++;
            while (head <= tail && a[i] <= a[q[tail]])
                tail--;
            q[++tail] = i;
            if (i >= k - 1)
                System.out.print(a[q[head]] + " ");

        }
        System.out.println("");
        head = 0;
        tail = -1;
        for (int i = 0; i < n; i++) {
            while (head <= tail && i - q[head] + 1 > k)
                head++;
            while (head <= tail && a[i] >= a[q[tail]])
                tail--;
            q[++tail] = i;
            if (i >= k - 1)
                System.out.print(a[q[head]] + " ");

        }
    }
}
