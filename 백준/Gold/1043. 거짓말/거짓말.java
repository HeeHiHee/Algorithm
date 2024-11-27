import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, tree[];
    static boolean know[]; // true : 진실을 말해야하는 사람
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1; M = sc.nextInt();
        know = new boolean[N];
        tree = new int[N];
        Arrays.fill(tree, -1);
        int knowCnt = sc.nextInt();
        for(int i=0; i<knowCnt; i++){
            int n = sc.nextInt(); // 진실 아는 사람
            know[n] = true; // 진실 아는 사람 표시
        }
        // 파티의 수 만큼 반복
        for(int i=0; i<M; i++){
            int partyNum = sc.nextInt(); // 파티마다 오는 사람 수
            int[] party = new int[partyNum]; // 파티마다 오는 사람 저장
            for(int j=0; j<partyNum; j++){
                party[j] = sc.nextInt();
            }
            q.add(party); // 큐에 파티 추가
            // 같은 파티에 오는 사람들(2명이상이면) 그룹으로 묶기
            for(int j=1; j<partyNum; j++){
                uni(party[0], party[j]);
            }
        }
        // 진실을 말해야하는 사람 갱신해주기
        for(int i=1; i<N; i++){
            if(know[i]) know[find(i)] = true;
        }
        // 큐에서 파티를 꺼내면서 파티 개수 구하기
        int max = 0;
        while (!q.isEmpty()){
            int[] get = q.poll();
            if(!know[find(get[0])]) max++;
        }
        System.out.println(max);
    }
    public static void uni(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) tree[y] = x;
    }
    public static int find(int x){
        if(tree[x]<0) return x;
        return tree[x] = find(tree[x]);
    }
}