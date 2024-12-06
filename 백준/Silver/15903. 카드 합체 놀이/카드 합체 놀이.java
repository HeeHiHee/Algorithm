import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static long x, y;
    static PriorityQueue<Long> q = new PriorityQueue<>((a,b)->Long.compare(a,b));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        for(int i=0; i<N; i++){q.add(sc.nextLong());}
        for(int i=0; i<M; i++){
            x = q.poll();
            y = q.poll();
            q.add(x+y);
            q.add(x+y);
        }
        long ans = 0;
        while(!q.isEmpty()){ans+=q.poll();}
        System.out.println(ans);
    }
}