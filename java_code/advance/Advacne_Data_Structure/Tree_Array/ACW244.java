import java.util.Scanner;

public class ACW244 {
    static int N = 100010;
    static int[] a = new int[N], tr = new int[N], res = new int[N];
    static int n;

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
        for (int i = 2; i <= n; i++) {
            a[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++)
            add(i, 1);
        for (int i = n; i >= 1; i--) {
            int k = a[i] + 1;
            int l = 1, r = n;
            while (l < r) {
                int m = l + r >> 1;
                if (sum(m) >= k)
                    r = m;
                else
                    l = m + 1;
            }
            res[i] = l;
            add(l, -1);
        }
        for (int i = 1; i <= n; i++)
            System.out.println(res[i]);
    }
}
