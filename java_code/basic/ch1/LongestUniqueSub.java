package java_code.basic.ch1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestUniqueSub {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        int l = 0, r = 0, res = 0;
        Set<Integer> set = new HashSet<>();
        while (r < n) {
            while (set.contains(a[r])) {
                set.remove(a[l++]);
            }
            set.add(a[r]);
            res = r - l + 1 > res ? r - l + 1 : res;
            r++;
        }
        System.out.println(res);
    }

}
