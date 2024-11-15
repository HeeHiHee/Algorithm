import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, a, b, c, res=0, level=0;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N+1];
        for(int i=0; i<N+1; i++){list.add(new ArrayList<>());}
        for(int i=0; i<N; i++){
            a=sc.nextInt(); b=sc.nextInt(); c=sc.nextInt();
            list.get(a).add(b);
            list.get(a).add(c);
            if(b!=-1) res+=2;
            if(c!=-1) res+=2;
        }
        Left(1);
        System.out.println(res-level);
    }
    public static void Left(int node){
        int left = list.get(node).get(1);
        if(left!=-1){level++; Left(left);}
    }
}