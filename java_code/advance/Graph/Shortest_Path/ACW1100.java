import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ACW1100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt();
        Queue<Long> q = new LinkedList<>();
        q.add((long) n);
        int res = 0;
        long t = k;
        Set<Long> st = new HashSet<>();
        st.add((long) n);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                long cur = q.poll();
                if (cur == t) {
                    System.out.println(res);
                    return;
                }
                if (cur - 1 >= 0 && !st.contains(cur - 1)) {
                    st.add(cur - 1);
                    q.add(cur - 1);
                }
                if (cur + 1 <= 100000 && !st.contains(cur + 1)) {
                    st.add(cur + 1);
                    q.add(cur + 1);
                }
                if (cur * 2 <= 100000 && !st.contains(cur * 2)) {
                    st.add(cur * 2);
                    q.add(cur * 2);
                }
            }
            res++;
        }
    }
}
