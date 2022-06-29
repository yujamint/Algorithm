package section3.공통원소구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Commonelement {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i : arr1)
            temp.add(i);
        for (int i : arr2)
            temp.add(i);
        for(int i=0; i<temp.size(); i++){
            for(int j=i+1; j<temp.size(); j++){
                if(temp.get(j).equals(temp.get(i))) {
                    answer.add(temp.get(j));
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        Commonelement c = new Commonelement();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++)
            arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++)
            arr2[i] = sc.nextInt();

        for(int num : c.solution(n, arr1, m, arr2))
            System.out.print(num + " ");
    }
}
