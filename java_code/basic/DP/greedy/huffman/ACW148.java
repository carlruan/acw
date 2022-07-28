import java.util.PriorityQueue;
import java.util.Scanner;

public class ACW148 {
    static int N = 10010;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int tmp = scan.nextInt();
            pq.add(tmp);
        }
        int res = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            res += a + b;
            pq.add(a + b);
        }
        System.out.println(res);

    }
}
