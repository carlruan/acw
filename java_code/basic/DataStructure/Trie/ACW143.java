import java.util.Scanner;

public class ACW143 {

    private static class Node {
        Node[] child;

        public Node() {
            child = new Node[2];
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            Node cur = root;
            for (int j = 31; j >= 0; j--) {
                int idx = (num >> j) & 1;
                if (cur.child[idx] == null)
                    cur.child[idx] = new Node();
                cur = cur.child[idx];
            }
            if (i == 0)
                continue;
            int ans = 0;
            cur = root;
            for (int j = 31; j >= 0; j--) {
                ans *= 2;
                int idx = (num >> j) & 1;
                if (cur.child[(idx + 1) % 2] != null) {
                    ans++;
                    cur = cur.child[(idx + 1) % 2];
                } else {
                    cur = cur.child[idx];
                }
            }
            res = java.lang.Math.max(res, ans);
        }
        System.out.println(res);
    }
}
