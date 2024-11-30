import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cost[];
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static PriorityQueue<Node> q = new PriorityQueue<>((a,b)->(a.cost-b.cost));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine())+1;
        M = Integer.parseInt(br.readLine());
        cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        cost[start] = 0;
        ArrayList<Integer> road = new ArrayList<>();
        road.add(start);
        q.add(new Node(start, 0, road));
        while (!q.isEmpty()){
            Node current = q.poll();
            int curNode = current.node;
            int curCost = current.cost;
            ArrayList<Integer> curList = current.list;
            if(curCost>cost[curNode]) continue;
            if(curNode==end){
                sb.append(curCost).append("\n").append(curList.size()).append("\n");
                for(int i=0; i<curList.size(); i++){
                    sb.append(curList.get(i)).append(" ");
                }
                break;
            }
            for(int[] e : list.get(curNode)){
                int nextNode = e[0];
                int nextCost = curCost + e[1];
                if(nextCost<cost[nextNode]){
                    cost[nextNode] = nextCost;
                    ArrayList<Integer> nextList = new ArrayList<>(curList);
                    nextList.add(nextNode);
                    q.add(new Node(nextNode, nextCost, nextList));
                }
            }
        }
        System.out.println(sb);
    }
    public static class Node{
        int node;
        int cost;
        ArrayList<Integer> list;
        public Node(int node, int cost, ArrayList<Integer> list){
            this.node = node;
            this.cost = cost;
            this.list = list;
        }
    }
}