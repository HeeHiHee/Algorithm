import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, a, b, c, cnt=0, v=0, res=0;
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
        }
        Inorder(1);
        System.out.println(res);

    }

    public static void Inorder(int node){
        int left = list.get(node).get(0);
        int right = list.get(node).get(1);

        if(left==-1 && right==-1){
            visit[node] = true;
            v++;
            if(v==N){res = cnt;}
            return;
        }

        if(left!=-1 &&!visit[left]){
            cnt++;
            Inorder(left);
            cnt++;
        }
        visit[node] = true;
        v++;
        if(v==N){res = cnt;} // 노드에 자식이 2개 아닌 경우
        if(right!=-1 && !visit[right]){
            cnt++;
            Inorder(right);
            cnt++;
        }
    }
}