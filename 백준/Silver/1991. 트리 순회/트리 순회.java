import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<N; i++){
            int n = sc.next().charAt(0) - 'A';
            for(int j=0; j<2; j++){
                char c = sc.next().charAt(0);
                if(c=='.'){
                    tree.get(n).add(-1);
                }else{
                    tree.get(n).add(c-'A');
                }

            }
        }

        // 전위, 중위, 후위
        Front(0);
        sb.append("\n");
        Mid(0);
        sb.append("\n");
        Back(0);
        System.out.println(sb);
    }

    public static void Front(int node){
        if(node!=-1){
            sb.append((char)(node+'A'));
            Front(tree.get(node).get(0)); // 왼쪽 자식
            Front(tree.get(node).get(1)); // 오른쪽 자식
        }
    }

    public static void Mid(int node){
        if(node!=-1){
            Mid(tree.get(node).get(0));
            sb.append((char)(node+'A'));
            Mid(tree.get(node).get(1));
        }
    }

    public static void Back(int node){
        if(node!=-1){
            Back(tree.get(node).get(0));
            Back(tree.get(node).get(1));
            sb.append((char)(node+'A'));
        }
    }
}