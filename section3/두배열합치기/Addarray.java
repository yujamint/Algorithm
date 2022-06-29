package section3.두배열합치기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Addarray {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>(n+m);
        for (int i : arr1)
            answer.add(i);
        for (int i : arr2)
            answer.add(i);
        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Addarray a = new Addarray();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++)
            arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++)
            arr2[i] = sc.nextInt();

        for(int num : a.solution(n, arr1, m, arr2))
            System.out.print(num + " ");
    }
}
