import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N+1];

        back(0);

    }//main

    static void back(int idx){
        if(idx==N){
            for(int i=0; i<N; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                arr[idx] = i;
                visited[i] = true;
                back(idx+1);
                visited[i] = false;
            }
        }

    }


}