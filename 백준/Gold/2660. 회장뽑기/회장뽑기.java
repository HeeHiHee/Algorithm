import java.util.*;

public class Main {
    static int N, score[], visit[];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1;
        score = new int[N];
        visit = new int[N];
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        while(true){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(u==-1 && v==-1) break;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<N; j++){visit[j]=-1;}
            BFS(i);
        }
        // 최소값 찾기
        int min = 100;
        for(int i=1; i<N; i++){min = Math.min(min, score[i]);}
        // 회장 후보 찾기
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++){
            if(score[i]==min){
                cnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(min + " " + cnt);
        System.out.println(sb);

    }

    public static void BFS(int node){
        int s = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visit[node] = s; // 시작점은 0으로

        while(!q.isEmpty()){
            int qsize = q.size();
            s++;
            for(int i=0; i<qsize; i++){
                int next = q.poll();
                for(int j : list.get(next)){
                    if(visit[j]==-1){
                        visit[j] = s;
                        q.add(j);
                    }
                }

            }
        }
        score[node] = s-1;
    }
}