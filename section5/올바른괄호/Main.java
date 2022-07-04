package section5.올바른괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String s) {
        String answer = "NO";
        Stack<Character> stack = new Stack<Character>();
        for(char x : s.toCharArray()){
            if(x=='(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        return answer;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
