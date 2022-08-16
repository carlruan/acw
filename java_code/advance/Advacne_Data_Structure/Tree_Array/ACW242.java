import java.util.Scanner;

public class ACW242 {
    static int N = 100010;
    static int[] a = new int[N], s = new int[N], tr = new int[N];
    static int n, m;

    static void add(int x, int c) {
        for (int i = x; i <= n; i += i & -i)
            tr[i] += c;
    }

    static int sum(int x) {
        int res = 0;
        for (int i = x; i >= 1; i -= i & -i)
            res += tr[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            add(i, a[i] - a[i - 1]);
        }
        while (m-- > 0) {
            char op = scan.next().charAt(0);
            if (op == 'Q') {
                int idx = scan.nextInt();
                System.out.println(sum(idx));
            } else {
                int l = scan.nextInt(), r = scan.nextInt(), d = scan.nextInt();
                add(l, d);
                add(r + 1, -d);
            }
        }
    }
}