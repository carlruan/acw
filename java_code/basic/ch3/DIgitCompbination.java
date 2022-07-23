import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DIgitCompbination {
    static int n;

    static void dfs(List<Integer> cur) {
        if (cur.size() == n) {
            for (int num : cur) {
                System.out.print(num + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (cur.contains(i))
                continue;
            cur.add(i);
            int l = cur.size();
            dfs(cur);
            cur.remove(l - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dfs(new ArrayList<>());

    }
}
