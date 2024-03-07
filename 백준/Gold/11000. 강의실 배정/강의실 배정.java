import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static class Time {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }//Time

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Time[] lec = new Time[N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lec[i] = new Time(s,e);
        }

        // 강의 시작시간을 오름차순으로 정렬
        // 시작시간이 같으면 끝나는 시간을 오름차순으로 정렬
        Arrays.sort(lec, (l1,l2) -> l1==l2 ? l1.end-l2.end : l1.start-l2.start);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(lec[0].end);

        // 강의 끝나는 시간보다 시작시간이 크거나 같으면 같은 강의실에 배정
        // 작으면 다른 강의실에 배정
        for(int i=1; i<N; i++) {
            if(lec[i].start >= q.peek()) {
                q.poll();
            }
            q.offer(lec[i].end);
        }

        System.out.println(q.size());

    }//main
}