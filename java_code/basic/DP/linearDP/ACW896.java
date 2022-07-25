import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACW896 {
    static int N = 1010;
    static int n;
    static int[] arr = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if (list.isEmpty() || cur > list.get(list.size() - 1)) {
                list.add(cur);
                continue;
            }
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= cur)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (list.isEmpty() || l >= list.size())
                list.add(cur);
            else
                list.set(l, cur);
        }
        System.out.println(list.size());
    }
}
