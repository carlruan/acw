package java_code.basic.ch2;

import java.util.Scanner;
import java.util.Stack;

public class Math {

    private static Stack<Integer> num = new Stack<>();
    private static Stack<Character> op = new Stack<>();

    private static void cal() {
        int n2 = num.pop();
        int n1 = num.pop();
        char c = op.pop();
        if (c == '+')
            num.push(n1 + n2);
        else if (c == '-')
            num.push(n1 - n2);
        else if (c == '*')
            num.push(n1 * n2);
        else
            num.push(n1 / n2);
    }

    private static int getRank(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '(')
            return 0;
        return 2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                num.push(cur);
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    cal();
                }
                op.pop();
            } else {
                while (!op.isEmpty() && getRank(op.peek()) >= getRank(c)) {
                    cal();
                }
                op.push(c);
            }
        }
        while (!op.isEmpty())
            cal();
        System.out.println(num.pop());

    }
}