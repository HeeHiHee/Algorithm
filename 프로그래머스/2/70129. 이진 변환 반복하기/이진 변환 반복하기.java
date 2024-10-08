import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        int ch = 0; // 변환 횟수
        int zero = 0; // 제거한 0 개수
        String ans = s;
        //1. split으로 잘라
        //2. 배열 돌면서 0이면 카운트 올리고, 1이면 문자열에 더해
        //3. 끝난 문자열의 길이를 구하고, 이진변환
        //4. 이진변환 값이 1이 아니라면 1부터 반복
        while(!ans.equals("1")){            
            ch++; // 변환횟수 1증가
            String[] st = ans.split(""); // 문자열 분리
            String deleteZero = ""; // 0 제거한 문자열
            for(String v : st){
                if(v.equals("0")){
                    zero++;
                }else{
                    deleteZero += v;
                }                
            }
            int finishLen = deleteZero.length(); // 0 제거 후 길이
            ans = Integer.toBinaryString(finishLen); // 2진수 변환
            
        }
        int[] answer = {ch, zero};
        return answer;
        
    }
}