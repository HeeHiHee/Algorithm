import java.util.*;
class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        // 구분자도 반환
        StringTokenizer st = new StringTokenizer(s, " ", true);
        // 단어 하나씩 꺼내 
        int cnt = st.countTokens();
        for(int i=0; i<cnt; i++){
            String word = st.nextToken();
            // System.out.println(word);
            if(word.equals(" ")){
                sb.append(word);
                continue;
            }else{
                for(int j=0; j<word.length(); j++){
                    char ch = word.charAt(j);
                    // 첫 글자가 소문자이면
                    if(j==0){
                        if((int)ch>=97 && (int)ch<=122){
                            char toCh = (char)(ch-32);
                            sb.append(toCh);                            
                        }else{
                            sb.append(ch);
                        }
                    }else{
                        // 나머지 글자 중 대문자가 있으면
                        if((int)ch>=65 && (int)ch<=90){
                            char toCh = (char)(ch+32);
                            sb.append(toCh);
                        }else{
                            sb.append(ch);

                        }
                    }                
                }
                
            }
            
            
        }
        String answer = sb.toString();
        return answer;
    }
}