import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, room[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }
        // 회의는 {시작시간, 끝시간} 2개의 값을 가지는 배열이고,
        // 회의 2개의 시작시간(a[0], b[0])을 비교하여 오름차순으로 정렬한다.
        // 시작 시간이 같으면 끝나는 시간도 오름차순으로 정렬한다.
        Arrays.sort(room, (a,b)->{
            if(a[0]==b[0]) return (a[1]-b[1]);
            return (a[0]-b[0]);
        });

        int cnt = 0; // 회의 최대 개수
        int idx = 0; // 다음 탐색을 시작할 인덱스 번호
        int min = Integer.MAX_VALUE; // 가장 빠르게 회의 끝나는 시간
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=idx; i<N; i++){
                if(room[i][0]>=min) {
                    idx = i;
                    flag = true;
                    break;
                }
                if(min>room[i][1]){min = room[i][1];}
            }
            cnt++;
            min = Integer.MAX_VALUE; // 초기화
        }
        System.out.println(cnt);
    }

}