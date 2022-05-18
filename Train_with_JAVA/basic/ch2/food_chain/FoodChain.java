import java.util.Scanner;

public class FoodChain {

    private static int[] p = new int[50010];
    private static int[] d = new int[50010];

    private static int find(int x) {
        if (x != p[x]) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt(), res = 0;
        for (int i = 0; i <= n; i++)
            p[i] = i;
        while (k-- > 0) {
            int t = scan.nextInt(), x = scan.nextInt(), y = scan.nextInt();
            if (x > n || y > n) {
                res++;
                continue;
            }
            int px = find(x), py = find(y);
            if (t == 1) {
                if (px == py) {
                    if ((d[x] - d[y]) % 3 != 0)
                        res++;
                } else if (px != py) {
                    p[px] = py;
                    d[px] = d[y] - d[x];
                }
            } else {
                if (px == py) {
                    if ((d[x] - d[y] - 1) % 3 != 0)
                        res++;
                } else if (px != py) {
                    p[px] = py;
                    d[px] = d[y] - d[x] + 1;
                }
            }
        }
        System.out.println(res);
    }
}
