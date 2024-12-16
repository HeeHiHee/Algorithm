import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int F, tree[], idx;
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            F = sc.nextInt();
            tree = new int[F*2];
            Arrays.fill(tree, -1);
            map.clear();
            idx = 0; // 사람 수
            for(int i=0; i<F; i++){
                String f1 = sc.next();
                String f2 = sc.next();
                if(!map.containsKey(f1)) map.put(f1, idx++);
                if(!map.containsKey(f2)) map.put(f2, idx++);
                sb.append(union(map.get(f1), map.get(f2)) + "\n");
            }
        }//T
        System.out.println(sb);
    }

    public static int find(int x){
        if(tree[x]<=-1) return x;
        return tree[x] = find(tree[x]);
    }

    public static int union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if (tree[a] > tree[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            tree[a] += tree[b];
            tree[b] = a;
        }
        return -tree[a];
    }
}