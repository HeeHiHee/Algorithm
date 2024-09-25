import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        // 스택에 문자를 하나씩 넣어
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }
        
        // 스택에서 문자 하나씩 꺼내
        int cnt = 0;
        while(!stack.isEmpty()){
            Character str = stack.pop();
            if(str == ')'){
                cnt++;
            }else{
                cnt--;
                if(cnt<0) {
                    answer = false;
                    break;
                }
                
            }
        }
        if(cnt == 0) answer = true;
        
        return answer;
        
        
        
        
    }
}