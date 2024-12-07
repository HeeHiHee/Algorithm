import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, period[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        period = new int[N][4];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                period[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 오름차순 정렬
        Arrays.sort(period, (a,b)->{
            if(a[0]!=b[0]) return (a[0]-b[0]);
            if(a[1]!=b[1]) return (a[1]-b[1]);
            if(a[2]!=b[2]) return (b[2]-a[2]);
            return (b[3]-a[3]);
        });
        int startM = 3, startD = 1; // 꽃이 피는 날
        int endM = 0, endD = 0; // 꽃이 지는 날
        int idx = 0;
        int ans = 0; // 선택한 꽃 개수
        while (startM<11 || (startM==11 && startD<=30)){
            for(int i=idx; i<N; i++){
                if(period[i][0]<startM || (period[i][0]==startM && period[i][1]<=startD)){
                    if(period[i][2]>endM || (period[i][2]==endM && period[i][3]>endD)){
                        endM = period[i][2];
                        endD = period[i][3];
                    }
                } else {idx = i; break;}
            }
            if(startM==endM && startD==endD){ans=-1; break;}
            ans++; // 꽃 선택
            startM = endM; startD = endD; // 다음 꽃이 지는 날을 피는 날로 갱신
        }
        System.out.println(ans==-1?0:ans);
    }
}