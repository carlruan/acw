import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ACW1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(s[i - 1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int cur = a[i];
            if (list.isEmpty()) {
                list.add(cur);
                continue;
            }
            int l = 0, r = list.size();
            while (l < r) {
                int m = l + r >> 1;
                if (cur > list.get(m))
                    r = m;
                else
                    l = m + 1;
            }
            if (l == list.size())
                list.add(cur);
            else
                list.set(l, cur);
        }
        System.out.println(list.size());
        int[] g = new int[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int k = 0;
            while (k < cnt && a[i] > g[k])
                k++;
            g[k] = a[i];
            if (k >= cnt)
                cnt++;
        }
        System.out.println(cnt);

    }
}
