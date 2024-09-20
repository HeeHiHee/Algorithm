import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int cnt = st.countTokens(); // 토큰 개수
        
        int min = 987654321;
        int max = -987654321;
        for(int i=0; i<cnt; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp < min){
                min = tmp;
            }
            if(tmp > max){
                max = tmp;
            }
        }        

        return min + " " + max;
        
    }
}