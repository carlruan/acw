import java.util.Scanner;
import java.util.Stack;

public class MonoQueue {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {

            int cur = a[i];
            while (!stack.isEmpty() && cur <= stack.peek())
                stack.pop();
            if (stack.isEmpty())
                System.out.print(-1 + " ");
            else
                System.out.print(stack.peek() + " ");
            stack.push(cur);
        }

    }

}