package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class ACW845 {
    static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static int bfs(String start, String end) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        map.put(start, 0);

        int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.equals(end))
                return map.get(s);

            // 获得x的位置
            int k = s.indexOf('x');
            int x = k / 3, y = k % 3;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a < 3 && a >= 0 && b < 3 && b >= 0) {
                    // 对字符串中的字符进行更改
                    char[] arr = s.toCharArray();
                    swap(arr, k, a * 3 + b);
                    String str = new String(arr);
                    // 如果没有被遍历过
                    if (map.get(str) == null) {
                        map.put(str, map.get(s) + 1);
                        q.offer(str);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String[] s = cin.readLine().split(" ");
        String start = "";
        for (int i = 0; i < s.length; i++)
            start += s[i];
        String end = "12345678x";
        System.out.println(bfs(start, end));
    }
}
