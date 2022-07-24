import java.util.Scanner;

public class ACW2816 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = scan.nextInt();
        int l = 0;
        for (int i = 0; i < m; i++) {
            if (a[l] == b[i])
                l++;
            if (l == n)
                break;
        }
        if (l == n)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}