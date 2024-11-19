import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, edge;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드와 간선 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        // 간선 정보 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u); // 무방향 그래프
        }

        int compnt = 0; // 연결 컴포넌트 개수

        // 모든 노드를 탐색하며 컴포넌트 개수와 사이클 간선을 계산
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                compnt++;
                DFS1(i, -1); // -1은 부모 노드가 없음을 의미
            }
        }

        // 사이클 간선은 DFS에서 중복 계산되므로 절반으로 나누기
        System.out.println(edge / 2 + (compnt - 1));
    }

    public static void DFS1(int node, int parent) {
        visit[node] = true;
        for (int n : list.get(node)) {
            if (!visit[n]) {
                DFS1(n, node);
            } else if (n != parent) {
                // 방문했지만 부모 노드가 아닌 경우, 사이클 간선 발견
                edge++;
            }
        }
    }
}