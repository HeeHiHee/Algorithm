class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. (갈색 칸 수 + 노랑색 칸 수)의 약수를 구함(세로길이 3이상)
        // 2. (세로-2)*(가로-2) = 노랑색 칸 수 이면 그게 정답임 
        
        int R = 0; // 가로 길이
        int C = 0; // 세로 길이 
        int N = brown + yellow;
        
        int[] res = new int[2];
        
        out :
        for(int i=3; i<=N; i++){
            if(N%i==0){
                C = i;
                R = N/i;
                int isYellow = (C-2) * (R-2);
                if(isYellow == yellow){
                    res[0] = R;
                    res[1] = C;
                    
                    break out;
                }
                
            }
            
        }
        
        return res;
        
        
    }
}