import java.util.*;

public class ACW802 {

    public static void main(String[] args) {
        List<int[]> query = new ArrayList<>();
        List<Integer> all = new ArrayList<>();
        List<int[]> add = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt(), c = scan.nextInt();
            add.add(new int[] { x, c });
            all.add(x);
        }
        for (int i = 0; i < m; i++) {
            int l = scan.nextInt(), r = scan.nextInt();
            query.add(new int[] { l, r });
            all.add(l);
            all.add(r);
        }
        Collections.sort(all);
        int p = 0;
        for (int a : all) {
            if (map.containsKey(a))
                continue;
            map.put(a, p++);
        }
        int[] a = new int[p];
        for (int[] ad : add) {
            a[map.get(ad[0])] += ad[1];
        }

        int[] s = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            s[i] = s[i - 1] + a[i - 1];
        }

        for (int[] q : query) {
            int l = map.get(q[0]), r = map.get(q[1]);
            System.out.println(s[r + 1] - s[l]);
        }
    }

}
