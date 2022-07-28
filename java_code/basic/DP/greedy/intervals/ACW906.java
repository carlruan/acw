import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ACW906 {
    static int N = 100010;
    static int n;
    static int[][] a = new int[N][2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }
        Arrays.sort(a, 0, n, (aa, bb) -> aa[0] - bb[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            int[] i = a[j];
            if (pq.isEmpty())
                pq.add(i[1]);
            else {
                int top = pq.peek();
                if (i[0] <= top) {
                    pq.add(i[1]);
                } else {
                    pq.poll();
                    pq.add(i[1]);
                }
            }
        }
        System.out.println(pq.size());
    }
}
