package section10.최대점수구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Question implements Comparable<Question>{
    int s;
    int t;
    public Question(int s, int t){
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Question o){
        if(this.t == o.t) return o.s - this.s;
        else return this.t - o.t;
    }
}

public class Main {
    static int n,m;
    static int[] dy;

    public int solution(ArrayList<Question> arr){
        Collections.sort(arr);
        for (int i=0; i<n; i++){
            Question q = arr.get(i);
            int score = q.s;
            int time = q.t;
            dy[time] = Math.max(dy[time], score);
            for (int j=time; j <= m; j++){
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Question> arr = new ArrayList<>();
        m = sc.nextInt();
        dy = new int[m+1]; // i분에 얻을 수 있는 최대 점수
        for (int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Question(a,b));
        }
        System.out.println(T.solution(arr));
    }
}
