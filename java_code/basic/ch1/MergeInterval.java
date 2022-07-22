package java_code.basic.ch1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MergeInterval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = scan.nextInt(), r = scan.nextInt();
            intervals.add(new int[] { l, r });
        }
        int res = 1;
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals.get(0)[1];
        for (int i = 1; i < n; i++) {
            int curs = intervals.get(i)[0], cure = intervals.get(i)[1];
            if (curs > end) {
                res++;
                end = cure;
            } else {
                end = Math.max(cure, end);
            }
        }
        System.out.println(res);
    }
}
